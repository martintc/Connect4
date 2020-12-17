package ui.UIResources;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class GameBoardGUI {

    private GridPane gameboard;
    int columns = 7;
    int rows = 6;
    double radius;

    public GameBoardGUI () {
        gameboard = new GridPane();
        radius = 10;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                gameboard.add(new Circle(radius), c, r);
            }
        }
    }

    public GameBoardGUI (double setRadius) {
        this.radius = setRadius;
        gameboard = new GridPane();
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
                gameboard.add(new Circle(radius), c, r);
    }

    public GridPane getGameBoardUI () {
        return gameboard;
    }

}
