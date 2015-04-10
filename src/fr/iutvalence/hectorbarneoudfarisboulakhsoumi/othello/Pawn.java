package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/**
 * TODO
 * 
 * @author Hector Barneoud / Faris Boulakhsoumi TD 3F
 */
public enum Pawn {
	BLACK(1), WHITE(0);

	private final int num;

	Pawn(final int num) {
		this.num = num;
	}

	public int num() {
		return num;
	}
}
