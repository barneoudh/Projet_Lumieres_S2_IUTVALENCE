package fr.iutvalence.bandb.othello;

/* TODO JAVADOC. */
public class Player {
    /* TODO JAVADOC. */
    private final String nickname;
    /* TODO JAVADOC. */
    private final Pawn   pawnColor;

    /* TODO JAVADOC. */
    public Player(String nick, Pawn color) {
        nickname = nick;
        pawnColor = color;
    }

    /* TODO JAVADOC. */
    public Pawn color() {
        return pawnColor;
    }

    /* TODO JAVADOC. */
    public String nickname() {
        return nickname;
    }
}
