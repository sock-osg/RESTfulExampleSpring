/*
 * com.mkyong.facade.MoviesFacade
 */
package com.mkyong.facade;

import java.util.List;

import com.mkyong.exception.MyCustomException;
import com.mkyong.request.InfoMovieRQ;
import com.mkyong.response.MovieRS;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Dec 18, 2014, 1:17:07 AM
 */
public interface MoviesFacade {

	List<MovieRS> getInfoMovie(int request) throws MyCustomException;
	
	List<MovieRS> getInfoMovie(InfoMovieRQ request) throws MyCustomException;

}
