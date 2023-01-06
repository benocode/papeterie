package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;

/**
 * Interface Arcticle pour connection à la techno JDBC
 * 
 * @author benocode
 * @date 06/01/2023
 */
public interface ArticleDAO {

	/**
	 * Méthode pour récupérer un article de la BDD avec son numéro id
	 * 
	 * @param id
	 * @return article
	 * @throws DALException
	 */
	Article selectById(int id) throws DALException;

	/**
	 * Méthode pour récupérer la liste de tous les article de la BDD
	 * 
	 * @return liste des articles
	 * @throws DALException
	 */
	public List<Article> selectAll() throws DALException;

	/**
	 * Méthode pour modifier les attributs d'un article
	 * 
	 * @param Article
	 * @throws DALException
	 */
	public void update(Article article) throws DALException;

	/**
	 * Méthode pour insérer un article dans la BDD
	 * 
	 * @param Article
	 * @throws DALException
	 */
	public void insert(Article article) throws DALException;

	/**
	 * Méthode pour supprimer un article dans la BDD
	 * 
	 * @param idArticle
	 * @throws DALException
	 */
	public void delete(int id) throws DALException;
}
