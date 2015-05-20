package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

/**
 * Othello game: the main.
 * 
 * @author Hector Barneoud / Faris Boulakhsoumi
 * @version 1.0.0
 * @see Game
 */

public class Othello {

	/**
	 * @throws InvalidPositionException 
	 */
	public static void main(String[] args) throws InvalidPositionException {
		Game game = new Game("Toto","Titi");
		game.start();
	}

}
