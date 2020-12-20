package Server;

import core.Connect4;

public class ServerThread extends Thread {

    private Client clientOne;
    private Client clientTwo;
    private Connect4 game;
    private boolean winState;

    public ServerThread (Client c1, Client c2) {
        clientOne = c1;
        clientTwo = c2;
        game = new Connect4(true);
        winState = false;
    }

    public void setClientOne (Client c) {
        clientOne = c;
    }

    public void setClientTwo (Client c) {
        clientTwo = c;
    }

    public void start () {
        clientOne.setPlayerSymbol('x');
        clientTwo.setPlayerSymbol('o');
        gameLoop();
    }

    public void gameLoop () {
        while (!game.getWinState()) {
            char playerTurn = game.getPlayerTurn();
            int move = -1;
            updatePlayers(playerTurn);
            while (!game.playerMakesMove(move)) {
                move = getMove(playerTurn);
            }
            System.out.println(move);
        }
        System.out.println("Game is over on this thread");

    }

    private void updatePlayers (char c) {
        if (clientOne.getPlayerSymbol() == c) {
            clientOne.writeToClient(ServerMessage.constructMessage(1, game.getWinState(), game.getGameBoardString()));
            clientTwo.writeToClient(ServerMessage.constructMessage(0, game.getWinState(), game.getGameBoardString()));
        } else if (clientTwo.getPlayerSymbol() == c) {
            clientOne.writeToClient(ServerMessage.constructMessage(0, game.getWinState(), game.getGameBoardString()));
            clientTwo.writeToClient(ServerMessage.constructMessage(1, game.getWinState(), game.getGameBoardString()));
        }
    }

    private int getMove (char c) {
        if (clientOne.getPlayerSymbol() == c) {
            return clientOne.receiveMove();
        } else if (clientTwo.getPlayerSymbol() == c) {
            return clientTwo.receiveMove();
        }
        return -1;
    }

}
