package ui;
import core.*;
import java.util.Scanner;

public class TextConsole {

    private Scanner read;
    private boolean winStatus;
    private char playerTurn;
    private Connect4 game;
    
    public TextConsole () {
		this.read = new Scanner(System.in);
		winStatus = false;
		playerTurn = ' ';
		this.game = new Connect4(true);
    }
    
    public void run () {
		this.banner();
		do {
			printGameBoard();
			playerTurn = game.getPlayerTurn();
	    	gameLoop();
		} while (winStatus == false);
		System.out.println("Game over!");
		printGameBoard();
    }

    public static void banner () {
		System.out.println("Welcome to Connect 4 game!");
    }

    public void gameLoop () {
		System.out.print("Player " + playerTurn + "please select a valid move: ");
		int move = read.nextInt();
		if (game.checkIfMoveValid(move))
		   winStatus = game.playerMakesMove(move);
		else {
	    	System.out.println("Move not valid!!");
	    	printGameBoard();
	    	gameLoop();
		}
    }

    // Need to build a proper print gameboard statement
    public void printGameBoard () {
    	String s = "|";
    	String board = game.getGameBoardString();
    	for (int i = 0; i < board.length(); i++) {
    		if ((i%7) == 0 && i != 0) {
    			s = s + "\n|"; 
    		}
    		s = s + board.charAt(i) + "|";
    	}
    	System.out.println(s);
    }

}

/**
1 1 1 1 1 1 1 1111111_1111111_1111111_1111111_1111111_1111111
1 1 1 1 1 1 1 0123456 0123456 0123456 0123456 0123456 0123456
1 1 1 1 1 1 1 0123456 7890123 4567890 1234567 8901234 0123456
1 1 1 1 1 1 1 
1 1 1 1 1 1 1
1 1 1 1 1 1 1 
**/ 
