package ui;

// imports
import ui.UIResources.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GUI extends Application {

	private Stage mainStage;
	private BorderPane root;
	private GameBoardGUI gui;
	private GridPane gameBoard;
	private VBox centerPane;
	private MoveButtons moveButtons;

	private int width;
	private int height;


	@Override
	// where the GUI application thread starts
	// start the setup
	public void start (Stage primaryStage) {
		gui = new GameBoardGUI();
		gameBoard = gui.getGameBoardUI();
		renderScreen(primaryStage);
		width = 600;
		height = 800;
	}

	// will render the  screen when called
	public void renderScreen (Stage primaryStage) {
		primaryStage.setTitle("Connect4");
		root = new BorderPane();

		gameBoard = gui.getGameBoardUI();

		Text title = new Text("Connect4 Client");
		title.setTextAlignment(TextAlignment.CENTER);


		BorderPane.setAlignment(title, Pos.CENTER);
		root.setTop(title);

		centerPane = new VBox();

		moveButtons = new MoveButtons();

		centerPane.getChildren().add(moveButtons.getMoveButtonPane());
		centerPane.getChildren().add(gameBoard);

		BorderPane.setAlignment(centerPane, Pos.CENTER);
		root.setCenter(centerPane);

		primaryStage.setScene(new Scene(root,  width, height));
		primaryStage.show();
	}

	// 


}