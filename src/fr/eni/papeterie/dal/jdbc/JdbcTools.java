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
public abstract class JdbcTools {

	private static Connection connection;

	/**
	 * Méthode pour ouvrir la connexion avec le SGBD
	 * 
	 * @return connection
	 * @throws SQLException
	 */
	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				String url = Settings.getProperties("url");
				String user = Settings.getProperties("user");
				String password = Settings.getProperties("password");
				connection = DriverManager.getConnection(url, user, password);
				System.out.println("--- Connection to database open ---");
			}
		} catch (SQLException e) {
			System.err.println("*** Error trying to open connection to database ***");
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Méthode pour fermer la connexion avec le SGBD
	 */
	public static void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				System.out.println("--- Connection to database closed ---");
			}
		} catch (SQLException e) {
			System.err.println("*** Error trying to close connection to database ***");
			e.printStackTrace();
		}
	}
}
