package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;

/**
 * Classe abstraite pour effectuer les requêtes SQL avec le SGBD
 * 
 * @author benocode
 * @date 04/01/2023
 */
public class ArticleDAOJdbcImpl implements ArticleDAO {

	private static final String TYPE_STYLO = "STYLO";
	private static final String TYPE_RAMETTE = "RAMETTE";

	private static final String SQL_SELECT_BY_ID = "select * from articles where idArticle=?";
	private static final String SQL_SELECT_ALL = "select * from articles";
	private static final String SQL_UPDATE = "update articles set reference=?,marque=?,designation=?,prixUnitaire=?,qteStock=?,type=?,grammage=?,couleur=? where idArticle=?";
	private static final String SQL_INSERT = "insert into articles (reference,marque,designation,prixUnitaire,qteStock,type,grammage,couleur) values (?,?,?,?,?,?,?,?)";
	private static final String SQL_DELETE = "delete from articles where idArticle=?";

	/**
	 * Méthode pour récupérer un article de la BDD avec son numéro id
	 * 
	 * @param id
	 * @return article
	 * @throws DALException
	 */
	@Override
	public Article selectById(int id) throws DALException {
		Connection conn = null;
		PreparedStatement query = null;
		ResultSet result;
		Article article = null;
		try {
			conn = JdbcTools.getConnection();

			/*
			 * Exécution de la requête
			 */
			query = conn.prepareStatement(SQL_SELECT_BY_ID);
			query.setInt(1, id);
			result = query.executeQuery();
			
			/*
			 * Traitement du résultat
			 */
			if (result.next()) { // Vérifie si l'id existe bien dans la BDD et positionne le curseur sur la ligne
									// souhaitée
				if (TYPE_STYLO.equalsIgnoreCase(result.getString("type").trim())) {
					article = new Stylo(result.getInt("idArticle"), result.getString("marque"),
							result.getString("reference"), result.getString("designation"),
							result.getFloat("prixUnitaire"), result.getInt("qteStock"), result.getString("couleur"));
				}
				if (TYPE_RAMETTE.equalsIgnoreCase(result.getString("type").trim())) {
					article = new Ramette(result.getInt("idArticle"), result.getString("marque"),
							result.getString("reference"), result.getString("designation"),
							result.getFloat("prixUnitaire"), result.getInt("qteStock"), result.getInt("grammage"));
				}
			}

		} catch (SQLException e) {
			throw new DALException("selectById failed - id = " + id, e);
		} finally {
			if (query != null) {
				try {
					query.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JdbcTools.closeConnection();
		}
		return article;
	}

	/**
	 * Méthode pour récupérer la liste de tous les article de la BDD
	 * 
	 * @return liste des articles
	 * @throws DALException
	 */
	@Override
	public List<Article> selectAll() throws DALException {
		Connection conn = null;
		Statement query = null;
		ResultSet result = null;
		List<Article> articles = new ArrayList<>();
		try {
			conn = JdbcTools.getConnection();

			/*
			 * Exécution de la requête
			 */
			query = conn.createStatement();
			result = query.executeQuery(SQL_SELECT_ALL);

			/*
			 * Traitement du résultat
			 */
			while (result.next()) {
				if (TYPE_STYLO.equalsIgnoreCase(result.getString("type").trim())) {
					articles.add(new Stylo(result.getInt("idArticle"), result.getString("marque"),
							result.getString("reference"), result.getString("designation"),
							result.getFloat("prixUnitaire"), result.getInt("qteStock"), result.getString("couleur")));
				}
				if (TYPE_RAMETTE.equalsIgnoreCase(result.getString("type").trim())) {
					articles.add(new Ramette(result.getInt("idArticle"), result.getString("marque"),
							result.getString("reference"), result.getString("designation"),
							result.getFloat("prixUnitaire"), result.getInt("qteStock"), result.getInt("grammage")));
				}
			}

		} catch (SQLException e) {
			throw new DALException("selectAll failed - ", e);
		} finally {
			if (query != null) {
				try {
					query.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JdbcTools.closeConnection();
		}
		return articles;
	}

	/**
	 * Méthode pour modifier les attributs d'un article
	 * 
	 * @param Article
	 * @throws DALException
	 */
	@Override
	public void update(Article article) throws DALException {
		Connection conn = null;
		PreparedStatement query = null;

		try {
			conn = JdbcTools.getConnection();

			/*
			 * Exécution de la requête
			 */
			query = conn.prepareStatement(SQL_UPDATE);
			query.setString(1, article.getReference());
			query.setString(2, article.getMarque());
			query.setString(3, article.getDesignation());
			query.setFloat(4, article.getPrixUnitaire());
			query.setInt(5, article.getQteStock());
			query.setInt(9, article.getIdArticle());
			if (article instanceof Stylo) {
				Stylo stylo = (Stylo) article;
				query.setString(6, "STYLO");
				query.setNull(7, Types.INTEGER);
				query.setString(8, stylo.getCouleur());
			}
			if (article instanceof Ramette) {
				Ramette ramette = (Ramette) article;
				query.setString(6, "RAMETTE");
				query.setInt(7, ramette.getGrammage());
				query.setNull(8, Types.VARCHAR);
			}
			query.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("update article failed - " + article, e);
		} finally {
			if (query != null) {
				try {
					query.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JdbcTools.closeConnection();
		}
	}

	/**
	 * Méthode pour insérer un article dans la BDD
	 * 
	 * @param Article
	 * @throws DALException
	 */
	@Override
	public void insert(Article article) throws DALException {
		Connection conn;
		PreparedStatement query = null;

		try {
			conn = JdbcTools.getConnection();

			/*
			 * Exécution de la requête
			 */
			query = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			query.setString(1, article.getReference());
			query.setString(2, article.getMarque());
			query.setString(3, article.getDesignation());
			query.setFloat(4, article.getPrixUnitaire());
			query.setInt(5, article.getQteStock());
			if (article instanceof Stylo) {
				Stylo stylo = (Stylo) article;
				query.setString(6, "STYLO");
				query.setNull(7, Types.INTEGER);
				query.setString(8, stylo.getCouleur());
			}
			if (article instanceof Ramette) {
				Ramette ramette = (Ramette) article;
				query.setString(6, "RAMETTE");
				query.setInt(7, ramette.getGrammage());
				query.setNull(8, Types.VARCHAR);
			}

			query.executeUpdate();
			ResultSet rs = query.getGeneratedKeys();
			if (rs.next()) {
				article.setIdArticle(rs.getInt(1));
			}

		} catch (SQLException e) {
			throw new DALException("insert article failed - " + article, e);
		} finally {
			if (query != null) {
				try {
					query.close();
				} catch (SQLException e) {
					throw new DALException("close failed - ", e);
				}
			}
			JdbcTools.closeConnection();
		}
	}

	/**
	 * Méthode pour supprimer un article dans la BDD
	 * 
	 * @param idArticle
	 * @throws DALException
	 */
	@Override
	public void delete(int id) throws DALException {
		Connection conn;
		PreparedStatement query = null;

		try {
			conn = JdbcTools.getConnection();

			/*
			 * Exécution de la requête
			 */
			query = conn.prepareStatement(SQL_DELETE);
			query.setInt(1, id);
			query.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("delete article failed - id = " + id, e);
		} finally {
			if (query != null) {
				try {
					query.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JdbcTools.closeConnection();
		}
	}
}
