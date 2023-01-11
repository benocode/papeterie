package fr.eni.papeterie.app.swing;

/**
 * Interface pour implémentation des méthodes nécessaires à l'utilisation de la
 * barre de navigation
 * 
 * @author benocode
 * @since 11/01/2023
 */
public interface NavBarreObserver {

	public void precedent();

	public void suivant();

	public void nouveau();

	public void enregistrer();

	public void supprimer();
}
