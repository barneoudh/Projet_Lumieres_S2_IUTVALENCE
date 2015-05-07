package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/* We make the Grid class, in order to describe the attributs and methods. */
public class Grid {
	/*  Constant for the Side size grid. */
	private static final int SIDE_SIZE = 8;
	/*  Set case table as attribut to the Grid. The grids could be composed of black or white pawn or nothing */
	private final Case[][] cases;
	private int CASE_AVAILABLE_NUMBER;
	/* This is the constructor for the Grid. */
	
	public Grid()
	{
		CASE_AVAILABLE_NUMBER=64;
		cases = new Case[SIDE_SIZE][SIDE_SIZE];
		initGrid();
		installPawn();
	}
	
	private void installPawn(){
		this.installPawn(new Position(3,4),new Pawn(Couleur.BLACK));
		this.installPawn(new Position(4,3),new Pawn(Couleur.BLACK));
		this.installPawn(new Position(3,3),new Pawn(Couleur.WHITE));
		this.installPawn(new Position(4,4),new Pawn(Couleur.WHITE));
		
	}
	
	private void installPawn(Position position, Pawn pawn)
	{
		this.getCase(position).putPawn(pawn);
	}
	
	private Case getCase(Position position)
	{
		return this.cases[position.getLineNumber()][position.getRowNumber()];
	}
	

	
	private void putPawn(Position position, Pawn pawn) throws NoCasesAvailable
	{

		// TODO Verifier case disponible -> Exception 1

		if(CASE_AVAILABLE_NUMBER == 0) throw new NoCasesAvailable();
		else{
			// TODO Verifier les régles de pose -> Exception 2
		}
		
	}

		// TODO Poser le pion.
		// TODO Répercuter le coup.
			
	
	public String toString()
	{
		String gridLines = "-------------------------------------------------------\n";

		for (int numeroDeLigne = 0; numeroDeLigne < SIDE_SIZE; numeroDeLigne++)
		{
			for (int numeroDeColonne = 0; numeroDeColonne < SIDE_SIZE; numeroDeColonne++)
				gridLines += this.getCase(new Position(numeroDeLigne, numeroDeColonne));
			gridLines += "\n-------------------------------------------------------\n";
		}

		return gridLines;
	}
	
	
	private void initGrid(){
		for(int i = 0; i < SIDE_SIZE; i++) {
			for (int j = 0; j < SIDE_SIZE; j++) {
				cases[i][j] = new Case(new Position(i,j));
			}
		}
	}
	
}
