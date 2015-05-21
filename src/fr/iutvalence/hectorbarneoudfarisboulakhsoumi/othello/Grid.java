package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

import java.util.LinkedList;
import java.util.List;

/**
 *  We make the Grid class, in order to describe the attributs and methods. 
 */
public class Grid {
	/**
	 *  Constant for the Side size grid. 
	*/
	private static final int SIDE_SIZE = 8;
	/**
	 * Set case table as attribut to the Grid. The grids could be composed of
	 *  a table of cases with black or white pawn or nothing
	 */
	private final Case[][] cases;
	private int availableCaseNumber;

	/**
	 * This is the constructor for the Grid. We create a table of cases 
	 */

	public Grid() {
		cases = new Case[SIDE_SIZE][SIDE_SIZE];
		initGrid();
	}

	/**
	 * Put a paw of the given color, in a given case
	 * @param position
	 * @param couleur
	 */
	
	public void putPawn(Position position, Couleur couleur) {
		
		cases[position.line()][position.column()].putPawn(new Pawn(couleur));
	}
	
	/**
	 * To get the available case number of the checkerboard
	 * @return the available case number of the checkerboard
	 */

	public int availableCaseNumber() {
		return (64 - (this.blackCounter() + this.whiteCounter()));
	}
	
	/**
	 * To determine the direction of the path to each the others pawns of the current player on the checkerboard
	 * relative to a given position
	 * @param position
	 * @param couleur
	 * @return a list which contains the directions of the paths to the others pawns of the current player 
	 * on the checkerboard relative to a given position
	 */

	public List<Direction> playable(Position position, Couleur couleur) {
		int line = position.line();
		int column = position.column();
		List<Direction> directions = new LinkedList<>();

		Couleur c = cases[line][column].color();
		if (c != null) {
			return directions;
		}

		for (int i = line + 1; i < SIDE_SIZE; i++) {
			Couleur c2 = cases[i][column].color();
			if (c2 == null)
				break;
			if (c != couleur)
				continue;
			directions.add(Direction.DOWN);
		}

		for (int i = line - 1; i > 0; i--) {
			Couleur c2 = cases[i][column].color();
			if (c2 == null)
				break;
			if (c != couleur)
				continue;
			directions.add(Direction.UP);
		}
		for (int i = column + 1; i < SIDE_SIZE; i++) {
			Couleur c2 = cases[line][i].color();
			if (c2 == null)
				break;
			if (c != couleur)
				continue;
			directions.add(Direction.RIGHT);
		}
		for (int i = column - 1; i > 0; i--) {
			Couleur c2 = cases[line][i].color();
			if (c2 == null)
				break;
			if (c != couleur)
				continue;
			directions.add(Direction.LEFT);
		}
		for (int i = line + 1; i < SIDE_SIZE; i++) {
			for (int j = column + 1; j < SIDE_SIZE; j++) {
				Couleur c2 = cases[i][j].color();
				if (c2 == null)
					break;
				if (c != couleur)
					continue;
				directions.add(Direction.DOWN_RIGHT);
			}
		}

		for (int i = line - 1; i > 0; i--) {
			for (int j = column - 1; j > 0; j--) {
				Couleur c2 = cases[i][j].color();
				if (c2 == null)
					break;
				if (c != couleur)
					continue;
				directions.add(Direction.UP_LEFT);
			}
		}
		for (int i = line - 1; i > 0; i--) {
			for (int j = column + 1; j > SIDE_SIZE; j++) {
				Couleur c2 = cases[i][j].color();
				if (c2 == null)
					break;
				if (c != couleur)
					continue;
				directions.add(Direction.UP_RIGHT);
			}
		}

		for (int i = line + 1; i < SIDE_SIZE; i++) {
			for (int j = column + 1; j < SIDE_SIZE; j++) {
				Couleur c2 = cases[i][j].color();
				if (c2 == null)
					break;
				if (c != couleur)
					continue;
				directions.add(Direction.DOWN_RIGHT);
			}
		}
		return directions;
	}

	/**
	 * To determine if the current party is done
	 * @return a boolean : true the party is finish, false the party is not finish
	 */
	public boolean finishParty() {
		if (availableCaseNumber == 0) {
			return true;
		}

		for (int i = 0; i == SIDE_SIZE; i++) {
			for (int j = 0; j == SIDE_SIZE; j++) {
				Position position = new Position(i, j);
				if (cases[i][j].isAvailable()) {
					if (playable(position, Couleur.BLACK) != null) {
						if (playable(position, Couleur.WHITE) != null)
							return false;
					}
				}
			}
		}
		return true;
	}

	
	/**
	 * To turn the pawns of the other player which are in the path of the pawns of the current player on the checkerboard
	 * relative to a given position in a pawns of the current player
	 * @param position
	 * @param couleur
	 * @param dirs
	 */
	
