package core;
import core.*;

public class Connect4 {

	private PlayerCircularLinkedList playerList;
	private GameBoard gameBoard;
	private boolean gameWinState;
	private Connect4Player currentPlayer;

	/**
	* Constructor to use for local play.
	*/
	public Connect4 (boolean multiplayer) {
		gameBoard = new GameBoard();
		gameWinState = false;
		if (multiplayer)
			playerList = new PlayerCircularLinkedList(new Connect4HumanPlayer('x'), new Connect4HumanPlayer('o'));
		else
			playerList = new PlayerCircularLinkedList(new Connect4HumanPlayer('x'), new Connect4ComputerPlayer('o'));
		this.getPlayerTurn();
	}

	/**
	* Constructor used for network play
	*/
	public Connect4 () {
		// currently empty
	}

	public char getPlayerTurn () {
		currentPlayer = playerList.getPlayer();
		if (currentPlayer instanceof Connect4ComputerPlayer)
			this.playerMakesMove(this.moveGenerator());
		return currentPlayer.getPlayerSymbol();
	}

	private int moveGenerator () {
		double random = Math.random();
		random = random * 100;
		int move = (int) random;
		return move % 7;
	}

	public boolean playerMakesMove (int columnSelected) {
		if (!checkIfMoveValid(columnSelected)) return false;
		boolean move = gameBoard.updateGameBoard(columnSelected, currentPlayer.getPlayerSymbol());
		if (move == false) return false;
		this.gameWinState = this.checkWinState(currentPlayer.getPlayerSymbol(), columnSelected);
		return this.gameWinState;
	}
	/**
	*
	* Need to design logic flow that meshes with text, gui and network play
	*
	*/

	// recycled from old code in SER216

	/**
	 * Checks if the move is valid.
	 *
	 * @param columnSelected The column selected for the chip to drop
	 * @return Returns if the move is valid or not
	 */
	public boolean checkIfMoveValid (int columnSelected) {
		if (columnSelected >= gameBoard.getColumnLength()) return false;
		if (columnSelected < 0) return false;
		if (gameBoard.getCell(0, columnSelected) != ' ') return false; // checks if column selected is full
		return true;
	}

	/**
	 * Checks to see if the move that was made has created a win state
	 *
	 * @param chip Representation of the player object's move on gameboard
	 * @param column Column that is selected for the prior move
	 * @return returns whether or not there is a win state on the gameboard.
	 */
	public  boolean checkWinState (char chip, int column) {
		int row = gameBoard.getTopFilledRowInColumn(column);
		if (checkHorizontal(chip, row, column) >= 4) gameWinState = true;
		else if (checkVerticle(chip, row, column) >= 4) gameWinState = true;
		else if (checkDiagonalRightToLeft(chip, row, column) >= 4) gameWinState = true;
		else if (checkDiagonalLeftToRight(chip, row, column) >= 4) gameWinState = true;
		else gameWinState = false;
		return gameWinState;
	}

	private int checkHorizontal (char chip, int row, int column) {
		int chipCount = 1;
		for (int col = column+1; (gameBoard.getColumnLength() > col && col >= 0); col++) {
			if (gameBoard.getCell(row, col) == chip) chipCount++;
			else break;
		}
		for (int col = column-1; (gameBoard.getColumnLength() > col && col >= 0); col--) {
			if (gameBoard.getCell(row, col) == chip) chipCount++;
			else break;
		}
		return chipCount;
	}

	private int checkVerticle (char chip, int row, int column) {
		int chipCount = 1;
		for (int r = row+1; (gameBoard.getRowLength() > r && r >= 0); r++) {
				if (gameBoard.getCell(r, column) == chip) chipCount++;
				else break;
		}
		for (int r = row-1; (gameBoard.getRowLength() > r && r >= 0); r++) {
			if (gameBoard.getCell(r, column) == chip) chipCount++;
			else break;
		}
		return chipCount;
	}

	private int checkDiagonalRightToLeft (char chip, int row, int column) {
	    int chipCount = 1;
		int r = row+1;
		for (int c = column+1; (gameBoard.getColumnLength() > c && c >=0); c++, r++) {
			if (r < gameBoard.getRowLength() && r >= 0)
				if (gameBoard.getCell(r, c) == chip) chipCount++;
			else break;
		}

		r = row-1;
		for (int c = column-1; (gameBoard.getColumnLength() > c && c >= 0); c--, r--) {
			if (r < gameBoard.getRowLength() && r >= 0)
				if (gameBoard.getCell(r, c) == chip) chipCount++;
			else break;
		}
		return chipCount;
	}

	private int checkDiagonalLeftToRight (char chip, int row, int column) {
		int chipCount = 1;
		int r = row-1;
		for (int c = column+1; (gameBoard.getColumnLength() > c && c >= 0); c++, r--) {
			if (r < gameBoard.getRowLength() && r >= 0)
				if (gameBoard.getCell(r, c) == chip) chipCount++;
				else break;
		}
		r = row+1;
		for (int c = column-1; (gameBoard.getColumnLength() > c && c >= 0); c--, r++) {
			if (r < gameBoard.getRowLength() && r >= 0)
				if (gameBoard.getCell(r, c) == chip) chipCount++;
				else break;
		}
		return chipCount;
	}

	public boolean checkIfFull () {
		if (gameBoard.getEmptyCells() == 0) return true;
		return false;
	}

	public char[][] getBoard () {
		return gameBoard.getGameBoard();
	}

	public boolean getWinState () {
		return gameWinState;
	}

	public GameBoard getGameBoardObject () {
		return gameBoard;
	}

	/**
	* getGameState is a function for serializing the gameboard and win state
	* format is:
	* b_cccccccccc
	* where b represented the boolean state of win status
	* c is a series of character that represent each cell on the gameboard.
	*/
	public String getGameBoardString () {
		return gameBoard.toString();
	}

}
