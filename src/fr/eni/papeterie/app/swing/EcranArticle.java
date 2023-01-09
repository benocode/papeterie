package fr.eni.papeterie.app.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Classe qui modélise l'écran principale de consultation des articles et
 * modification de la BDD
 * 
 * @author benocode
 * @date 09/01/2023
 */
public class EcranArticle extends JFrame {

	private static final long serialVersionUID = 1L;

	/* Formulaire de saisie */
	private JLabel lblReference, lblDesignation, lblMarque, lblStock, lblPrix, lblType, lblGrammage, lblCouleur;
	private JTextField txtReference, txtDesignation, txtMarque, txtStock, txtPrix;
	private JPanel panelType, panelGrammage;
	private JRadioButton radioRamette, radioStylo;
	private JCheckBox chk80, chk100;
	private JComboBox<String> cboCouleur;

	/**
	 * Constructeur pour paramétrage de la fenêtre principale
	 */
	public EcranArticle() {
		this.setTitle("Papeterie");
		this.setSize(400, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		getPanelPrincipal();
	}

	/**
	 * Méthode pour mise en page GridBagLayout
	 * 
	 * @return panel la mise en page
	 */
	public void getPanelPrincipal() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		gbc.gridy = 0;
		gbc.gridx = 0;
		panel.add(getLblReference(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtReference(), gbc);
		
		// Ligne 2
		gbc.gridy = 1;
		gbc.gridx = 0;
		panel.add(getLblDesignation(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtDesignation(), gbc);
		
		// Ligne 3
		gbc.gridy = 2;
		gbc.gridx = 0;
		panel.add(getLblMarque(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtMarque(), gbc);

		// Ligne 4
		gbc.gridy = 3;
		gbc.gridx = 0;
		panel.add(getLblStock(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtStock(), gbc);

		// Ligne 5
		gbc.gridy = 4;
		gbc.gridx = 0;
		panel.add(getLblPrix(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtPrix(), gbc);
		
		// Ligne 6
		gbc.gridy = 5;
		gbc.gridx = 0;
		panel.add(getLblType(), gbc);

		gbc.gridx = 1;
		gbc.gridheight = 1;
		panel.add(getPanelType(), gbc);

		// Ligne 7
		gbc.gridy = 6;
		gbc.gridx = 0;
		panel.add(getLblGrammage(), gbc);

		gbc.gridx = 1;
		gbc.gridheight = 1;
		panel.add(getPanelGrammage(), gbc);

		// Ligne 8
		gbc.gridy = 7;
		gbc.gridx = 0;
		panel.add(getLblCouleur(), gbc);

		gbc.gridx = 1;
		panel.add(getCboCouleur(), gbc);

		// Affecter le panel à l'écran
		this.setContentPane(panel);
	}

// Getters pour variables de champs

	public JLabel getLblReference() {
		if (lblReference == null) {
			lblReference = new JLabel("Référence");
		}
		return lblReference;
	}

	public JTextField getTxtReference() {
		if (txtReference == null) {
			txtReference = new JTextField(20);
		}
		return txtReference;
	}

	public JLabel getLblDesignation() {
		if (lblDesignation == null) {
			lblDesignation = new JLabel("Désignation");
		}
		return lblDesignation;
	}

	public JTextField getTxtDesignation() {
		if (txtDesignation == null) {
			txtDesignation = new JTextField(20);
		}
		return txtDesignation;
	}

	public JLabel getLblMarque() {
		if (lblMarque == null) {
			lblMarque = new JLabel("Marque");
		}
		return lblMarque;
	}

	public JTextField getTxtMarque() {
		if (txtMarque == null) {
			txtMarque = new JTextField(20);
		}
		return txtMarque;
	}

	public JLabel getLblStock() {
		if (lblStock == null) {
			lblStock = new JLabel("Stock");
		}
		return lblStock;
	}

	public JTextField getTxtStock() {
		if (txtStock == null) {
			txtStock = new JTextField(20);
		}
		return txtStock;
	}

	public JLabel getLblPrix() {
		if (lblPrix == null) {
			lblPrix = new JLabel("Prix");
		}
		return lblPrix;
	}

	public JTextField getTxtPrix() {
		if (txtPrix == null) {
			txtPrix = new JTextField(20);
		}
		return txtPrix;
	}

	public JLabel getLblType() {
		if (lblType == null) {
			lblType = new JLabel("Type");
		}
		return lblType;
	}

	public JPanel getPanelType() {
		if (panelType == null) {
			panelType = new JPanel();
			panelType.setLayout(new BoxLayout(panelType, BoxLayout.Y_AXIS));
			panelType.add(getRadioRamette());
			panelType.add(getRadioStylo());
			ButtonGroup bg = new ButtonGroup();
			bg.add(getRadioRamette());
			bg.add(getRadioStylo());
		}
		return panelType;
	}

	public JRadioButton getRadioRamette() {
		if (radioRamette == null) {
			radioRamette = new JRadioButton("Ramette");
		}
		return radioRamette;
	}

	public JRadioButton getRadioStylo() {
		if (radioStylo == null) {
			radioStylo = new JRadioButton("Stylo");
		}
		return radioStylo;
	}

	public JLabel getLblGrammage() {
		if (lblGrammage == null) {
			lblGrammage = new JLabel("Grammage");
		}
		return lblGrammage;
	}

	public JPanel getPanelGrammage() {
		if (panelGrammage == null) {
			panelGrammage = new JPanel();
			panelGrammage.setLayout(new BoxLayout(panelGrammage, BoxLayout.Y_AXIS));
			panelGrammage.add(getChk80());
			panelGrammage.add(getChk100());
			ButtonGroup bg = new ButtonGroup();
			bg.add(getChk80());
			bg.add(getChk100());
		}
		return panelGrammage;
	}

	public JCheckBox getChk80() {
		if (chk80 == null) {
			chk80 = new JCheckBox("80");
		}
		return chk80;
	}

	public JCheckBox getChk100() {
		if (chk100 == null) {
			chk100 = new JCheckBox("100");
		}
		return chk100;
	}

	public JLabel getLblCouleur() {
		if (lblCouleur == null) {
			lblCouleur = new JLabel("Couleur");
		}
		return lblCouleur;
	}

	public JComboBox<String> getCboCouleur() {
		if (cboCouleur == null) {
			cboCouleur = new JComboBox<String>();
			cboCouleur.addItem("bleu");
			cboCouleur.addItem("rouge");
			cboCouleur.addItem("noir");
			cboCouleur.addItem("vert");
		}
		return cboCouleur;
	}
}