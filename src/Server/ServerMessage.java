package Server;

public class ServerMessage {

    public static String constructMessage (int playerTurn, boolean winState, String board) {
        String message = "";
        int winBit = -1;
        if (!winState) {
            winBit = 0;
        } else {
            winBit = 1;
        }
        message = Integer.toString(winBit) + Integer.toString(playerTurn) + "_" + board;
        return message;
    }

}
