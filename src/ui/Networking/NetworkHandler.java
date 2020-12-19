package ui.Networking;

import java.net.Socket;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NetworkHandler {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public NetworkHandler () {
        try {
            socket = new Socket("localhost", 8000);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.err.println("Error establishing connection to server....");
            System.exit(0);
        }
    }

    public NetworkHandler (int port, int hostname) {
        try {
            socket = new Socket(String.valueOf(port), hostname); // need to test for later
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.err.println("Error establishing connection to server....");
            System.exit(0);
        }
    }

    public boolean writeToServer (String message) {
        try {
            out.writeUTF(message);
            return true;
        } catch (IOException e) {
            System.err.print("Error writting to server");
            return false;
        }
    }

    public String receiveMessage () {
        try {
            return in.readUTF();
        } catch (IOException e) {
            System.out.println("Error receiving from server");
            System.exit(0);
        }
        return null;
    }

}
