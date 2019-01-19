package br.com.fr.rfj.exception;

public class ShortnerException extends Exception {

	private static final long serialVersionUID = 1L;

	public ShortnerException() {
	}

	public ShortnerException(String message) {
		super(message);
	}

	public ShortnerException(Throwable cause) {
		super(cause);
	}

	public ShortnerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShortnerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
