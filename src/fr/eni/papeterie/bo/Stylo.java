package fr.eni.papeterie.bo;

/**
 * Classe qui modélise un stylo
 * 
 * @author benocode
 * @date 02/01/2023
 */
public class Stylo extends Article {

	private String couleur;

	/**
	 * Constructeur avec paramètres de la classe Article
	 * 
	 * @param idArticle
	 * @param marque
	 * @param reference
	 * @param designation
	 * @param prixUnitaire
	 * @param qteStock
	 */
	public Stylo(Integer idArticle, String marque, String reference, String designation, float prixUnitaire,
			int qteStock) {
		super(idArticle, marque, reference, designation, prixUnitaire, qteStock);
	}

	/**
	 * Constructeurs tous paramètres
	 * 
	 * @param idArticle
	 * @param marque
	 * @param reference
	 * @param designation
	 * @param prixUnitaire
	 * @param qteStock
	 * @param couleur
	 */
	public Stylo(Integer idArticle, String marque, String reference, String designation, float prixUnitaire,
			int qteStock, String couleur) {
		super(idArticle, marque, reference, designation, prixUnitaire, qteStock);
		this.couleur = couleur;
	}

	/**
	 * Constructeur avec paramètres (sauf id article)
	 * 
	 * @param marque
	 * @param reference
	 * @param designation
	 * @param prixUnitaire
	 * @param qteStock
	 * @param couleur
	 */
	public Stylo(String marque, String reference, String designation, float prixUnitaire, int qteStock,
			String couleur) {
		super(marque, reference, designation, prixUnitaire, qteStock);
		this.couleur = couleur;
	}

	/**
	 * Méthode getter pour récupérer la couleur d'un stylo
	 * 
	 * @return la couleur
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * Méthode setter pour modifier la couleur d'un stylo
	 * 
	 * @param couleur : la nouvelle couleur
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return String.format("%sStylo [Couleur=%s]", super.toString(), couleur);
	}

}
