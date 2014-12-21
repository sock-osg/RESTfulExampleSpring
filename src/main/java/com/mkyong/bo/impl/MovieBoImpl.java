package com.mkyong.bo.impl;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.mkyong.bo.MoviesBo;
import com.mkyong.response.MovieRS;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Dec 18, 2014, 1:16:21 AM
 */
@Service
public class MovieBoImpl implements MoviesBo {
	
	@Override
	public MovieRS getInfoMovie(final int request) {
		MovieRS movie = new MovieRS();
		
		try {
			Random random = new Random();
			int sleep = random.nextInt(10);
			System.out.printf("Sleeping for %d seconds.\n", sleep);
			TimeUnit.SECONDS.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		movie.setName("(R-" + request + ") Kill-Bill");
		movie.setYear(2006);
		movie.setDirector("(R-" + request + ") Quenteen Tarantino");
		
		return movie;
	}

}