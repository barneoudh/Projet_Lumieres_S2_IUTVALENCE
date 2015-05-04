package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/* We make the Grid class, in order to describe the attributs and methods. */
public class Grid {
	/*  Constant for the Side size grid. */
	private static final int SIDE_SIZE = 8;
	/*  Set pawntable as attribut to the Grid. The grids could be composed of black or white pawn or nothing */
	private final Pawn[][] grid;

	/* This is the constructor for the Grid. */
	public Grid() {
		this.grid = new Pawn[SIDE_SIZE][SIDE_SIZE];
	}

	public Pawn[][] getGrid() {
		return grid;
	}
	
	/*public string toString{
		
	}*/
}