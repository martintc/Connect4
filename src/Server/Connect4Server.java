package Server;

import core.Connect4.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Connect4Server {

    private ServerSocket server;
    private int port; // designate port to be 8000
    private ArrayList<Socket> clients;

    public void start () {
        port = 8000;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int clientNum = 0;

        while(true) {

        }

    }

}
