package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

public class Position {
	
	private final int lineNumber;
	private final int columnNumber;
	/**
	 * @param x
	 * @param y
	 */
	public Position(int lineNumber, int rowNumber) {
		this.lineNumber = lineNumber;
		this.columnNumber = rowNumber;
	}
	public int line() {
		return this.lineNumber;
	}
	public int column() {
		return this.columnNumber;
	}
	
}
