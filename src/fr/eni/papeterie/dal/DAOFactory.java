package fr.eni.papeterie.dal;

import fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl;

/**
 * Classe DAOFactory pour connection à la BDD via JDBC
 * 
 * @author benocode
 * @date 06/01/2023
 */
public abstract class DAOFactory {

	private static ArticleDAO articleDAO;

	public static ArticleDAO getArticleDAO() {
		if (articleDAO == null) {
			articleDAO = new ArticleDAOJdbcImpl();
		}
		return articleDAO;
	}
}
