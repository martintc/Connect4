package Server;

import core.Connect4;

public class ServerThread extends Thread {

    private Client clientOne;
    private Client clientTwo;
    private Connect4 game;

    public ServerThread (Client c1, Client c2) {
        clientOne = c1;
        clientTwo = c2;
        game = new Connect4(true);
    }



}
