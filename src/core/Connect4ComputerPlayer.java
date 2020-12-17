package core;

/** 
 * Extends the player class. This is necessary as it is used in Connect4 to know how the player should move. Connect4 polls to see the next player, if it is an
 * instance of this class, it will make a different set of moves than if it were of the instance of HumanPlayer.
 */

public class Connect4ComputerPlayer extends Connect4Player {

	/**
	 * Initializes the computer player.
	 *
	 * @param symbol symbol that represents the player's chip.
	 */
	public Connect4ComputerPlayer (char symbol) {
		super(symbol);
	}

}
