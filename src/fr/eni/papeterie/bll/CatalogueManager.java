package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;

public class CatalogueManager {

	private static ArticleDAO daoArticle;

	/**
	 * Constructeur sans paramètres pour instancier le DAO
	 * 
	 * @throws BLLException
	 */
	public CatalogueManager() throws BLLException {
		daoArticle = DAOFactory.getArticleDAO();
	}

	/**
	 * Méthode pour valider les attributs d'un article
	 * 
	 * @param article
	 * @throws BLLException
	 */
	public void validerArticle(Article article) throws BLLException {
		BLLException exception = new BLLException();
		if (article.getMarque() == null || article.getMarque().trim().isEmpty()) { // .trim().isEmpty = isBlank()
			exception.ajouterErreur("Un article doit avoir une marque");
		}
		if (article.getReference() == null || article.getReference().isBlank()) { // <-- Exemple avec isBlank()
			exception.ajouterErreur("Un article doit avoir une référence");
		}
		if (article.getDesignation() == null || article.getDesignation().isBlank()) {
			exception.ajouterErreur("Un article doit avoir une désignation");
		}
		if (article.getPrixUnitaire() <= 0f) {
			exception.ajouterErreur("Un article doit avoir prix unitaire supérieur à 0");
		}
		if (article instanceof Ramette) {
			if (((Ramette) article).getGrammage() <= 0) {
				exception.ajouterErreur("Une ramette doit avoir un grammage supérieur à 0");
			}
		}
		if (article instanceof Stylo) {
			if (((Stylo) article).getCouleur() == null || ((Stylo) article).getCouleur().isBlank()) {
				exception.ajouterErreur("Un stylo doit avoir une couleur");
			}
		}
		if (exception.getErreurs().size() > 0) {
			throw exception;
		}
	}

	/**
	 * Méthode pour récupérer la liste des articles du catalogue
	 * 
	 * @return la liste des articles
	 * @throws DALException
	 */
	public List<Article> getCatalogue() throws BLLException {
		List<Article> articles = null;
		try {
			articles = daoArticle.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur récupération catalogue", e);
		}
		return articles;
	}

	/**
	 * Méthode pour récupérer un article de la BDD
	 * 
	 * @param idArticle
	 * @throws BLLException
	 * @throws DALException
	 */
	public Article getArticle(int idArticle) throws BLLException {
		Article article;
		try {
			article = daoArticle.selectById(idArticle);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur récupération article", e);
		}
		return article;
	}

	/**
	 * Méthode pour ajouter un article à la BDD
	 * 
	 * @param article
	 * @throws BLLException
	 * @throws DALException
	 */
	public void addArticle(Article article) throws BLLException {
		if (article.getIdArticle() != null) {
			throw new BLLException("Article déjà existant");
		}
		try {
			validerArticle(article);
			daoArticle.insert(article);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Echec ajout de l'article", e);
		}
	}

	/**
	 * Méthode pour modifier un article existant dans la BDD
	 * 
	 * @param article
	 * @throws BLLException
	 */
	public void updateArticle(Article article) throws BLLException {
		try {
			validerArticle(article);
			daoArticle.update(article);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Echec modification de l'article n°" + article.getIdArticle(), e);
		}
	}

	/**
	 * Méthode pour supprimer un article de la BDD
	 * 
	 * @param idArticle
	 * @throws BLLException
	 * @throws DALException
	 */
	public void removeArticle(int idArticle) throws BLLException {
		try {
			daoArticle.delete(idArticle);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Echec suppression de l'article n°" + idArticle, e);
		}
	}
}
