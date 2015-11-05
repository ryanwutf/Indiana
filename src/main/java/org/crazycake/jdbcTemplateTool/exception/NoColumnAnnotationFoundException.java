package org.crazycake.jdbcTemplateTool.exception;

import java.lang.reflect.Method;

public class NoColumnAnnotationFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2938045160793785266L;

	public NoColumnAnnotationFoundException(String ClassName,Method getter){
		super(ClassName + "." + getter.getName() + "() should have an @Column annotation.");
	}
}
