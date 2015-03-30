/* TODO Mettre dans un package. */
/* TODO JAVADOC. */
public class Joueur {
    /* TODO JAVADOC. */
    private final String  pseudo;
    /* TODO JAVADOC. */
    private final Couleur couleurPion;

    /* TODO JAVADOC. */
    /* TODO Convention Java : les paramètres commencent par des minuscules (i.e. pseudo et non Pseudo). */
    public Joueur(String Pseudo, Couleur coulPion) {
        pseudo = Pseudo;
        couleurPion = coulPion;
    }

    /* TODO JAVADOC. */
    public Couleur couleurDuJoueur() {
        return couleurPion;
    }

    /* TODO Eviter le franglais ! */
    /* TODO JAVADOC. */
    public String getPseudo() {
        return pseudo;
    }
}
