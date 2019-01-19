package br.com.fr.rfj.exception;

public class RedirectorException extends Exception {

	private static final long serialVersionUID = 1L;

	public RedirectorException() {
	}

	public RedirectorException(String message) {
		super(message);
	}

	public RedirectorException(Throwable cause) {
		super(cause);
	}

	public RedirectorException(String message, Throwable cause) {
		super(message, cause);
	}

	public RedirectorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
