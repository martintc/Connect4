package ui;

// imports
import com.sun.media.jfxmedia.events.NewFrameEvent;
import com.sun.webkit.dom.HTMLBaseFontElementImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import ui.UIResources.*;
import ui.PlayStyle.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class LocalGUI extends Application {

	private int width;
	private int height;
	private Stage mainStage;
	private MoveButton buttons[];
	private Connect4Slot slots[][];
	private int rows;
	private int columns;
	private Text turnNotice;
	private static LocalPlay play;

	@Override
	// where the GUI application thread starts
	// start the setup
	public void start (Stage primaryStage) {
		width = 300;
		height = 300;
		rows = 6;
		columns = 7;
		mainStage = primaryStage;
		BorderPane root = new BorderPane();
		slots = new Connect4Slot[rows][columns];
		buttons = new MoveButton[columns];
		play = new LocalPlay();

		Text title = new Text("Connect4 - Local Play");
		HBox titlePane = new HBox();
		titlePane.setAlignment(Pos.CENTER);
		titlePane.getChildren().add(title);
		root.setTop(titlePane);

		VBox centerPane = new VBox();

		HBox moveButtonPanel = new HBox();
		for (int i = 0; i < columns; i++) {
			buttons[i] = new MoveButton();
			buttons[i].setText(Integer.toString(i+1));
			buttons[i].setValue(i+1);
			moveButtonPanel.getChildren().add(buttons[i]);
		}

		buttons[0].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				boolean moveMade = play.play(0);
				updateGameBoard(play.getCurrentBoardString());
				if (!play.getWinState())
					updatePlayer(play.getCurrentPlayerSymbol());
				else
					showWin(play.getCurrentPlayerSymbol());
			}
		});
		buttons[1].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				boolean moveMade = play.play(1);
				updateGameBoard(play.getCurrentBoardString());
				if (!play.getWinState())
					updatePlayer(play.getCurrentPlayerSymbol());
				else
					showWin(play.getCurrentPlayerSymbol());
			}
		});
		buttons[2].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				boolean moveMade = play.play(2);
				updateGameBoard(play.getCurrentBoardString());
				if (!play.getWinState())
					updatePlayer(play.getCurrentPlayerSymbol());
				else
					showWin(play.getCurrentPlayerSymbol());
			}
		});
		buttons[3].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				boolean moveMade = play.play(3);
				updateGameBoard(play.getCurrentBoardString());
				if (!play.getWinState())
					updatePlayer(play.getCurrentPlayerSymbol());
				else
					showWin(play.getCurrentPlayerSymbol());
			}
		});
		buttons[4].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				boolean moveMade = play.play(4);
				updateGameBoard(play.getCurrentBoardString());
				if (!play.getWinState())
					updatePlayer(play.getCurrentPlayerSymbol());
				else
					showWin(play.getCurrentPlayerSymbol());
			}
		});
		buttons[5].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				boolean moveMade = play.play(5);
				updateGameBoard(play.getCurrentBoardString());
				if (!play.getWinState())
					updatePlayer(play.getCurrentPlayerSymbol());
				else
					showWin(play.getCurrentPlayerSymbol());
			}
		});
		buttons[6].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				boolean moveMade = play.play(6);
				updateGameBoard(play.getCurrentBoardString());
				if (!play.getWinState())
					updatePlayer(play.getCurrentPlayerSymbol());
				else
					showWin(play.getCurrentPlayerSymbol());
			}
		});

		centerPane.getChildren().add(moveButtonPanel);

		GridPane gb = new GridPane();
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < columns; c++) {
				slots[r][c] = new Connect4Slot(13);
				gb.add(slots[r][c], c, r);
			}
		centerPane.getChildren().add(gb);
		centerPane.setAlignment(Pos.CENTER);
		centerPane.setPadding(new Insets(0, 50, 0, 50));

		root.setCenter(centerPane);

		HBox bottomPane = new HBox();
		turnNotice = new Text();
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.getChildren().add(turnNotice);
		updatePlayer(play.getCurrentPlayerSymbol());
		root.setBottom(bottomPane);



		mainStage.setScene(new Scene(root, width, height));
		mainStage.show();

	}

	private void showWin(char currentPlayerSymbol) {
		if (currentPlayerSymbol == 'o') {
			turnNotice.setText("BLUE WON");
		} else if (currentPlayerSymbol == 'x') {
			turnNotice.setText("RED WON");
		}
	}

	private void updatePlayer(char currentPlayerSymbol) {
		if (currentPlayerSymbol == 'x') {
			turnNotice.setText("BLUE");
		} else if (currentPlayerSymbol == 'o') {
			turnNotice.setText("RED");
		}
	}

	private void updateGameBoard(String currentBoardString) {

		int i = 0;
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < columns; c++) {
				slots[r][c].change_Color(currentBoardString.charAt(i));
				i++;
			}

	}

}