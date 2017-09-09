
package org.qcri.micromappers.uav.exception;

/**
 * 
 * @author Kushal
 *
 */
public class MicromappersException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8749840246686260688L;
	//	private String message = null;
	private String type = null;
	private String errorCode = null;
	
	public MicromappersException() {
		super();
	}
	public MicromappersException(String message, Throwable cause, String errorCode, String type) {
		super(message, cause);
		this.errorCode = errorCode;
		this.type = type;
	}
		
	public MicromappersException(String message, String errorCode, String type) {
		super(message);
		this.errorCode = errorCode;
		this.type = type;
	}

	public MicromappersException(Throwable cause) {
		super(cause);
	}
	
	public MicromappersException(String exception) {
		super(exception);
	}
	
	public MicromappersException(String exception,Throwable cause) {
		super(exception,cause);
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public String getType() {
		return type;
	}
}
