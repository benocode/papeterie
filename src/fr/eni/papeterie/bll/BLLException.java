package fr.eni.papeterie.bll;

import java.util.ArrayList;
import java.util.Arrays;
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

	/**
	 * Retourne toutes les erreurs de la liste sous la forme d'une chaîne de
	 * caractères
	 */
	@Override
	public String getMessage() {
		return Arrays.toString(erreurs.toArray());
	}

	public List<String> getErreurs() {
		return erreurs;
	}

	public void ajouterErreur(String message) {
		erreurs.add(message);
	}
}
