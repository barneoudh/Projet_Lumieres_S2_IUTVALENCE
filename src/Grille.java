/* TODO Mettre dans un package. */
/* TODO JAVADOC. */
public class Grille {
    /* TODO À remplacer par une seule constante (TAILLE_COTE) ? */
    /* TODO JAVADOC. */
    private static final int NB_LIGNE   = 8;
    /* TODO JAVADOC. */
    private static final int NB_COLONNE = NB_LIGNE;
    /* TODO JAVADOC. */
    private final Pion[][] grille;
    /* TODO Pertinence de cet attribut ? */
    /** Couleur du plateau de jeu. */
    private       Couleur  couleurGrille;

    /* TODO À quoi sert le second paramètre ? */
    /* TODO JAVADOC. */
    public Grille(Couleur coulGrille, Grille grille) {
        couleurGrille = coulGrille;
        this.grille = new Pion[NB_LIGNE][NB_COLONNE];
        /* TODO Remplir le tableau. */
    }

    /* TODO JAVADOC. */
    public Pion[][] GetGrille() {
        return grille;
    }

}
