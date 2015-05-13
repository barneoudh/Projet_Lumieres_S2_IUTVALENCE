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
	 * @param We assign White pawns to the player 2
	 */
	public Game(String player1, String player2) {
		this.player1 = new Player(player1, Couleur.BLACK);
		this.player2 = new Player(player2, Couleur.WHITE);
		this.grid = new Grid();
	}
	
	
	public void start() {
		System.out.println(grid);
		whiteCounter = 2;
		blackCounter = 2;
		currentPlayer=player1;
		
		private void interaction() {
		java.util.Scanner entree = new java.util.Scanner(System.in);
		
		System.out.println("Entrez la ligne");
		int i = entree.nextInt();
		System.out.println("Entrez la colonne");
		int j = entree.nextInt();
		
		Position position = new Position(i, j);
		
		if(currentPlayer==player1) Pawn pawn = Couleur.BLACK;
		else Pawn pawn = Couleur.WHITE;
		
		if (verifCoup(Position position, Pawn pawn))
		{
			// TODO Afficher le nouvel état de la grille.
			currentPlayer = currentPlayer == player1 ? player2 : player1;
		}
		else
		{
		// TODO 	Sinon -> Redemander
			interaction();
		}

		}
		while(finishparty() != false) // while the party is not finish */
		{
		interaction();
			
		}
		
		
	}
}
