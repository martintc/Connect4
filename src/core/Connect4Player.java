package core;

/**
 * Player object that tracks player chip count and chip representation.
 *
 * @author Todd Martin
 * @version 1.0
 */
public class Connect4Player {

	private int chipCount;
	private char symbol;

	/**
	 * Constructor the initializes a player object
	 *
	 * @author Todd Martin
	 * @param symbol Sets the symbol that represents a player in the gameplay
	 */
	public Connect4Player (char symbol) {
		this.symbol = symbol;
		chipCount = 21;
	}

	/**
	 * Returns the player's symbol
	 *
	 * @author Todd Martin
	 * @return Symbol that represents the player object
	 */
	public char getPlayerSymbol () {
		return symbol;
	}
	/**
	 * Returns the number of chips the player object has
	 *
	 * @author Todd Martin
	 * @return Number of chips the player object has
	 */
	public int getNumberOfChips () {
		return chipCount;
	}

	/**
	 * When a player makes a move, they loose a chip to gameplay and their symbol is returned as their chip.
	 *
	 * @author Todd Martin
	 * @return returns the symbol that represents the player object
	 */
	public char makeMove () {
		chipCount--;
		return symbol;
	}
	
}
