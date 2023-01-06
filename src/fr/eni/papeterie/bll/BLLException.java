package fr.eni.papeterie.bll;

public class BLLException extends Exception {

	private static final long serialVersionUID = 1L;

// Constructeurs	

	public BLLException() {
		super();
	}

	public BLLException(String message) {
		super(message);
	}

	public BLLException(String message, Throwable exception) {
		super(message, exception);
	}

// Méthodes

	@Override
	public String getMessage() {
		return "BLL - " + super.getMessage();
	}
}