	public void returnThePawns(Position position, Couleur couleur,
			List<Direction> dirs) {

		int line = position.line();
		int column = position.column();
		
		if (dirs.contains(Direction.DOWN)) {
		for (int i = line + 1; i < SIDE_SIZE; i++) {
				Case currentCase = cases[i][column];
				if (currentCase.color() != couleur)
					currentCase.getPawn().setCouleur(couleur);
				else
					break;
			}
		}
		
		if (dirs.contains(Direction.UP)) {
			for (int i = line - 1; i > 0; i--) {
				Case currentCase = cases[i][column];
				if (currentCase.color() != couleur)
					currentCase.getPawn().setCouleur(couleur);
				else
					break;
			}
		}
		if (dirs.contains(Direction.RIGHT)) {
			for (int i = column + 1; i < SIDE_SIZE; i++) {
				Case currentCase = cases[line][i];
				if (currentCase.color() != couleur)
					currentCase.getPawn().setCouleur(couleur);
				else
					break;
			}
		}
		if (dirs.contains(Direction.LEFT)) {
			for (int i = column - 1; i > 0; i--) {
				Case currentCase = cases[line][i];
				if (currentCase.color() != couleur)
					currentCase.getPawn().setCouleur(couleur);
				else
					break;
			}
		}
		if (dirs.contains(Direction.DOWN_RIGHT)) {
			for (int i = line + 1; i < SIDE_SIZE; i++) {
				for (int j = column + 1; j < SIDE_SIZE; j++) {
					Case currentCase = cases[i][j];
					if (currentCase.color() != couleur)
						currentCase.getPawn().setCouleur(couleur);
					else
						break;
				}
			}
		}
		if (dirs.contains(Direction.UP_LEFT)) {
			for (int i = line - 1; i > 0; i--) {
				for (int j = column - 1; j > 0; j--) {
					Case currentCase = cases[i][j];
					if (currentCase.color() != couleur)
						currentCase.getPawn().setCouleur(couleur);
					else
						break;
				}
			}
		}
		if (dirs.contains(Direction.UP_RIGHT)) {
			for (int i = line - 1; i > 0; i--) {
				for (int j = column + 1; j == 0; j++) {
					Case currentCase = cases[i][j];
					if (currentCase.color() != couleur)
						currentCase.getPawn().setCouleur(couleur);
					else
						break;
				}
			}
		}
		if (dirs.contains(Direction.DOWN_LEFT)) {
			for (int i = line + 1; i < SIDE_SIZE; i++) {
				for (int j = column - 1; j > 0; j--) {
					Case currentCase = cases[i][j];
					if (currentCase.color() != couleur)
						currentCase.getPawn().setCouleur(couleur);
					else
						break;
				}
			}
		}

	}
	
	/** 
	 * To check the playability of the adjacents cases (directly) relative to a given position
	 * @param position
	 * @param couleur
	 * @return boolean : true if at least one adjacent case is playable, false if no adjacent (directly) case playable
	 */

	public boolean verifCoup(Position position, Couleur couleur) {
		boolean good = false;

		int line = position.line();
		int column = position.column();
		if ((cases[line + 1][column].color() != couleur && cases[line + 1][column]
				.color() != null)
				|| (cases[line - 1][column].color() != couleur && cases[line - 1][column]
						.color() != null)
				|| (cases[line][column - 1].color() != couleur && cases[line][column - 1]
						.color() != null)
				|| (cases[line][column + 1].color() != couleur && cases[line][column + 1]
						.color() != null)
				|| (cases[line + 1][column + 1].color() != couleur && cases[line + 1][column + 1]
						.color() != null)
				|| (cases[line - 1][column - 1].color() != couleur && cases[line - 1][column - 1]
						.color() != null)
				|| (cases[line + 1][column - 1].color() != couleur && cases[line + 1][column - 1]
						.color() != null)
				|| (cases[line - 1][column + 1].color() != couleur && cases[line - 1][column + 1]
						.color() != null)) {
			if (playable(position, couleur) != null)
				good = true;
		}

		return good;

	}
	
	/** 
	 * To put the pawns of start, at the start of the game
	 */

	public void installPawn() {
		this.installPawn(new Position(3, 4), new Pawn(Couleur.BLACK));
		this.installPawn(new Position(4, 3), new Pawn(Couleur.BLACK));
		this.installPawn(new Position(3, 3), new Pawn(Couleur.WHITE));
		this.installPawn(new Position(4, 4), new Pawn(Couleur.WHITE));

	}

	/**
	 * To put a given pawn in the table case to a given position (put a pawn...)
	 */
	
	private void installPawn(Position position, Pawn pawn) {
		this.getCase(position).putPawn(pawn);
	}

	private Case getCase(Position position) {

		return this.cases[position.line()][position.column()];
	}

	private void initGrid() {
		for (int i = 0; i < SIDE_SIZE; i++) {
			for (int j = 0; j < SIDE_SIZE; j++) {
				cases[i][j] = new Case();
			}
		}
	}

	public int blackCounter() {
		int counter = 0;
		for (int i = 0; i < SIDE_SIZE; i++) {
			for (int j = 0; j < SIDE_SIZE; j++) {
				if (cases[i][j].color() == Couleur.BLACK) {
					counter++;
				}
			}
		}
		return counter;
	}

	public int whiteCounter() {
		int counter = 0;
		for (int i = 0; i < SIDE_SIZE; i++) {
			for (int j = 0; j < SIDE_SIZE; j++) {
				if (cases[i][j].color() == Couleur.WHITE) {
					counter++;
				}
			}
		}
		return counter;
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
