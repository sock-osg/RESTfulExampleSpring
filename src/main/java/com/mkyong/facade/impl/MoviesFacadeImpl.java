/*
 * com.mkyong.facade.impl.MoviesFacadeImpl
 */
package com.mkyong.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mkyong.bo.MoviesBo;
import com.mkyong.exception.MyCustomException;
import com.mkyong.facade.MoviesFacade;
import com.mkyong.request.InfoMovieRQ;
import com.mkyong.response.MovieRS;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Dec 18, 2014, 1:17:31 AM
 */
@Component
public class MoviesFacadeImpl implements MoviesFacade {

	@Autowired
	private MoviesBo boMovies;
	
	@Override
	public List<MovieRS> getInfoMovie(InfoMovieRQ request) throws MyCustomException {
		return this.getInfoMovie(request.getIdRequest());
	}
	
	@Override
	public List<MovieRS> getInfoMovie(final int request) throws MyCustomException {
		if (request == 500) {
			throw new MyCustomException();
		}
		
		List<MovieRS> movies = new ArrayList<>();
		
		AsyncMoviesBo asyncMovie1 = new AsyncMoviesBo(this.boMovies, request);
		Thread threadMovie1 = new Thread(asyncMovie1);
		AsyncMoviesBo asyncMovie2 = new AsyncMoviesBo(this.boMovies, request);
		Thread threadMovie2 = new Thread(asyncMovie2);
		AsyncMoviesBo asyncMovie3 = new AsyncMoviesBo(this.boMovies, request);
		Thread threadMovie3 = new Thread(asyncMovie3);
		AsyncMoviesBo asyncMovie4 = new AsyncMoviesBo(this.boMovies, request);
		Thread threadMovie4 = new Thread(asyncMovie4);
		AsyncMoviesBo asyncMovie5 = new AsyncMoviesBo(this.boMovies, request);
		Thread threadMovie5 = new Thread(asyncMovie5);
		
		threadMovie1.start();
		threadMovie2.start();
		threadMovie3.start();
		threadMovie4.start();
		threadMovie5.start();
		
		try {
			threadMovie1.join();
			threadMovie2.join();
			threadMovie3.join();
			threadMovie4.join();
			threadMovie5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		movies.add(asyncMovie1.getResult());
		movies.add(asyncMovie2.getResult());
		movies.add(asyncMovie3.getResult());
		movies.add(asyncMovie4.getResult());
		movies.add(asyncMovie5.getResult());
		return movies;
	}
	
	private class AsyncMoviesBo implements Runnable {
		
		private MoviesBo boMovies;
		private MovieRS result;
		private int request;
		
		/** Crea una nueva instancia de la clase. */
		public AsyncMoviesBo(MoviesBo boMovies, int request) {
			super();
			this.boMovies = boMovies;
			this.request = request;
		}

		@Override
		public void run() {
			this.result = this.boMovies.getInfoMovie(this.request);
		}
		
		public MovieRS getResult() {
			return this.result;
		}
		
	}

}
