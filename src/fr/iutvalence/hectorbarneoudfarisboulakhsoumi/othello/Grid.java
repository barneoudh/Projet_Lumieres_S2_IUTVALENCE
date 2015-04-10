package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/* TODO JAVADOC. */
public class Grid {
	/* TODO JAVADOC. */
	private static final int TAILLE_COTE = 8;
	/* TODO JAVADOC. */
	private final Pawn[][] grid;
	
	/* TODO À quoi sert le second paramètre ? */
	/* TODO JAVADOC. */
	public Grid() {
		this.grid = new Pawn[TAILLE_COTE][TAILLE_COTE];
	}
}