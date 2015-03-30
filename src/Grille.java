
public class Grille 
{
	private final static int NB_LIGNE = 8;
	private final static int NB_COLONNE = NB_LIGNE;
	/** Couleur du plateau de jeu. */ 
	private Couleur couleurGrille;
    private final Pion[][] grille;

	public Grille(Couleur coulGrille,Grille grille) 
	{
		couleurGrille = coulGrille;
		grille = new Pion[NB_LIGNE][NB_COLONNE];
		/* TODO Remplir le tableau. */
	}

	
	public Pion[][] GetGrille() {
		return grille;
	}
	
}