/*
 * com.mkyong.exception.MyCustomException
 */
package com.mkyong.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Dec 20, 2014, 9:42:19 AM
 */
public class MyCustomException extends BaseException {
	
	@Setter
	@Getter
	private Object RequestController;

	/** Identificador unico de la clase. */
	private static final long serialVersionUID = -3196647773753776290L;

}
