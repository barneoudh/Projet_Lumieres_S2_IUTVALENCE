package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/* We make the Grid class, in order to describe the attributs and methods. */
public class Grid {
	/*  Constant for the Side size grid. */
	private static final int SIDE_SIZE = 8;
	/*  Set case table as attribut to the Grid. The grids could be composed of black or white pawn or nothing */
	private final Case[][] cases;
	
	/* This is the constructor for the Grid. */
	public Grid()
	{
		
		cases = new Case[SIDE_SIZE][SIDE_SIZE];
		initGrid();
		putPawn();
	}
	
	private void putPawn(){
		this.putPawn(new Position(3,4),new Pawn(Couleur.BLACK));
		this.putPawn(new Position(4,3),new Pawn(Couleur.BLACK));
		this.putPawn(new Position(3,3),new Pawn(Couleur.WHITE));
		this.putPawn(new Position(4,4),new Pawn(Couleur.BLACK));
		
	}
	
	private void putPawn(Position position, Pawn pawn)
	{
		this.getCase(position).putPawn(pawn);
	}
	
	private Case getCase(Position position)
	{
		return this.cases[position.getLineNumber()][position.getRowNumber()];
	}
	
	public AvailableCasesVerification() throws NoCasesAvailable; // if no available case
	{
		if(CASE_AVAILABLE_NUMBER == 0) throw new NoCasesAvailable();
		
	}
	
	/*private void putPawn(Position position, Pawn pawn){
		this.putPawn(new Position(4,5),new Pawn);
		// TODO Verifier case disponible -> Exception 1
		if(CASE_AVAILABLE_NUMBER == 0)
			try {
				throw new NoCasesAvailable();
			} catch (NoCasesAvailable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
	
			
		// TODO Verifier les régles de pose -> Exception 2
		
		// TODO Poser le pion.
		// TODO Répercuter le coup.
			

	
	/*@Override
	public String toString() {
		// TODO
		return super.toString();
	}*/
	
	public String toString()
	{
		String GridAsciiArt = "------------------------------------------------\n";

		for (int numeroDeLigne = 0; numeroDeLigne < SIDE_SIZE; numeroDeLigne++)
		{
			for (int numeroDeColonne = 0; numeroDeColonne < SIDE_SIZE; numeroDeColonne++)
				GridAsciiArt += this.getCase(new Position(numeroDeLigne, numeroDeColonne));
			GridAsciiArt += "\n------------------------------------------------\n";
		}

		return GridAsciiArt;
	}
	
	
	private void initGrid(){
		for(int i = 0; i < SIDE_SIZE; i++) {
			for (int j = 0; j < SIDE_SIZE; j++) {
				cases[i][j] = new Case(new Position(i,j));
			}
		}
	}
	
}
