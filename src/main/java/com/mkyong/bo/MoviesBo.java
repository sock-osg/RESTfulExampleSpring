package com.mkyong.bo;

import com.mkyong.response.MovieRS;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Dec 18, 2014, 1:27:32 AM
 */
public interface MoviesBo {
	
	MovieRS getInfoMovie(int request);
	
}