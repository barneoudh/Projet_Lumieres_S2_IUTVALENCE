package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/**
 * Represent a pawn
 * 
 * @author Hector Barneoud / Faris Boulakhsoumi
 * @version 1.0.0
 * @see Color
 */
public class Pawn {
	/**
	 * The color of the pawn
	 */
	private Couleur couleur;
	
	/**
	 * Build a pawn
	 */

	public Pawn(Couleur couleur) {
		this.couleur = couleur;
	}

	/**
	 * Getter of the color of the pawn
	 * @return
	 */
	public Couleur getCouleur() {
		return couleur;
	}
	
	/**
	 * To get a color to the pawn
	 */


	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	
	/**
	 * To Convert the color in to string
	 */

	public String toString() {
		return this.couleur.toString();
	}
	
}
