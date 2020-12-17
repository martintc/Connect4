import ui.TextConsole;
import ui.GUI;

import javafx.application.Application;

public class Driver {

	public static void main (String[] args) {
		int choice = 1;

		if (choice == 0) {
			TextConsole t = new TextConsole();
			t.run();
		}

		if (choice == 1) {
			Application.launch(GUI.class, args);
		}


	}

}