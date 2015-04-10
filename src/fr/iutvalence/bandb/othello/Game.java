package fr.iutvalence.bandb.othello;

/**
 * Othello game: the players and the grid.
 *
 * @author Hector Barneoud / Faris Boulakhsoumi
 * @version 1.0.0
 * @see Player
 * @see Grid
 */
public class Game {
    /* TODO JAVADOC. */
    private final Player player1;
    /* TODO JAVADOC. */
    private final Player player2;
    /* TODO JAVADOC. */
    private final Grid   grid;

    /* TODO JAVADOC */
    public Game(String name1, String name2) {
        this.player1 = new Player(name1, Pawn.BLACK);
        this.player2 = new Player(name2, Pawn.WHITE);
        this.grid = new Grid();
    }
}
