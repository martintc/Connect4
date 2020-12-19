package Server;

import java.net.Socket;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.InputMismatchException;

public class Client {

    private Socket socket;
    private char playerSymbol;
    private OutputStream out;
    private DataOutputStream dataOut;
    private InputStream in;
    private DataInputStream dataIn;

    public Client () {

    }

    public Client (Socket sock) {
        this.socket = sock;
        try {
            out = socket.getOutputStream();
            dataOut = new DataOutputStream(out);
            in = socket.getInputStream();
            dataIn = new DataInputStream(in);
        } catch (IOException e) {
            System.err.print("Client had a problem connecting");
        }
    }

    public void setSocket (Socket sock) {
        this.socket = sock;
    }

    public Socket getSocket () {
        return this.socket;
    }

    public void setPlayerSymbol (char symbol) {
        this.playerSymbol = symbol;
    }

    public char getPlayerSymbol () {
        return this.playerSymbol;
    }

    public boolean writeToClient (String message) {
        try {
            dataOut.writeUTF(message);
            return true;
        } catch (IOException e) {
            System.err.print("Problem writing to client");
            return false;
        }
    }

    public int receiveMove () {
        try {
            return Integer.parseInt(dataIn.readUTF());
        } catch (InputMismatchException e) {
            System.err.print("Wrong data sent from client");
            return -1;
        }catch (IOException e) {
            System.err.print("Error receiving data");
            return -1;
        }
    }

}
