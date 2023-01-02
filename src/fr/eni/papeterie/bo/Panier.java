package fr.eni.papeterie.bo;

import java.util.List;

/**
 * Classe qui modélise un panier d'achat en ligne
 * 
 * @author benocode
 * @date 02/01/2023
 */
public class Panier {

	private float montant;

	/**
	 * Constructeur sans paramètres
	 */
	public Panier() {
	}

	/**
	 * Méthode getter pour montant
	 * 
	 * @return le montant d'achat du panier
	 */
	public float getMontant() {
		return montant;
	}

	/**
	 * Méthode pour récupérer le détail d'un achat de la liste
	 * @param index
	 * @return la ligne de la liste d'achat
	 */
	public Ligne getLigne(int index) {
		return //TODO;
	}

	/**
	 * Méthode pour récupérer la liste d'achats du panier
	 * @return les lignes du panier d'achat
	 */
	public List<Ligne> getLignesPanier() {
		return //TODO;
	}

	/**
	 * Méthode pour ajouter un article dans le panier
	 * 
	 * @param article
	 * @param qte
	 */
	public void addLigne(Article article, int qte) {
		// TODO
	}

	/**
	 * Méthode pour modifier la quantité d'un article du panier
	 * 
	 * @param index  : numéro de ligne de l'article à modifier
	 * @param newQte : nouvelle quantité
	 */
	public void updateligne(int index, int newQte) {
		// TODO
	}

	/**
	 * Méthode pour supprimer une ligne du panier
	 * 
	 * @param index : numéro de ligne de l'article à supprimer
	 */
	public void removeLigne(int index) {
		// TODO
	}

	@Override
	public String toString() {
		return //TODO
	}
}
