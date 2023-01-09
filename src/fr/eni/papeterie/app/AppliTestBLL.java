package fr.eni.papeterie.app;

import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class AppliTestBLL {

	public static void main(String[] args) {
		// Instanciation du jeu d'essai
		List<Article> articles = new ArrayList<>();

		articles.add(new Stylo("    ", "PlumeS", "Stylo Plume Stypen", 5.5f, 20, "jaune"));
		articles.add(new Stylo("Waterman", "WOBGreen", "Waterman Orion Bille vert", 4.2f, 35, "vert"));
		articles.add(new Ramette("ProDesign", "ForLaser", "A4 Special laser", 5.5f, 55, 100));

		CatalogueManager mger = null;

		try {
			mger = new CatalogueManager();
		} catch (BLLException e1) {
			e1.printStackTrace();
		}

		// Ajout d'un article au catalogue
		try {
			for (Article art : articles) {
				mger.addArticle(art);
			}
			System.out.println(mger.getCatalogue());

		} catch (BLLException e) {
			for (String current : e.getErreurs()) {
				System.err.println(current);
			}
		}

		// Modification d'un article
//		try {
//			stylo.setCouleur("noir");
//			stylo.setDesignation("Bic bille noir");
//			stylo.setReference("BBNoir");
//			mger.updateArticle(stylo);
//			System.out.println("Article après modification  : " + stylo.toString());
//		} catch (BLLException e) {
//			System.err.println(e.getErreurs());
//		}
//
//		// Suppression d'un article
//		try {
//			mger.removeArticle(stylo.getIdArticle());
//			System.out.println(mger.getCatalogue());
//		} catch (BLLException e) {
//			System.err.println(e.getErreurs());
//		}
	}

}
