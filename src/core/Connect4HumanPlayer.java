package core;

/**
 * Extends the player class. Used for human players. This is necessary to ensure game flow in the Connect4 class.
 * In order to know how this player should move, it much match the instance with this class if it is a human player.

 * @author Todd Martin
 * @version 1.0
 */

public class Connect4HumanPlayer extends Connect4Player {

	/**
	 * Initializes the player.
	 *
	 * @param symbol symbol that represents the player.
	 */
	public Connect4HumanPlayer (char symbol) {
		super(symbol);
	}
	
}
