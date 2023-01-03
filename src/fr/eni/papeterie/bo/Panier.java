package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui modélise un panier d'achat en ligne
 * 
 * @author benocode
 * @date 02/01/2023
 */
public class Panier {

	private float montant;
	private List<Ligne> lignesPanier;

	/**
	 * Constructeur sans paramètres
	 */
	public Panier() {
		lignesPanier = new ArrayList<Ligne>();
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
		return lignesPanier.get(index);
	}

	/**
	 * Méthode pour récupérer la liste d'achats du panier
	 * @return les lignes du panier d'achat
	 */
	public List<Ligne> getLignesPanier() {
		return lignesPanier;
	}

	/**
	 * Méthode pour ajouter un article dans le panier
	 * 
	 * @param article
	 * @param qte
	 */
	public void addLigne(Article article, int qte) {
		Ligne nouvelleLigne = new Ligne(article, qte);
		lignesPanier.add(nouvelleLigne);
		montant = calcul(lignesPanier);
	}

	/**
	 * Méthode pour modifier la quantité d'un article du panier
	 * 
	 * @param index  : numéro de ligne de l'article à modifier
	 * @param newQte : nouvelle quantité
	 */
	public void updateLigne(int index, int newQte) {
//		this.getLigne(index).setQte(newQte);
		lignesPanier.get(index).setQte(newQte);
		montant = calcul(lignesPanier);
	}

	/**
	 * Méthode pour supprimer une ligne du panier
	 * 
	 * @param index : numéro de ligne de l'article à supprimer
	 */
	public void removeLigne(int index) {
		lignesPanier.remove(index);
		montant = calcul(lignesPanier);
	}

	@Override
	public String toString() {
		StringBuilder listeAchats = new StringBuilder();
		for (Ligne ligne : lignesPanier) {
			if (ligne != null) {
				listeAchats.append(String.format("ligne %d :     %s%n", lignesPanier.indexOf(ligne), ligne.toString()));
			} else
				break;
		}
		return String.format("Panier :%n%n%s%nValeur du panier : %.01f", listeAchats, getMontant());
	}

	private float calcul(List<Ligne> lignesPanier) {
		float resultat = 0;
		for (Ligne ligne : lignesPanier) {
			if (ligne != null) {
				resultat += ligne.getPrix();
			} else
				break;
		}
		return resultat;
	}
}
