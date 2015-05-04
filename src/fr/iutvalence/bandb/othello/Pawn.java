package fr.iutvalence.bandb.othello;

/**
 * TODO
 *
 * @author Hector Barneoud / Faris Boulakhsoumi TD 3F
 */
public enum Pawn {
    /* TODO JAVADOC. */
    BLACK(1),
    /* TODO JAVADOC. */
    WHITE(0);
    /* TODO JAVADOC. */
    private final int num;

    /* TODO JAVADOC. */
    Pawn(final int num) {
        this.num = num;
    }

    /* TODO JAVADOC. */
    public int num() {
        return num;
    }
}
