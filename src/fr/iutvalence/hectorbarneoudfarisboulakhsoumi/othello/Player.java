package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

import fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello.Pawn;

/**
 * Represent a player.
 * 
 * @author Hector Barneoud / Faris Boulakhsoumi
 * @version 1.0.0
 * @see Pawn
 */

public class Player {
	/**
	 *  The nickname of the player
	 */
	private final String nickname;
	/**
	 *  The pawn color of the player.
	 */

	private final Couleur pawnColor;
	
	/**
	 *  Build a Player 
	*/
	
	public Player(String nickName, Couleur pawnC) {
		nickname = nickName;
		pawnColor = pawnC;
	}

	/**
	 * Getter for the pawn color 
	 */
	public Couleur color() {
		return pawnColor;
	}

	/**
	 *  Getter for the nickname
	  */
	public String nickname() {
		return nickname;
	}
}
