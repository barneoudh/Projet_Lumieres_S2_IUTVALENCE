package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/**
 * Othello Pawn.
 * 
 * @author Hector Barneoud / Faris Boulakhsoumi
 * @version 1.0.0
 */
public enum Pawn {
	BLACK(1), WHITE(0), NULL(-1);

	private final int num;

	Pawn(final int num) {
		this.num = num;
	}

	public int num() {
		return num;
	}
	
}
