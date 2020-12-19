package ui.UIResources;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class GameBoardGUI extends GridPane {

    private GridPane gameboard;
    private int columns = 7;
    private int rows = 6;
    private double radius;
    private Connect4Slot slots[][];

    public GameBoardGUI () {
        radius = 10;
        slots = new Connect4Slot [rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                slots[r][c] = new Connect4Slot(radius, "GREY");
                this.add(slots[r][c], c, r);
            }
        }
    }

    public GameBoardGUI (double setRadius) {
        this.radius = setRadius;
        slots = new Connect4Slot[rows][columns];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++) {
                slots[r][c] = new Connect4Slot(radius, "GREY");
                this.add(slots[r][c], c, r);
            }
    }

    public GameBoardGUI getGameBoardUI () {
        return this;
    }

    public void refresh (String currentGB) {
        int i = 0;
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++) {
                char temp = currentGB.charAt(i);
                if (temp == 'x') {
                    slots[r][c].setFill(Color.BLUE);
                } else if (temp == 'o') {
                    slots[r][c].setFill(Color.RED);
                } else {
                    slots[r][c].setFill(Color.LIGHTGRAY);
                }
            }
    }

}
