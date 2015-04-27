package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;
/**
 * Othello game: the player.
 * 
 * @author Hector Barneoud / Faris Boulakhsoumi
 * @version 1.0.0
 * @see Pawn
 */

public class Player {
	/* We define a strict string for the nickname of the player. */
	private final String nickname;
	/* We define a strict pawnColor for the player. */
	private final Pawn pawnColor;

	/* We make a Player Constructor. */
	public Player(String nickName, Pawn pawnC) {
		nickname = nickName;
		pawnColor = pawnC;
	}

	/* We make a pawncolor getter. */
	public Pawn color() {
		return pawnColor;
	}

	/* We make a nickname getter. */
	public String nickname() {
		return nickname;
	}
}
