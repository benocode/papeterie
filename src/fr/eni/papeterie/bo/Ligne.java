package fr.eni.papeterie.bo;

/**
 * Classe qui modélise une ligne du panier d'achat
 * 
 * @author benocode
 * @date 02/01/2023
 */
public class Ligne {

	protected int qte;
	protected Article article;
	private float prix;

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param article
	 * @param qte
	 */
	public Ligne(Article article, int qte) {
//		this.article = article;
//		this.qte = qte;
		setArticle(article);
		setQte(qte);
		this.prix = qte * article.getPrixUnitaire();
	}

	/**
	 * Méthode getter pour récupérer la quantité d'articles d'une ligne
	 * 
	 * @return la qte d'articles
	 */
	public int getQte() {
		return qte;
	}

	/**
	 * Méthode setter pour modifier la quantité d'une ligne
	 * 
	 * @param qte : la nouvelle quantité
	 */
	public void setQte(int qte) {
		this.qte = qte;
		this.prix = qte * article.getPrixUnitaire();
	}

	/**
	 * Méthode getter pour récupérer l'article d'une ligne
	 * 
	 * @return l'article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * Méthode setter pour modifier l'article d'une ligne
	 * 
	 * @param article : le nouvel article
	 */
	public void setArticle(Article article) {
		this.article = article;
		this.prix = qte * article.getPrixUnitaire();
	}

	/**
	 * Méthode getter pour récupérer le prix d'une ligne (qte x tarif unitaire de
	 * l'article)
	 * 
	 * @return le prix d'une ligne
	 */
	public float getPrix() {
		return prix;
	}

	@Override
	public String toString() {
		return String.format("Ligne [ qte=%d, prix=%.01f, article=%s]", qte, prix,
				article.toString() != null ? article.toString() : "pas d'article");
	}

}
