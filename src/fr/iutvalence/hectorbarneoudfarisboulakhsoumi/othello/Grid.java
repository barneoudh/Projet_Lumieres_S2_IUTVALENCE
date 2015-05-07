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
			// TODO Verifier les rÃ©gles de pose -> Exception 2
		}
	
	}

		// TODO Poser le pion.
		// TODO Répercuter le coup.
			
		
	
	
	@Override
	public String toString() {
		// TODO
		return super.toString();
	}
	
	private void initGrid(){
		for(int i = 0; i < SIDE_SIZE; i++) {
			for (int j = 0; j < SIDE_SIZE; j++) {
				cases[i][j] = new Case(new Position(i,j));
			}
		}
	}
	
}
