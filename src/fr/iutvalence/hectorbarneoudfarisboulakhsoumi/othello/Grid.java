package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/** Projet Othello
 * 
 * @author Hector Barneoud / Faris Boulakhsoumi 
 * TD 3F
 */

/*TODO Mettre dans un package. */
/* TODO JAVADOC. */
public class Grid {
 /* TODO À remplacer par une seule constante (TAILLE_COTE) ? */
 /* TODO JAVADOC. */
 private static final int NB_LIGNE = 8;
 /* TODO JAVADOC. */
 private static final int NB_COLONNE = NB_LIGNE;
 /* TODO JAVADOC. */

    private final Pawn[][] grid;

    private Color gridColor;
    
    /* TODO À quoi sert le second paramètre ? */
    /* TODO JAVADOC. */
	
    public Grid(Pawn[][] grid) {
		this.grid = grid;
	}



	/* TODO JAVADOC. */
    public Pawn[][] getGrid() {
    	return grid;
    }


	public String toString() {
		;
	}
    
    
    
	
}