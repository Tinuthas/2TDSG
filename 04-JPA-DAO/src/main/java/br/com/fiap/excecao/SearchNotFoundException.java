package br.com.fiap.excecao;

public class SearchNotFoundException extends Exception {

	public SearchNotFoundException() {
		super();
	}

	public SearchNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SearchNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SearchNotFoundException(String message) {
		super(message);
	}

	public SearchNotFoundException(Throwable cause) {
		super(cause);
	}
	
	
}
