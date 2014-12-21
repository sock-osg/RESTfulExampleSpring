/*
 * com.mkyong.aspect.SuccessResponseAspect
 */
package com.mkyong.aspect;

import javax.ws.rs.core.Response;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Dec 20, 2014, 6:56:17 PM
 */
@Slf4j
@Aspect
@Component
public class SuccessResponseAspect extends AbstractAspect {
	
	@Before("execution(* com.mkyong.controller.**.*(..))")
	public void beforeSuccessInterceptor(final JoinPoint joinPoint) {
		log.error("== Consultando :\n{}", this.getRequestAsJson(joinPoint));
	}
	
	@AfterReturning(pointcut = "execution(* com.mkyong.controller.**.*(..))", returning = "response")
	public void afterSuccessInterceptor(final JoinPoint joinPoint, final Object response) {
		final Response resp = (Response) response;
		
		if (resp != null) {
			final String requestJson = this.gsonMarshaller.toJson(resp.getEntity());
			log.error("== Resultado exitoso ==\nPeticion : {}\nRespuesta :\n{}",
					this.getRequestAsJson(joinPoint), requestJson);
		}
	}

}
