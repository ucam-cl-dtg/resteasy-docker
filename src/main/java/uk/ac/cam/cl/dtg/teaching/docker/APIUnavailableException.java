package uk.ac.cam.cl.dtg.teaching.docker;

public class APIUnavailableException extends Exception {

	private static final long serialVersionUID = 1L;

	public APIUnavailableException() {
	}

	public APIUnavailableException(String message) {
		super(message);
	}

	public APIUnavailableException(Throwable cause) {
		super(cause);
	}

	public APIUnavailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public APIUnavailableException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
