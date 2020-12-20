package ui.Networking;

public class MessageParser {

    private boolean winBit;
    private boolean playerTurn;
    private String boardString;
    private String regex = "_";

    public void parseMessage (String message) {
        String[] parts = message.split(regex);
        boardString = parts[1];
        int i = Character.getNumericValue(parts[0].charAt(0));
        if (i == 0) {
            winBit = false;
        } else {
            winBit = true;
        }
        i = Character.getNumericValue(parts[0].charAt(1));
        if (i == 0) {
            playerTurn = false;
        } else  {
            playerTurn = true;
        }

    }

    public String getBoardString () {
        return boardString;
    }

    public boolean getPlayerTurn () {
        return playerTurn;
    }

    public boolean getWinState () {
        return winBit;
    }

}
