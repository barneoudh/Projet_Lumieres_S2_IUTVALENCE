package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/**
 * Represent a case on the ckeckerboard
 * 
 * @author Hector Barneoud / Faris Boulakhsoumi
 * 
 */

public class Case {
/**
 * The pawn in the case
 */
	private Pawn pawn;
	/**
	 * To build a case without pawn
	 */
	public Case() {
		this.pawn = null;
	}
	/**
	 * Getter of the color of the pawn in the current case
	 * @return color of the pawn
	 */
	public Couleur color()
	{
		return this.pawn != null ? this.pawn.getCouleur() : null;
	}
	/**
	 * Getter of the pawn in the current case
	 * @return pawn
	 */
	public Pawn getPawn(){
		return this.pawn;
	}
	/**
	 * Check if the current case isAvailable
	 * @return pawn
	 */

	public boolean isAvailable()
	{
		return this.pawn == null;
	}
	
	/**
	 * Put a given pawn in a case
	 * @param pawn
	 */
	
	public void putPawn(Pawn pawn) {
		this.pawn = pawn;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return String.format("|-(%s)-|", this.pawn == null ? " " : pawn);
	}



}
