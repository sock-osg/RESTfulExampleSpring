package com.mkyong.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mkyong.dto.MovieDto;
import com.mkyong.facade.MoviesFacade;

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
	public Response getInfoMovie(@PathParam("request") String request) {
		final List<MovieDto> result = this.facMovie.getInfoMovie(request);
		return Response.ok(result).build();
	}

}
