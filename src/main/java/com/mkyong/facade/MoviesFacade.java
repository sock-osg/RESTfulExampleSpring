/*
 * com.mkyong.facade.MoviesFacade
 */
package com.mkyong.facade;

import java.util.List;

import com.mkyong.dto.MovieDto;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Dec 18, 2014, 1:17:07 AM
 */
public interface MoviesFacade {

	List<MovieDto> getInfoMovie(String request);

}
