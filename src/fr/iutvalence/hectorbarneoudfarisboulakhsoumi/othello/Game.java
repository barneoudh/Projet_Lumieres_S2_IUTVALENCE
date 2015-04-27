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
	/* We define a player one with player type. */
	private final Player player1;
	/* We define a player two with player type.. */
	private final Player player2;
	/* A game takes a grid with Grid type as attribute. */
	private final Grid grid;

	/**
	 * @param We assign Black pawns to the player 1
	 * @param We assign White pawns to the player 2
	 */
	public Game(String player1, String player2) {
		this.player1 = new Player(player1, Pawn.BLACK);
		this.player2 = new Player(player2, Pawn.WHITE);
		this.grid = new Grid();
	}

	public Grid getGrid() {
		return grid;
	}

	public Player getPlayer2() {
		return player2;
	}

	public Player getPlayer1() {
		return player1;
	}

}
