package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

import java.util.List;
/**
 *  Game: the players and the grid.
 * 
 * @author Hector Barneoud / Faris Boulakhsoumi
 * @version 1.0.0
 * @see Player
 * @see Grid
 */
public class Game {
	/** 
	 * The player 1 */
	private final Player player1;
	/** 
	 * The player 2 */
	private final Player player2;
	/** 
	 * The Grid */
	private final Grid grid;
	
	
	/**
	 * Current player
	 */
	private Player currentPlayer;
	private java.util.Scanner entry;

	/**
	 * Game constructor
	 * @param Player 1
	 * @param Player 2
	 */
	public Game(String player1, String player2) {
		this.player1 = new Player(player1,Couleur.BLACK);
		this.player2 = new Player(player2,Couleur.WHITE);
		this.grid = new Grid();
	}
	
	/**
	 * Is the function use to interact with players
	 */
	public void turn() throws InvalidPositionException {
		Couleur couleur = currentPlayer.color();
		
		if(couleur == Couleur.BLACK) 
			System.out.println("Current player : Player 1 (BLACK)");
		else 
			System.out.println("Current player : Player 2 (WHITE)");

		/** 
		 * Ask the player which position he wants to put his pawn */

		entry = new java.util.Scanner(System.in);
		
		System.out.println("Enter the line number:");
		int i = entry.nextInt();
		System.out.println("Enter the column number:");
		int j = entry.nextInt();
		
		try
		{
		if(i>8 || i<0 || j>8 || j<0)
			throw new InvalidPositionException();
			
		Position position = new Position(i, j);
		List<Direction> directions = grid.playable(position, couleur);
		
		if (grid.verifCoup(position, couleur) != false || directions.isEmpty() != true) {
			grid.putPawn(position, couleur);
			grid.returnThePawns(position, couleur, directions);
			
			currentPlayer = currentPlayer == player1 ? player2 : player1;
		}
		else{
		System.out.println("Bad placement!");
		currentPlayer = currentPlayer == player1 ? player2 : player1;

		}
		
		}
		catch (InvalidPositionException e)
		{
			System.out.println("Invalid Position!");

		}
		
		System.out.println(grid);

	}
	

	/**  Start the game 
	 * @throws InvalidPositionException */
	public void start() throws InvalidPositionException {
		/** Display the beginning grid */
		
		grid.installPawn();
		System.out.println(grid);
		/** Display the Statistics of game */

		System.out.printf("Black pawns number : %d \n",grid.blackCounter());
		System.out.printf("White pawns number : %d \n",grid.whiteCounter());
		System.out.printf("Cases available number : %d \n",grid.availableCaseNumber());
		
		/** Player 1 is the first to play */
		currentPlayer=player1;
		turn();
		
		while(grid.finishParty() != false) // while the party is not finish
		{
		turn();
			
		}
		/** We determine the issue of the party */
		if (grid.blackCounter()>grid.whiteCounter()) System.out.println("Player 1 is the winner!!"); 
		else if (grid.blackCounter()<grid.whiteCounter()) System.out.println("Player 2 is the winner!!");
		else System.out.println("No winner"); /** In the case of equality between the two players */
		
		
	}


}
