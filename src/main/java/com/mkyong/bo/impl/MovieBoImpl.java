package com.mkyong.bo.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.mkyong.bo.MoviesBo;
import com.mkyong.dto.MovieDto;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Dec 18, 2014, 1:16:21 AM
 */
@Service
public class MovieBoImpl implements MoviesBo {

	@Override
	public MovieDto getInfoMovie(final String request) {
		MovieDto movie = new MovieDto();
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		movie.setName("(R-" + request + ") Kill-Bill");
		movie.setYear(2006);
		movie.setDirector("(R-" + request + ") Quenteen Tarantino");
		
		return movie;
	}

}