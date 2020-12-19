import ui.TextConsole;
import ui.LocalGUI;

import javafx.application.Application;

/**
 * Test codes
 */

public class Driver {

	public static void main (String[] args) {
		int choice = 1;

		if (choice == 0) {
			TextConsole t = new TextConsole();
			t.run();
		}

		if (choice == 1) {
			Application.launch(LocalGUI.class, args);
		}


	}

}