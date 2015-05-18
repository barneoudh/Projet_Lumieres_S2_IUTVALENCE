package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

import fr.iutvalence.bandb.othello.Pawn;

/**
 * Othello game: the players and the grid.
 * 
 * @author Hector Barneoud / Faris Boulakhsoumi
 * @version 1.0.0
 * @see Player
 * @see Grid
 */
public class Game {
	/** Player 1. */
	private final Player player1;
	/** We define a player two with player type. */
	private final Player player2;
	/** A game takes a grid with Grid type as attribute. */
	private final Grid grid;
	private int blackCounter = 0;
	private int whiteCounter = 0;
	private Player currentPlayer;

	/**
	 * @param We assign Black pawns to the player 1
	 * @p0aram We assign White pawns to the player 2
	 */
	public Game(String player1, String player2) {
		this.player1 = new Player(player1,Couleur.BLACK);
		this.player2 = new Player(player2,Couleur.WHITE);
		this.grid = new Grid();
	}
	
	public void turn() {
		java.util.Scanner entree = new java.util.Scanner(System.in);
		
		System.out.println("Entrez la ligne");
		int i = entree.nextInt();
		System.out.println("Entrez la colonne");
		int j = entree.nextInt();
		
		Position position = new Position(i, j);
		
		if (grid.playable(position, currentPlayer.color()))
			try {
				grid.putPawn(position, currentPlayer.color());
			} catch (NoCasesAvailable | InvalidPosition e) {}
		else System.out.println("Mauvais placement!");
		currentPlayer = currentPlayer == player1 ? player2 : player1;
	}
	


	public void start() {
		System.out.println(grid);
		whiteCounter = 2;
		blackCounter = 2;
		currentPlayer=player1;
		turn();

		

		while(grid.finishParty() != false) // while the party is not finish */
		{
		turn();
			
		}
		
		
	}


}
