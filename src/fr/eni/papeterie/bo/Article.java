package fr.eni.papeterie.bo;

/**
 * Classe qui modélise un article d'une boutique de papeterie
 * 
 * @author benocode
 * @date 02/01/2023
 */
public abstract class Article {

	private Integer idArticle;
	private String reference;
	private String marque;
	private String designation;
	private float prixUnitaire;
	private int qteStock;

	/**
	 * Constructeurs tous paramètres
	 * 
	 * @param idArticle
	 * @param reference
	 * @param marque
	 * @param designation
	 * @param prixUnitaire
	 * @param qteStock
	 */
	public Article(Integer idArticle, String reference, String marque, String designation, float prixUnitaire,
			int qteStock) {
		this.idArticle = idArticle;
		this.reference = reference;
		this.marque = marque;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
	}

	/**
	 * Constructeurs avec paramètres (sauf idArticle)
	 * 
	 * @param reference
	 * @param marque
	 * @param designation
	 * @param prixUnitaire
	 * @param qteStock
	 */
	public Article(String reference, String marque, String designation, float prixUnitaire, int qteStock) {
		this.reference = reference;
		this.marque = marque;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
	}

	/**
	 * Méthode getter pour récupérer l'id de l'article
	 * 
	 * @return l'id de l'article
	 */
	public Integer getIdArticle() {
		return idArticle;
	}

	/**
	 * Méthode getter pour récupérer la référence de l'article
	 * 
	 * @return la reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * Méthode getter pour récupérer la marque de l'article
	 * 
	 * @return la marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * Méthode getter pour récupérer la désignation de l'article
	 * 
	 * @return la designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Méthode getter pour récupérer le prix unitaire de l'article
	 * 
	 * @return le prix Unitaire
	 */
	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	/**
	 * Méthode getter pour récupérer la quantité en stock de l'article
	 * 
	 * @return la qte en Stock
	 */
	public int getQteStock() {
		return qteStock;
	}

	/**
	 * Méthode setter pour modifier l'id d'un article
	 * 
	 * @param idArticle : le nouvel id de l'article
	 */
	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	/**
	 * Méthode setter pour modifier la référence d'un article
	 * 
	 * @param reference : la nouvelle reference
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * Méthode setter pour modifier la marque d'un article
	 * 
	 * @param marque : la nouvelle marque
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * Méthode setter pour modifier la désignation d'un article
	 * 
	 * @param designation : la nouvelle designation
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Méthode setter pour modifier le prix unitaire d'un article
	 * 
	 * @param prixUnitaire : le nouveau prix unitaire
	 */
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	/**
	 * Méthode setter pour modifier la quantité en stock d'un article
	 * 
	 * @param qteStock : la nouvelle qte en stock
	 */
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	@Override
	public String toString() {
		return //TODO
	}

}
