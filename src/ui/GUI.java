package ui;

// imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class GUI extends Application {

	private Stage mainStage;
	private BorderPane root;
	private int width;
	private int height;

	@Override
	// where the GUI application thread starts
	// start the setup
	public void start (Stage primaryStage) {	
		renderScreen(primaryStage);
		width = 600;
		height = 800;
	}

	// will render the  screen when called
	public void renderScreen (Stage primaryStage) {
		primaryStage.setTitle("Connect4");

		Text title = new Text("Connect4 Client");
		title.setTextAlignment(TextAlignment.CENTER);

		root = new BorderPane();

		BorderPane.setAlignment(title, Pos.CENTER);
		root.setTop(title);

		primaryStage.setScene(new Scene(root,  width, height));
		primaryStage.show();
	}

	// 


}