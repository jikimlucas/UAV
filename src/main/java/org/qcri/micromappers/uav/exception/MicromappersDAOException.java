package org.qcri.micromappers.uav.exception;

/**
 * 
 * @author Kushal
 * 
 */
public class MicromappersDAOException extends MicromappersException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4413021129468336522L;

	/**
	 * default constructor
	 */
	public MicromappersDAOException() {
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
	public MicromappersDAOException(String message, Throwable cause, String errorCode, String type) {
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
	public MicromappersDAOException(String message, String errorCode, String type) {
		super(message, errorCode, type);
	}

	/**
	 * constructor with one argument
	 * 
	 * @param cause
	 */
	public MicromappersDAOException(Throwable cause) {
		super(cause);
	}

}
