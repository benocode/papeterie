package fr.eni.papeterie.dal;

import fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl;

/**
 * Classe DAOFactory pour connection à la BDD via JDBC
 * 
 * @author benocode
 * @date 06/01/2023
 */
public class DAOFactory {

	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJdbcImpl();
	}
}
