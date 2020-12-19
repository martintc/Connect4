package ui.UIResources;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Connect4Slot extends Circle {

    private double radius;

    public Connect4Slot (double radius, String color) {
        this.setRadius(radius);
        if (color.equals("GREY"))
            this.setFill(Color.LIGHTGREY);
        else if (color.equals("BLUE"))
            this.setFill(Color.BLUE);
        else if (color.equals("RED"))
            this.setFill(Color.RED);
    }

    public Connect4Slot () {
        radius = 10;
        this.setRadius(radius);
        this.setFill(Color.LIGHTGRAY);
    }

    public Connect4Slot (double rad) {
        this.setRadius(rad);
        this.setFill(Color.LIGHTGRAY);
    }

    public void change_Color (char piece) {
        if (piece == 'x') {
            this.setFill(Color.BLUE);
        } else if (piece == 'o') {
            this.setFill(Color.RED);
        } else {
            this.setFill(Color.LIGHTGRAY)
;        }
    }

}
