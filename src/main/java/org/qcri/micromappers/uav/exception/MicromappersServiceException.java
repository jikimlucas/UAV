package org.qcri.micromappers.uav.exception;

/**
 * 
 * @author Kushal
 * 
 */

public class MicromappersServiceException extends MicromappersException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3154506436067997190L;

	/**
	 * default constructor
	 */
	public MicromappersServiceException() {
		super();
	}

	/**
	 * constructor with argument message,cause, errorCode and type of error
	 * 
	 * @param message
	 *            exception message
	 * @param cause
	 * @param errorCode
	 *            code of error
	 * @param type
	 *            error type
	 */
	public MicromappersServiceException(String message, Throwable cause, String errorCode, String type) {
		super(message, cause, errorCode, type);
	}

	/**
	 * constructor with argument message,errorCode and type
	 * 
	 * @param message
	 *            exception message
	 * @param errorCode
	 *            code of error
	 * @param type
	 *            error type
	 */
	public MicromappersServiceException(String message, String errorCode,	String type) {
		super(message, errorCode, type);
	}

	/**
	 * constructor with one argument
	 * 
	 * @param cause
	 */
	public MicromappersServiceException(Throwable cause) {
		super(cause);
	}
	
	public MicromappersServiceException(String message,Throwable cause) {
		super(message,cause);
	}
	
	public MicromappersServiceException(String message) {
		super(message);
	}
}
