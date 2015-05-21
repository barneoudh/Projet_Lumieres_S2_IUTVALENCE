package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

// import fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello.Pawn;

/**
 * Represent a position.
 * 
 * @author Hector Barneoud / Faris Boulakhsoumi
 * @version 1.0.0
 */
public class Position {
	
	/**
	 * The lineNumber of the position
	 */
	private final int lineNumber;
	
	/**
	 * The columnNumber of the position
	 */
	
	private final int columnNumber;
	
	/** Constructor of the position with a linenumber given and columnnumber given
	 * @param lineNumber
	 * @param rowNumber
	 */
	public Position(int lineNumber, int rowNumber) {
		this.lineNumber = lineNumber;
		this.columnNumber = rowNumber;
	}
	
	/** 
	 * Getter of the line of the Position
	 * @return the line number of the Position
	 */
	
	public int line() {
		return this.lineNumber;
	}
	
	/** 
	 * Getter of the column of the Position
	 * @return the column number of the Position
	 */

	public int column() {
		return this.columnNumber;
	}
	
}
