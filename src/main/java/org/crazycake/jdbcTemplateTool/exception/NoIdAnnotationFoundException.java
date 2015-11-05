package org.crazycake.jdbcTemplateTool.exception;

public class NoIdAnnotationFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 518010788249827317L;

	public NoIdAnnotationFoundException(Class clazz){
		super(clazz + " doesn't have an id field, please make sure the getters of " + clazz + " contain a column with an @id annotation. Note: remember to add annotation above getter instead of attribute itself.");
	}
}
