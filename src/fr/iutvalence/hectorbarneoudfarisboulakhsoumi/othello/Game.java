package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/**
 * Othello game: the players and the grid.
 * 
 * @author Hector Barneoud / Faris Boulakhsoumi
 * @version 1.0.0
 * @see Player
 * @see Grid
 */
public class Game {
	/* TODO JAVADOC. */
	private final Player player1;
	/* TODO JAVADOC. */
	private final Player player2;
	/* TODO JAVADOC. */
	private final Grid grid;

	/**
	 * @param player1
	 * @param player2
	 */
	public Game(String player1, String player2) {
		this.player1 = new Player(player1, Pawn.BLACK);
		this.player2 = new Player(player2, Pawn.WHITE);
		this.grid = new Grid();
	}

}
