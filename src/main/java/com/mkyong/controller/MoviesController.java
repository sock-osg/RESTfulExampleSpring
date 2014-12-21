package com.mkyong.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mkyong.exception.MyCustomException;
import com.mkyong.facade.MoviesFacade;
import com.mkyong.request.InfoMovieRQ;
import com.mkyong.response.MovieRS;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Dec 18, 2014, 1:27:57 AM
 */
@Controller
@Path("/movies")
public class MoviesController {

	@Autowired
	private MoviesFacade facMovie;

	@GET
	@Path("/getInfoMovie/{request}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInfoMovie(@PathParam("request") int request) throws MyCustomException {
		List<MovieRS> result = null;
		
		try {
			result = this.facMovie.getInfoMovie(request);
		} catch (MyCustomException myCusExc) {
			myCusExc.setRequestController(request);
			throw myCusExc;
		}
		
		return Response.ok(result).build();
	}
	
	@POST
	@Path("/getInfoMovie")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getInfoMovie(InfoMovieRQ request) throws MyCustomException {
		List<MovieRS> result = null;
		
		try {
			result = this.facMovie.getInfoMovie(request);
		} catch (MyCustomException myCusExc) {
			myCusExc.setRequestController(request);
			throw myCusExc;
		}
		
		return Response.ok(result).build();
	}

}
