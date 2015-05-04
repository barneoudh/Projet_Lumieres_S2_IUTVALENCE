package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

public class Position {
	
	public final int lineNumber;
	public final int rowNumber;
	/**
	 * @param x
	 * @param y
	 */
	public Position(int lineNumber, int rowNumber) {
		this.lineNumber = lineNumber;
		this.rowNumber = rowNumber;
	}
	public int getLineNumber() {
		return this.lineNumber;
	}
	public int getRowNumber() {
		return this.rowNumber;
	}
	
}
