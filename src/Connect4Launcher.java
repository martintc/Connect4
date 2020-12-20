import Server.Connect4Server;
import ui.LocalGUI;
import ui.TextConsole;
import ui.NetworkUI;
import javafx.application.Application;

public class Connect4Launcher {
    public static void main (String[] args) {
        int choice = Integer.parseInt(args[0]);
        if (choice == 0) {
            TextConsole t = new TextConsole();
            t.run();
        }

        if (choice == 1) {
            Application.launch(LocalGUI.class, args);
        }

        if (choice == 2) {
            Connect4Server server = new Connect4Server();
            server.start();
        }

        if (choice == 3) {
            Application.launch(NetworkUI.class, args);
        }
    }
}
