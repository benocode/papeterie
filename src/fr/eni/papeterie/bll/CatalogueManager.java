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
		if (article == null || article.getMarque() == null || article.getMarque().trim().isEmpty()
				|| article.getReference() == null || article.getReference().trim().isEmpty()
				|| article.getDesignation() == null || article.getDesignation().trim().isEmpty()
				|| article.getPrixUnitaire() <= 0f
				|| (article instanceof Ramette) && ((Ramette) article).getGrammage() <= 0
				|| (article instanceof Stylo) && ((Stylo) article).getCouleur().trim().isEmpty()
				|| (article instanceof Stylo) && ((Stylo) article).getCouleur() == null) {
			throw new BLLException("Erreur - il manque des données ou des données sont erronées");
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
