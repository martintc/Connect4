package ui;

// imports
import ui.UIResources.*;
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
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class GUI extends Application {

	private Stage mainStage;
	private BorderPane root;
	private GameBoardGUI gui;
	private GridPane gameBoard;
	private int width;
	private int height;


	@Override
	// where the GUI application thread starts
	// start the setup
	public void start (Stage primaryStage) {
		gui = new GameBoardGUI();
		renderScreen(primaryStage);
		width = 600;
		height = 800;
	}

	// will render the  screen when called
	public void renderScreen (Stage primaryStage) {
		primaryStage.setTitle("Connect4");

		gameBoard = gui.getGameBoardUI();

		Text title = new Text("Connect4 Client");
		title.setTextAlignment(TextAlignment.CENTER);

		root = new BorderPane();

		BorderPane.setAlignment(title, Pos.CENTER);
		root.setTop(title);

		BorderPane.setAlignment(gameBoard, Pos.CENTER);
		root.setCenter(gameBoard);

		primaryStage.setScene(new Scene(root,  width, height));
		primaryStage.show();
	}

	// 


}