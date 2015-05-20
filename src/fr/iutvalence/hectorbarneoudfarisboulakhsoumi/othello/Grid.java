package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

import java.util.LinkedList;
import java.util.List;

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
		cases = new Case[SIDE_SIZE][SIDE_SIZE];
		initGrid();
	}

	public void putPawn(Position position, Couleur couleur)
			throws NoCasesAvailable, InvalidPosition {

		// TODO Verifier case disponible -> Exception 1 ==> A verfier mais on
		// peut virer
		cases[position.line()][position.column()].putPawn(new Pawn(couleur));
	}

	public int availableCaseNumber() {
		return (64 - (this.blackCounter() + this.whiteCounter()));
	}

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

		for (int i = line - 1; i == 0; i--) {
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
		for (int i = column - 1; i == 0; i--) {
			Couleur c2 = cases[line][i].color();
			if (c2 == null)
				break;
			if (c != couleur)
				continue;
			directions.add(Direction.LEFT);
		}
		for (int i = column + 1; i < SIDE_SIZE; i++) {
			for (int j = line + 1; j < SIDE_SIZE; j++) {
				Couleur c2 = cases[j][i].color();
				if (c2 == null)
					break;
				if (c != couleur)
					continue;
				directions.add(Direction.DOWN_RIGHT);
			}
		}

		for (int i = column - 1; i == 0; i--) {
			for (int j = line - 1; j == 0; j--) {
				Couleur c2 = cases[j][i].color();
				if (c2 == null)
					break;
				if (c != couleur)
					continue;
				directions.add(Direction.UP_LEFT);
			}
		}
		for (int i = column + 1; i < SIDE_SIZE; i++) {
			for (int j = line - 1; j == 0; j--) {
				Couleur c2 = cases[j][i].color();
				if (c2 == null)
					break;
				if (c != couleur)
					continue;
				directions.add(Direction.UP_RIGHT);
			}
		}

		for (int i = column - 1; i == 0; i--) {
			for (int j = line + 1; j < SIDE_SIZE; j++) {
				Couleur c2 = cases[j][i].color();
				if (c2 == null)
					break;
				if (c != couleur)
					continue;
				directions.add(Direction.DOWN_RIGHT);
			}
		}
		return directions;
	}

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
			for (int i = line - 1; i == 0; i--) {
				Case currentCase = cases[i][column];
				if (currentCase.color() != couleur)
					currentCase.getPawn().setCouleur(couleur);
				else
					break;
			}
		}
		if (dirs.contains(Direction.RIGHT)) {
			for (int i = column + 1; i < SIDE_SIZE; i++) {
				Case currentCase = cases[i][line];
				if (currentCase.color() != couleur)
					currentCase.getPawn().setCouleur(couleur);
				else
					break;
			}
		}
		if (dirs.contains(Direction.LEFT)) {
			for (int i = column - 1; i == 0; i--) {
				Case currentCase = cases[i][line];
				if (currentCase.color() != couleur)
					currentCase.getPawn().setCouleur(couleur);
				else
					break;
			}
		}
		if (dirs.contains(Direction.DOWN_RIGHT)) {
			for (int i = column + 1; i < SIDE_SIZE; i++) {
				for (int j = line + 1; j < SIDE_SIZE; j++) {
					Case currentCase = cases[i][j];
					if (currentCase.color() != couleur)
						currentCase.getPawn().setCouleur(couleur);
					else
						break;
				}
			}
		}
		if (dirs.contains(Direction.UP_LEFT)) {
			for (int i = column - 1; i == 0; i--) {
				for (int j = line - 1; j == 0; j--) {
					Case currentCase = cases[j][i];
					if (currentCase.color() != couleur)
						currentCase.getPawn().setCouleur(couleur);
					else
						break;
				}
			}
		}
		if (dirs.contains(Direction.UP_RIGHT)) {
			for (int i = column + 1; i < SIDE_SIZE; i++) {
				for (int j = line - 1; j == 0; j--) {
					Case currentCase = cases[j][i];
					if (currentCase.color() != couleur)
						currentCase.getPawn().setCouleur(couleur);
					else
						break;
				}
			}
		}
		if (dirs.contains(Direction.DOWN_LEFT)) {
			for (int i = column - 1; i == 0; i--) {
				for (int j = line + 1; j < SIDE_SIZE; j++) {
					Case currentCase = cases[j][i];
					if (currentCase.color() != couleur)
						currentCase.getPawn().setCouleur(couleur);
					else
						break;
				}
			}
		}

	}

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

	public void installPawn() {
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
