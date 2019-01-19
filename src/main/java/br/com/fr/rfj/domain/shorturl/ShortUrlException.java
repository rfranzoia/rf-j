package br.com.fr.rfj.domain.shorturl;

public class ShortUrlException extends Exception {

	private static final long serialVersionUID = 1L;

	public ShortUrlException() {
	}

	public ShortUrlException(String message) {
		super(message);
	}

	public ShortUrlException(Throwable cause) {
		super(cause);
	}

	public ShortUrlException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShortUrlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
