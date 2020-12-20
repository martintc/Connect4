package ui.PlayStyle;

import core.Connect4;
import ui.Networking.*;

public class NetworkPlay extends PlayStyle {

    private NetworkHandler network;
    private boolean turn;
    private boolean winState;
    private String boardState;
    private MessageParser parser = new MessageParser();

    public NetworkPlay () {
        network = new NetworkHandler();
        turn = false;
        winState = false;
    }

    public NetworkPlay (String hostname, int port) {

    }

    public void makeMove (int move) {
        network.writeToServer(Integer.toString(move));
    }

    public void receiveUpdate () {
        String message = network.receiveMessage();
        parser.parseMessage(message);
        turn = parser.getPlayerTurn();
        winState = parser.getWinState();
        boardState = parser.getBoardString();

    }

    public boolean getTurn () {
        return turn;
    }

    public boolean getWinState () {
        return winState;
    }

    public String getBoardState () {
        return boardState;
    }

}
