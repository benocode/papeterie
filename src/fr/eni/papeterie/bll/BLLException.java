package fr.eni.papeterie.bll;

import java.util.ArrayList;
import java.util.List;

public class BLLException extends Exception {

	private static final long serialVersionUID = 1L;

	private List<String> erreurs;

// Constructeurs

	/**
	 * Constructeur sans paramètres qui instancie une liste d'erreurs
	 */
	public BLLException() {
		erreurs = new ArrayList<String>();
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

	public List<String> getErreurs() {
		return erreurs;
	}

	public void ajouterErreur(String message) {
		erreurs.add(message);
	}
}
