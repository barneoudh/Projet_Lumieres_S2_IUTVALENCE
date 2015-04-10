package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/** Projet Othello
 * 
 * @author Hector Barneoud / Faris Boulakhsoumi 
 * TD 3F
 */



/* TODO Mettre dans un package. */
/* TODO JAVADOC. */
public class Player {
	/* TODO JAVADOC. */
	private final String alias;
	/* TODO JAVADOC. */
	private final Color pawnColor;
	
	/* TODO JAVADOC. */
	/* TODO Convention Java : les paramètres commencent par des minuscules (i.e. pseudo et non Pseudo). */
	public Player(String Pseudo, Color coulPion) {
	pseudo = Pseudo;
	couleurPion = coulPion;
	}
	
	/* TODO JAVADOC. */
	public Color playerColor() {
	return pawnColor;
	}
	
	
	public String getAlias() {
		return alias;
	}
	}
