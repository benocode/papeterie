package fr.eni.papeterie.bo;

/**
 * Classe qui modélise une ramette de papier
 * 
 * @author benocode
 * @date 02/01/2023
 */
public class Ramette extends Article {

	private int grammage;

	/**
	 * Constructeur avec paramètres de la classe Article
	 * 
	 * @param idArticle
	 * @param reference
	 * @param marque
	 * @param designation
	 * @param prixUnitaire
	 * @param qteStock
	 */
	public Ramette(Integer idArticle, String reference, String marque, String designation, float prixUnitaire,
			int qteStock) {
		super(idArticle, reference, marque, designation, prixUnitaire, qteStock);
	}

	/**
	 * Constructeur tous paramètres
	 * 
	 * @param idArticle
	 * @param reference
	 * @param marque
	 * @param designation
	 * @param prixUnitaire
	 * @param qteStock
	 * @param grammage
	 */
	public Ramette(Integer idArticle, String marque, String reference, String designation, float prixUnitaire,
			int qteStock, int grammage) {
		super(idArticle, reference, marque, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}

	/**
	 * Constructeur avec paramètres (sauf id article)
	 * 
	 * @param idArticle
	 * @param reference
	 * @param marque
	 * @param designation
	 * @param prixUnitaire
	 * @param qteStock
	 */
	public Ramette(String marque, String reference, String designation, float prixUnitaire, int qteStock,
			int grammage) {
		super(reference, marque, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}

	/**
	 * Méthode getter pour récupérer le grammage d'une ramette papier
	 * 
	 * @return le grammage
	 */
	public int getGrammage() {
		return grammage;
	}

	/**
	 * Méthode setter pour modifier le grammage d'une ramette papier
	 * 
	 * @param grammage : le nouveau grammage
	 */
	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}

	@Override
	public String toString() {
		return String.format("%sRamette [grammage=%d]", super.toString(), grammage);
	}

}
