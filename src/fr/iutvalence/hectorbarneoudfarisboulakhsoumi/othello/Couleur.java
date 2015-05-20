package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/**
*  Enumeration which allow the use of the black/white color
* @author Hector Barneoud / Faris Boulakhsoumi
*
*/

public enum Couleur {

	/**
	 * The BLACK Color
	 */
	BLACK,
	
	/**
	 * The WHITE Color
	 */
		
	WHITE;

	/**
	 * @see java.lang.Enum#toString()
	 */

	public String toString()
	{
		if (this == WHITE) return "w";
		else return "b";
	}

}
