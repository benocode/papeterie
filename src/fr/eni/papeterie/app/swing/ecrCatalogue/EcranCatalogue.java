package fr.eni.papeterie.app.swing.ecrCatalogue;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.eni.papeterie.app.swing.ArticleController;

public class EcranCatalogue extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur pour paramétrage de la fenêtre catalogue
	 */
	public EcranCatalogue() {
		this.setTitle("Catalogue");
		this.setSize(600, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		this.setIconImage(tk.getImage(getClass().getResource("../img/aim.png")));
		this.setResizable(true);
		getPanelCatalogue();
	}

	/**
	 * Méthode pour mise en page GridLayout
	 * 
	 * @return panel la mise en page
	 */
	public void getPanelCatalogue() {
		JPanel mainContent = new JPanel();
		mainContent.setOpaque(true);
		mainContent.setLayout(new GridLayout(1, 0));
		TableCatalogue tblCatalogue = new TableCatalogue(ArticleController.get().getCatalogue());

		// Créer le bandeau de scroll et l'ajouter à la table
		JScrollPane scrollPane = new JScrollPane(tblCatalogue);

		// Ajoute le scroll à cet écran
		mainContent.add(scrollPane);

		// Affecter le panel à l'écran
		this.setContentPane(mainContent);
	}
}
