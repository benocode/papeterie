package fr.eni.papeterie.app.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Classe qui modélise une barre de navigation avec boutons
 * 
 * @author benocode
 * @since 10/01/2023
 * @return < | New | Save | Delete | >
 */
public class NavBarre {

	private JPanel panelBoutons;
	private JButton btnPrecedent;
	private JButton btnNouveau;
	private JButton btnEnregistrer;
	private JButton btnSupprimer;
	private JButton btnSuivant;
	
//	public NavBarre() {
//
//	}

	/**
	 * Méthode pour créer le panel de boutons de navigation
	 * 
	 * @return JPanel panelBoutons
	 */
	public JPanel getPanelBoutons() {
		if (panelBoutons == null) {
			panelBoutons = new JPanel();
			panelBoutons.setLayout(new FlowLayout());
			panelBoutons.add(getBtnPrecedent());
			panelBoutons.add(getBtnNouveau());
			panelBoutons.add(getBtnEnregistrer());
			panelBoutons.add(getBtnSupprimer());
			panelBoutons.add(getBtnSuivant());
		}
		return panelBoutons;
	}

	public JButton getBtnPrecedent() {
		if (btnPrecedent == null) {
			btnPrecedent = new JButton();
			ImageIcon image = new ImageIcon(this.getClass().getResource("img/Back24.gif"));
			btnPrecedent.setIcon(image);
			btnPrecedent.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ArticleController.get().precedent();
				}

			});
		}
		return btnPrecedent;
	}

	public JButton getBtnNouveau() {
		if (btnNouveau == null) {
			btnNouveau = new JButton();
			ImageIcon image = new ImageIcon(this.getClass().getResource("img/New24.gif"));
			btnNouveau.setIcon(image);
			btnNouveau.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ArticleController.get().nouveau();
				}
				
			});
		}
		return btnNouveau;
	}

	public JButton getBtnEnregistrer() {
		if (btnEnregistrer == null) {
			btnEnregistrer = new JButton();
			ImageIcon image = new ImageIcon(this.getClass().getResource("img/Save24.gif"));
			btnEnregistrer.setIcon(image);
			btnEnregistrer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ArticleController.get().enregistrer();
				}

			});
		}
		return btnEnregistrer;
	}

	public JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			btnSupprimer = new JButton();
			ImageIcon image = new ImageIcon(this.getClass().getResource("img/Delete24.gif"));
			btnSupprimer.setIcon(image);
			btnSupprimer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ArticleController.get().supprimer();
				}

			});
		}
		return btnSupprimer;
	}

	public JButton getBtnSuivant() {
		if (btnSuivant == null) {
			btnSuivant = new JButton();
			ImageIcon image = new ImageIcon(this.getClass().getResource("img/Forward24.gif"));
			btnSuivant.setIcon(image);
			btnSuivant.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ArticleController.get().suivant();
				}

			});
		}
		return btnSuivant;
	}

}
