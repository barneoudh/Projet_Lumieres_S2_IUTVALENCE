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
		
		if (!verifCoup(position,couleur)) throw new InvalidPosition();
		
		cases[position.line()][position.column()].putPawn(new Pawn(couleur)); 	
	}
	
	public Direction playable(Position position, Couleur couleur){
		
		int line = position.line();
		int column = position.column();
		
		
		Couleur c = cases[line][column].color();
		if (c == null) {
			for (int i = line+2; i < SIDE_SIZE; i++) {
				Couleur c2 = cases[i][column].color();
				if (c2 == null) break;
				if (c != couleur) continue;
				return Direction.DOWN;}
			}
			
		if (c == null) {
			for (int i = line-2; i < SIDE_SIZE; i--) {
				Couleur c2 = cases[i][column].color();
				if (c2 == null) break;
				if (c != couleur) continue;
				return Direction.UP;}
		}
		
		if (c == null) {
			for (int i = column+2; i < SIDE_SIZE; i++) {
				Couleur c2 = cases[line][i].color();
				if (c2 == null) break;
				if (c != couleur) continue;
				return Direction.RIGHT;}
		}
		
		if (c == null) {
			for (int i = column-2; i < SIDE_SIZE; i--) {
				Couleur c2 = cases[line][i].color();
				if (c2 == null) break;
				if (c != couleur) continue;
				return Direction.LEFT;}
		}

		if (c == null) {
			for (int i = column+2; i < SIDE_SIZE; i++){
				for (int j = line+2; j < SIDE_SIZE; j++){
				Couleur c2 = cases[j][i].color();
				if (c2 == null) break;
				if (c != couleur) continue;
				return Direction.DOWN_RIGHT;}
		} 
		}
		
		if (c == null) {
			for (int i = column-2; i < SIDE_SIZE; i--){
				for (int j = line-2; j < SIDE_SIZE; j--){
				Couleur c2 = cases[j][i].color();
				if (c2 == null) break;
				if (c != couleur) continue;
				return Direction.UP_LEFT;}
		} 
		}
		
		if (c == null) {
			for (int i = column+2; i < SIDE_SIZE; i++){
				for (int j = line-2; j < SIDE_SIZE; j--){
				Couleur c2 = cases[j][i].color();
				if (c2 == null) break;
				if (c != couleur) continue;
				return Direction.UP_RIGHT;}
		} 
		}
		
		if (c == null) {
			for (int i = column-2; i < SIDE_SIZE; i--){
				for (int j = line+2; j < SIDE_SIZE; j++){
				Couleur c2 = cases[j][i].color();
				if (c2 == null) break;
				if (c != couleur) continue;
				return Direction.DOWN_RIGHT;}
		} 
		}
		return Direction.NULL;
	}
	
	public void changePawnColor(Position position, Couleur couleur){
		
	}

	public boolean finishParty() {
		if (availableCaseNumber == 0) {
			return true;
		}

		for (int i = 0; i == SIDE_SIZE; i++) {
			for (int j = 0; j == SIDE_SIZE; j++) {
				Position position = new Position(i, j);
				if (cases[i][j].isAvailable()) {
					if (playable(position,Couleur.BLACK ) != Direction.NULL) {
						if (playable(position,Couleur.WHITE)!= Direction.NULL)
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

		
		int line = position.line();
		int column = position.column();
		if((cases[line+1][column].color() != couleur && cases[line+1][column].color() != null) 
			||(cases[line-1][column].color() != couleur && cases[line-1][column].color() != null)
			||(cases[line][column-1].color() != couleur && cases[line][column-1].color() != null)
			||(cases[line][column+1].color() != couleur && cases[line][column+1].color() != null)
			||(cases[line+1][column+1].color() != couleur && cases[line+1][column+1].color() != null)
			||(cases[line-1][column-1].color() != couleur && cases[line-1][column-1].color() != null)
			||(cases[line+1][column-1].color() != couleur && cases[line+1][column-1].color() != null)
			||(cases[line-1][column+1].color() != couleur && cases[line-1][column+1].color() != null))
		{
			if (playable(position,couleur)!=Direction.NULL)
				good=true;
		}
		
		return good;
		
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
		return this.cases[position.line()][position.column()];
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
