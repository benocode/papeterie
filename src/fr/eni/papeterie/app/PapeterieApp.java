package fr.eni.papeterie.app;

import javax.swing.SwingUtilities;

import fr.eni.papeterie.app.swing.ArticleController;

public class PapeterieApp {

	public static void main(String[] args) {

		// Exécution de l'écran principal dans un thread spécifique
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				ArticleController.get().startApp();
			}
		});
	}
}
