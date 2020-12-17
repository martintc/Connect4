package core;

/**
 * This is a datastructure that control the flow of which player is next. Since there are only two players, a circular linked list is used since it will facilitate
 * the turns from one player to the next and back.
 *
 * @author Todd Martin
 * @version 1.0
 */

public class PlayerCircularLinkedList {

	class Node {
		Connect4Player player;
		Node nextPlayer;
	}

	private Node currentPlayer;

	/**
	 * Initializes the circular linked list data structure with two players.
	 *
	 * @param playerOne A player object
	 * @param playerTwo A player object
	 */
	public PlayerCircularLinkedList (Connect4Player playerOne, Connect4Player playerTwo) {
		int randomNumber = (int) Math.random()*2;
		currentPlayer = new Node();
		if (randomNumber == 1) {
			currentPlayer.player = playerOne;
			Node nextPlayer = new Node();
			nextPlayer.player = playerTwo;
			currentPlayer.nextPlayer = nextPlayer;
			nextPlayer.nextPlayer = currentPlayer;
		} else {
			currentPlayer.player = playerTwo;
			Node nextPlayer = new Node();
			nextPlayer.player = playerOne;
			currentPlayer.nextPlayer = nextPlayer;
			nextPlayer.nextPlayer = currentPlayer;
		}
	}

	/**
	 * Retreives the current player from the circular data structure and sets the up so the next time it is polled, it will return the other player.
	 *
	 * @return returns the current player whose turn it is
	 */
	public Connect4Player getPlayer () {
		Connect4Player tempPlayer = currentPlayer.player;
		currentPlayer = currentPlayer.nextPlayer;
		return tempPlayer;
	}

	/**
	 * Peeks at the current player and returns the type of player it is.
	 *
	 * @return Returns 1 for a HumanPlayer, returns 0 for a ComputerPlayer and returns a -1 for anything else
	 */
	public int getPlayerType () {
		if (currentPlayer.player instanceof Connect4HumanPlayer) return 1;
		else if (currentPlayer.player instanceof Connect4ComputerPlayer) return 0;
		else return -1;
	}	
	
}
