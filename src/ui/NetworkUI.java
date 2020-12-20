package ui;

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

public class NetworkUI extends Application {

    private int width;
    private int height;
    private Stage mainStage;
    private MoveButton buttons[];
    private Connect4Slot slots[][];
    private int rows;
    private int columns;
    private Text turnNotice;
    private NetworkPlay play;

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
        play = new NetworkPlay();
        play.receiveUpdate(); // initial update from server to notify player turns and initial gameboard

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
                if (play.getTurn()) {
                    play.makeMove(0);
                    play.receiveUpdate();
                    updatePlayer(play.getTurn());
                    updateGameBoard(play.getBoardState());
                }
            }
        });
        buttons[1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (play.getTurn()) {
                    play.makeMove(1);
                    play.receiveUpdate();
                    updatePlayer(play.getTurn());
                    updateGameBoard(play.getBoardState());
                    play.receiveUpdate();
                    updatePlayer(play.getTurn());
                    updateGameBoard(play.getBoardState());
                }
            }
        });
        buttons[2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (play.getTurn()) {
                    play.makeMove(2);
                    play.receiveUpdate();
                    updatePlayer(play.getTurn());
                    updateGameBoard(play.getBoardState());
                    play.receiveUpdate();
                    updatePlayer(play.getTurn());
                    updateGameBoard(play.getBoardState());
                }
            }
        });
        buttons[3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (play.getTurn()) {
                    play.makeMove(3);
                    play.receiveUpdate();
                    updatePlayer(play.getTurn());
                    updateGameBoard(play.getBoardState());
                    play.receiveUpdate();
                    updatePlayer(play.getTurn());
                    updateGameBoard(play.getBoardState());
                }
            }
        });
        buttons[4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (play.getTurn()) {
                    play.makeMove(4);
                    play.receiveUpdate();
                    updatePlayer(play.getTurn());
                    updateGameBoard(play.getBoardState());
                    play.receiveUpdate();
                    updatePlayer(play.getTurn());
                    updateGameBoard(play.getBoardState());
                }
            }
        });
        buttons[5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (play.getTurn()) {
                    play.makeMove(5);
                    play.receiveUpdate();
                    updatePlayer(play.getTurn());
                    updateGameBoard(play.getBoardState());
                    play.receiveUpdate();
                    updatePlayer(play.getTurn());
                    updateGameBoard(play.getBoardState());
                }
            }
        });
        buttons[6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (play.getTurn()) {
                    play.makeMove(6);
                    play.receiveUpdate();
                    updatePlayer(play.getTurn());
                    updateGameBoard(play.getBoardState());
                    play.receiveUpdate();
                    updatePlayer(play.getTurn());
                    updateGameBoard(play.getBoardState());
                }
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
        updatePlayer(play.getTurn());
        root.setBottom(bottomPane);


        mainStage.setScene(new Scene(root, width, height));
        mainStage.show();
        if (!play.getTurn()) {
            play.receiveUpdate();
            updatePlayer(play.getTurn());
            updateGameBoard(play.getBoardState());
        }

    }

    private void showWin(char currentPlayerSymbol) {
        if (currentPlayerSymbol == 'o') {
            turnNotice.setText("BLUE WON");
        } else if (currentPlayerSymbol == 'x') {
            turnNotice.setText("RED WON");
        }
    }

    private void updatePlayer(boolean turn) {
        if (turn == true) {
            turnNotice.setText("YOUR TURN");
        } else {
            turnNotice.setText("OPPONENT'S TURN");
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
