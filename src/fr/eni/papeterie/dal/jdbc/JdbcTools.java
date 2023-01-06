package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.papeterie.dal.Settings;

/**
 * Classe pour les méthodes de connexion / déconnnexion à la BDD
 * 
 * @author benocode
 * @date 06/01/2023
 */
public class JdbcTools {

	private static Connection connection;

	/**
	 * Méthode pour ouvrir la connexion avec le SGBD
	 * 
	 * @return connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			String url = Settings.getProperties("url");
			String user = Settings.getProperties("user");
			String password = Settings.getProperties("password");
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}

	/**
	 * Méthode pour fermer la connexion avec le SGBD
	 */
	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connection = null;
			}
		}
	}
}
