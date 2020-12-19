package Server;

import core.Connect4.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Connect4Server {

    private ServerSocket server;
    private int port; // designate port to be 8000
    private ArrayList<ServerThread> games;

    public void start () {
        port = 8000;
        games = new ArrayList<>();
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int clientNum = 0;

        System.out.println("Server started and accepting clients.....");

        while(true) {
            try {
                Client c = new Client(server.accept());
                System.out.println("Client one connected for new game");
                Client t = new Client(server.accept());
                System.out.println("Client two connected for new game");
                ServerThread s = new ServerThread(c, t);
                games.add(s);
                System.out.println("STarting new game session with players");
                s.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
