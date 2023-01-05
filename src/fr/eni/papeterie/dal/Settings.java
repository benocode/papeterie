package fr.eni.papeterie.dal;

import java.io.IOException;
import java.util.Properties;

/**
 * Classe pour contenir les informations de connexion au SBBD
 * 
 * @author benocode
 * @date 05/01/2023
 */
public class Settings {

	private static Properties properties;

	/**
	 * Bloc d'initialisation static pour charger les propriétés depuis un fichier
	 * externe au chargement en mémoire de la classe Settings (à faire une seule
	 * fois)
	 */
	static {
		properties = new Properties();

		// charger le fichier de configuration
		try {
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode pour récupérer les informations de connexion (méthode static pour
	 * permettre l'utilisation directement via la classe)
	 * 
	 * @param la clé sous forme de chaîne de caractères
	 * @return la valeur de la clé
	 */
	public static String getProperties(String key) {
		return properties.getProperty(key);
	}

}
