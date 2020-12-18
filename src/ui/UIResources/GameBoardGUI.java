package ui.UIResources;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class GameBoardGUI {

    private GridPane gameboard;
    private int columns = 7;
    private int rows = 6;
    private double radius;
    private Color empty = Color.LIGHTGREY;

    public GameBoardGUI () {
        gameboard = new GridPane();
        radius = 10;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                gameboard.add(new Connect4Slot(radius, "GREY:"), c, r);
            }
        }
    }

    public GameBoardGUI (double setRadius) {
        this.radius = setRadius;
        gameboard = new GridPane();
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
                gameboard.add(new Connect4Slot(radius, "GREY"), c, r);
    }

    public GridPane getGameBoardUI () {
        return gameboard;
    }

}
