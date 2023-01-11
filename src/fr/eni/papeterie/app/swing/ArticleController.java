package fr.eni.papeterie.app.swing;

import java.util.List;

import fr.eni.papeterie.app.swing.ecrCatalogue.EcranCatalogue;
import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;

public class ArticleController implements NavBarreObserver {

	private static ArticleController instance;
	private EcranArticle ecrArticle;
	private CatalogueManager mger;
	private List<Article> catalogue;
	private int indexCatalogue;

	// Constructeur
	private ArticleController() {
		try {
			mger = new CatalogueManager();
		
		// Initialisation du catalogue en mémoire
			catalogue = mger.getCatalogue();

		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	// Méthode d'instanciation Singleton multithread
	public static synchronized ArticleController get() {
		if (instance == null) {
			instance = new ArticleController();
		}
		return instance;
	}

	/**
	 * Méthode appelée au démarrage de l'application et affiche le 1er article de la
	 * BDD
	 */
	public void startApp() {
		ecrArticle = new EcranArticle();

		// Affichage écran de gestion des articles
		afficherPremierArticle();
		ecrArticle.setVisible(true);

		// Affichage écran de visualisation du catalogue
		EcranCatalogue ecrCatalogue = new EcranCatalogue();
		ecrCatalogue.setVisible(true);
	}

	// Méthodes
	public void afficherPremierArticle() {
		if (catalogue.size() > 0) {
			indexCatalogue = 0;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		} else {
			indexCatalogue = -1;
			ecrArticle.afficherNouveau();
		}
	}

	@Override
	public void precedent() {
		if (indexCatalogue > 0) {
			indexCatalogue--;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		}
	}

	@Override
	public void nouveau() {
		indexCatalogue = catalogue.size();
		ecrArticle.afficherNouveau();
	}

	@Override
	public void suivant() {
		if (indexCatalogue < catalogue.size() - 1) {
			indexCatalogue++;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		}
	}

	@Override
	public void enregistrer() {
		Article articleAffiche = ecrArticle.getArticle();
		try {
			if (articleAffiche.getIdArticle() == null) {
				mger.addArticle(articleAffiche);
				System.out.println("article: " + articleAffiche);
				catalogue.add(articleAffiche);
				ecrArticle.afficherArticle(articleAffiche);
			} else {
				mger.updateArticle(articleAffiche);
				catalogue.set(indexCatalogue, articleAffiche);
			}
		} catch (BLLException e) {
			ecrArticle.infoErreur("Erreur enregistrement !");
			e.printStackTrace();
		}
	}

	@Override
	public void supprimer() {
		try {
			mger.removeArticle(catalogue.get(indexCatalogue));
			catalogue.remove(indexCatalogue);
		} catch (BLLException e) {
			ecrArticle.infoErreur("Erreur suppression !");
			e.printStackTrace();
		}
		if (indexCatalogue < catalogue.size()) {
			// Affiche l'article suivant
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		} else if (indexCatalogue > 0) {
			// Affiche l'article précédent
			indexCatalogue--;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		} else {
			// Affiche formulaire vierge
			ecrArticle.afficherNouveau();
		}
	}

	public List<Article> getCatalogue() {
		return catalogue;
	}
}
