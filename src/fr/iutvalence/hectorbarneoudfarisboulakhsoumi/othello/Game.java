package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

import java.util.List;
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
		Couleur couleur = currentPlayer.color();
		
		if(couleur == Couleur.BLACK) 
			System.out.println("current player : Player 1 (BLACK)");
		else 
			System.out.println("current player : Player 2 (WHITE)");

		
		java.util.Scanner entry = new java.util.Scanner(System.in);
		
		System.out.println("Enter the line number:");
		int i = entry.nextInt();
		System.out.println("Enter the column number:");
		int j = entry.nextInt();
		/** Ask the player which position he wants to put his pawn */
		
		Position position = new Position(i, j);
		List<Direction> directions = grid.playable(position, couleur);
		
		if (directions.isEmpty()) {
			System.out.println("Mauvais placement!");
			currentPlayer = currentPlayer == player1 ? player2 : player1;
		}
		
		grid.putPawn(position, currentPlayer.color());
		grid.returnThePawns(position, couleur, directions);
		
		currentPlayer = currentPlayer == player1 ? player2 : player1;
		System.out.println(grid);
	}
	

	/** Start the game */
	public void start() {
		/** Display the beginning grid */
		
		grid.installPawn();
		System.out.println(grid);
		System.out.printf("Black pawns number : %d \n",grid.blackCounter());
		System.out.printf("White pawns number : %d \n",grid.whiteCounter());
		System.out.printf("Cases available number : %d \n",grid.availableCaseNumber());
		
		/** Player 1 is the first to play */
		currentPlayer=player1;
		turn();
		
		while(grid.finishParty() != false) // while the party is not finish */
		{
		turn();
			
		}
		if (grid.blackCounter()>grid.whiteCounter()) System.out.println("Player 1 is the winner!!");
		else if (grid.blackCounter()<grid.whiteCounter()) System.out.println("Player 2 is the winner!!");
		else System.out.println("No winner");
		
		
	}


}
