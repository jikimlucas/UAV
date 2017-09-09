package org.qcri.micromappers.uav.exception;

/**
 * 
 * @author Kushal
 * 
 */
public class MicromappersUserExistException extends MicromappersException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4413021129468336522L;

	/**
	 * default constructor
	 */
	public MicromappersUserExistException() {
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
	public MicromappersUserExistException(String message, Throwable cause, String errorCode, String type) {
		super(message, cause, errorCode, type);
	}

	/**
	 * constructor with argument message,errorCode and error type
	 * 
	 * @param message
	 *            exception message
	 * @param errorCode
	 *            code of error
	 * @param type
	 *            error type
	 */
	public MicromappersUserExistException(String message, String errorCode, String type) {
		super(message, errorCode, type);
	}

	/**
	 * constructor with one argument
	 * 
	 * @param cause
	 */
	public MicromappersUserExistException(Throwable cause) {
		super(cause);
	}

	public MicromappersUserExistException(String message) {
		super(message);
	}

}
