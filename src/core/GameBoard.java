package core;

/**
 * GameBoard environment that is used for gameplay
 *
 * @author Todd Martin
 * @version 2.0
 */

public class GameBoard {

	private char[][] gameBoard;
	private int numberOfRows;
	private int numberOfColumns;
	private int numberOfEmptyCells;
	
	/**
	 * Creates the gameboard
	 */
	public GameBoard () {
		numberOfRows = 6;
		numberOfColumns = 7;
		numberOfEmptyCells = numberOfRows * numberOfColumns;
		gameBoard = new char[numberOfRows][numberOfColumns];

		for (int r = 0; r < gameBoard.length; r++)
			for (int c = 0; c < gameBoard[0].length; c++)
				gameBoard[r][c] = ' ';
	}

	/**
	 * Updates the gameboard when a move is made by a player
	 *
	 * @param column Column that player selected to drop chip
	 * @param chip Player's chip
	 * @return returns true if the move could be made, false if not
	 */
	public boolean updateGameBoard (int column, char chip) {
		System.out.println(column);
		if (column < 0 || column >= 7) return false;
		for (int i = (gameBoard.length - 1); i >= 0; i--) {
			if (gameBoard[i][column] == ' ') {
				gameBoard[i][column] = chip;
				numberOfEmptyCells--;
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the top (visually) most unfilled row in a column
	 *
	 * @param column Column that is selected
	 * @return returns the row
	 */
	public int getTopFilledRowInColumn (int column) {
		for (int i = 0; i < gameBoard[0].length; i++){
			if (gameBoard[i][column] != ' ') return i;
		}
		return -1;
	}

	/**
	 * Gets the character stored at the cell in the 2-d array
	 *
	 * @param row Row selected
	 * @param column Column selected
	 * @return Returns the character stored in cell
	 */
	public char getCell (int row, int column) {
		return gameBoard[row][column];
	}

	/**
	 * Returns the length of the columns
	 *
	 * @return Returns the column length
	 */
	public int getColumnLength () {
		return gameBoard[0].length;
	}

	/**
	 * Retirns the length of the rows
	 *
	 * @return Return the row length
	 */
	public int getRowLength () {
		return gameBoard.length;
	}

	/**
	 * Get the number of empty cells left on the gameboard.
	 *
	 * @return the number of empty cells left
	 */
	public int getEmptyCells () {
		return numberOfEmptyCells;
	}

	/**
	 * Returns the 2-d array that serves as a gameboard
	 *
	 * @return 2-d char array that serves as the gameboard.
	 */
	public char[][] getGameBoard () {
		return gameBoard;
	}

	public String toString () {
		String gameBoardString = "";
		for (int r = 0; r < gameBoard.length; r++)
			for (int c = 0; c < gameBoard[0].length; c++)
				gameBoardString = gameBoardString + gameBoard[r][c];

		return gameBoardString;
	}
	
}
