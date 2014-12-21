/*
 * com.mkyong.aspect.AbstractAspect
 */
package com.mkyong.aspect;

import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.JoinPoint;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mkyong.request.InfoMovieRQ;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Dec 20, 2014, 6:52:37 PM
 */
public abstract class AbstractAspect {
	
	protected Gson gsonMarshaller;
	
	/** Crea una nueva isntancia de la clase. */
	public AbstractAspect() {
		super();
		this.gsonMarshaller = new GsonBuilder().setPrettyPrinting().create();
	}
	
	protected String getRequestAsJson(final JoinPoint joinPoint) {
		final Object[] args = joinPoint.getArgs();
		String jsonRS = null;
		
		if (ArrayUtils.isNotEmpty(args)) {
			final Object request = args[0];
			
			if (request instanceof InfoMovieRQ) {
				jsonRS = this.gsonMarshaller.toJson(request);
			}
		}
		
		return jsonRS;
	}

}
