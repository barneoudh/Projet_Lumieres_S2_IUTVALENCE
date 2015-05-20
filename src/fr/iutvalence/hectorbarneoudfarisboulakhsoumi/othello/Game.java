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
	/** Count the black pawns on the grid to know who have won the game */
	private int blackCounter = 2;
	/** Count the white pawns on the grid to know who have won the game */
	private int whiteCounter = 2;
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
		/** Ask the player which position he wants to put his pawn */
		
		Position position = new Position(i, j);
		
		if (grid.playable(position, currentPlayer.color())!= Direction.NULL){
			try {
				grid.putPawn(position, currentPlayer.color());
			} catch (NoCasesAvailable | InvalidPosition e) {}
			currentPlayer = currentPlayer == player1 ? player2 : player1;}
		else { System.out.println("Mauvais placement!");
		turn();}
	}
	

	/** Start the game */
	public void start() {
		/** Display the beginning grid */
		System.out.println(grid);
		whiteCounter = 2;
		blackCounter = 2;
		/** Player 1 is the first to play */
		currentPlayer=player1;
		turn();
		while(grid.finishParty() != false) // while the party is not finish */
		{
		turn();
			
		}
		
		
	}


}
