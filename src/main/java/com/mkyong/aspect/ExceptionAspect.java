/*
 * com.mkyong.aspect.ExceptionAspect
 */
package com.mkyong.aspect;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.mkyong.exception.MyCustomException;
import com.mkyong.request.InfoMovieRQ;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Dec 20, 2014, 9:36:31 AM
 */
@Slf4j
@Aspect
@Component
public class ExceptionAspect extends AbstractAspect {
	
	/** Crea una nueva instancia de la clase. */
	public ExceptionAspect() {
		super();
	}

	@AfterThrowing(pointcut = "execution(* com.mkyong.controller.**.*(..))", throwing = "exception")
	public void exceptionInterceptor(final JoinPoint joinPoint, final MyCustomException exception) {
		final Object[] args = joinPoint.getArgs();
		
		if (ArrayUtils.isNotEmpty(args)) {
			final Object requestController = args[0];
			
			if (requestController instanceof InfoMovieRQ) {
				final String requestJson = this.gsonMarshaller.toJson(requestController);
				log.error("!! Se ha producido una excepcion con la siguiente peticion:\n{}", requestJson);
			}
		}
	}

}
