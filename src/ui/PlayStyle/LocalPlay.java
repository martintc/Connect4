package ui.PlayStyle;

import core.*;

public class LocalPlay implements PlayStyle {

    private final Connect4 game;
    private char currentPlayer;
    private boolean moveValid;
    private boolean winState;

    public LocalPlay () {
        game = new Connect4(true);
        currentPlayer = game.getPlayerTurn();
        winState = false;
        moveValid = false;
    }

    public char getCurrentPlayerSymbol () {
        return currentPlayer;
    }

    public boolean play (int move) {
        moveValid = game.playerMakesMove(move);
        if (moveValid) currentPlayer = game.getPlayerTurn();
        winState = game.getWinState();
        return moveValid;
    }

    public boolean getWinState () {
        return winState;
    }

    public String getCurrentBoardString () {
        return game.getGameBoardString();
    }


}
