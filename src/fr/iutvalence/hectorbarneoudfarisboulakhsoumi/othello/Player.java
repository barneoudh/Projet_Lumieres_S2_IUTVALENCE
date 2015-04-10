package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/* TODO JAVADOC. */
public class Player {
	/* TODO JAVADOC. */
	private final String nickname;
	/* TODO JAVADOC. */
	private final Pawn pawnColor;

	/* TODO JAVADOC. */
	public Player(String pseudo, Pawn coulPion) {
		nickname = pseudo;
		pawnColor = coulPion;
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
