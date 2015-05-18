package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/* We make the Grid class, in order to describe the attributs and methods. */
public class Grid {
	/* Constant for the Side size grid. */
	private static final int SIDE_SIZE = 8;
	/*
	 * Set case table as attribut to the Grid. The grids could be composed of
	 * black or white pawn or nothing
	 */
	private final Case[][] cases;
	private int availableCaseNumber;

	/* This is the constructor for the Grid. */

	public Grid() {
		availableCaseNumber = 64;
		cases = new Case[SIDE_SIZE][SIDE_SIZE];
		initGrid();
	}

	public void putPawn(Position position, Couleur couleur) throws NoCasesAvailable, InvalidPosition{

		// TODO Verifier case disponible -> Exception 1 ==> A verfier mais on peut virer
		if (availableCaseNumber == 0) throw new NoCasesAvailable();
		else {
			if (verifCoup(position,couleur)==false) throw new InvalidPosition();
			else putPawn(position, couleur); 	
		}

	}
	
	public boolean playable(Position position, Couleur couleur){
		boolean good = false;
		
		for(Case i=cases[position.lineNumber][position.rowNumber];i==cases[SIDE_SIZE][SIDE_SIZE];i=cases[position.lineNumber+1][position.rowNumber]){
			if(i.getPawn().getCouleur()!=couleur) good = true;
			else good=false;}
		for(Case i=cases[position.lineNumber][position.rowNumber];i==cases[SIDE_SIZE][SIDE_SIZE];i=cases[position.lineNumber-1][position.rowNumber]){
			if(i.getPawn().getCouleur()!=couleur) good = true;
			else good = false;}
		for(Case i=cases[position.lineNumber][position.rowNumber];i==cases[SIDE_SIZE][SIDE_SIZE];i=cases[position.lineNumber][position.rowNumber-1]){
			if(i.getPawn().getCouleur()!=couleur) good = true;
			else good = false;}
		for(Case i=cases[position.lineNumber][position.rowNumber];i==cases[SIDE_SIZE][SIDE_SIZE];i=cases[position.lineNumber][position.rowNumber+1]){
			if(i.getPawn().getCouleur()!=couleur) good = true;
			else good = false;}
		for(Case i=cases[position.lineNumber][position.rowNumber];i==cases[SIDE_SIZE][SIDE_SIZE];i=cases[position.lineNumber+1][position.rowNumber+1]){
			if(i.getPawn().getCouleur()!=couleur) good = true;
			else good = false;}
		for(Case i=cases[position.lineNumber][position.rowNumber];i==cases[SIDE_SIZE][SIDE_SIZE];i=cases[position.lineNumber-1][position.rowNumber-1]){
			if(i.getPawn().getCouleur()!=couleur) good = true;
			else good = false;}
		for(Case i=cases[position.lineNumber][position.rowNumber];i==cases[SIDE_SIZE][SIDE_SIZE];i=cases[position.lineNumber+1][position.rowNumber-1]){
			if(i.getPawn().getCouleur()!=couleur) good = true;
			else good = false;}
		for(Case i=cases[position.lineNumber][position.rowNumber];i==cases[SIDE_SIZE][SIDE_SIZE];i=cases[position.lineNumber-1][position.rowNumber+1]){
			if(i.getPawn().getCouleur()!=couleur) good = true;
			else good = false;}
		
		return good;
	}

	public boolean finishParty() {
		if (availableCaseNumber == 0) {
			return true;
		}

		for (int i = 0; i == SIDE_SIZE; i++) {
			for (int j = 0; j == SIDE_SIZE; j++) {
				Position position = new Position(i, j);
				if (cases[i][j].isAvailable()) {
					if (playable(position,Couleur.BLACK ) || playable(position, Couleur.WHITE)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public boolean verifCoup(Position position, Couleur couleur)
	{
		 boolean good = false;
		
		if(cases[position.lineNumber+1][position.rowNumber].getPawn().getCouleur() != couleur
			||cases[position.lineNumber-1][position.rowNumber].getPawn().getCouleur() != couleur 
			||cases[position.lineNumber][position.rowNumber-1].getPawn().getCouleur() != couleur
			||cases[position.lineNumber][position.rowNumber+1].getPawn().getCouleur() != couleur
			||cases[position.lineNumber+1][position.rowNumber+1].getPawn().getCouleur() != couleur
			||cases[position.lineNumber-1][position.rowNumber-1].getPawn().getCouleur() != couleur
			||cases[position.lineNumber+1][position.rowNumber-1].getPawn().getCouleur() != couleur
			||cases[position.lineNumber-1][position.rowNumber+1].getPawn().getCouleur() != couleur	
			)
		{
			if(playable(position,couleur)) good = true;
			else good = false;		
		}
		
		if(good) return true;
		else return false;
		
	}

	private void installPawn() {
		this.installPawn(new Position(3, 4), new Pawn(Couleur.BLACK));
		this.installPawn(new Position(4, 3), new Pawn(Couleur.BLACK));
		this.installPawn(new Position(3, 3), new Pawn(Couleur.WHITE));
		this.installPawn(new Position(4, 4), new Pawn(Couleur.WHITE));

	}

	private void installPawn(Position position, Pawn pawn) {
		this.getCase(position).putPawn(pawn);
	}

	private Case getCase(Position position) {
		// TODO Exception
		return this.cases[position.getLineNumber()][position.getRowNumber()];
	}

	private void initGrid() {
		for (int i = 0; i < SIDE_SIZE; i++) {
			for (int j = 0; j < SIDE_SIZE; j++) {
				cases[i][j] = new Case();
			}
		}
	}

	public String toString() {
		String gridLines = "-------------------------------------------------------\n";

		for (int numeroDeLigne = 0; numeroDeLigne < SIDE_SIZE; numeroDeLigne++) {
			for (int numeroDeColonne = 0; numeroDeColonne < SIDE_SIZE; numeroDeColonne++)
				gridLines += this.getCase(new Position(numeroDeLigne,
						numeroDeColonne));
			gridLines += "\n-------------------------------------------------------\n";
		}

		return gridLines;
	}
}
