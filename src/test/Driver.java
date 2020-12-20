package test;

import ui.TextConsole;
import ui.LocalGUI;
import Server.*;

import javafx.application.Application;

/**
 * Test codes
 */

public class Driver {

	public static void main (String[] args) {
		int choice = 2;

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


	}

}