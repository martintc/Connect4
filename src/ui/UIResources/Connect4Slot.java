package ui.UIResources;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Connect4Slot extends Circle {

    private double radius;

    public Connect4Slot (double radius, String color) {
        this.setRadius(radius);
        if (color.equals("GREY"))
            this.setFill(Color.WHITESMOKE);
        else if (color.equals("BLUE"))
            this.setFill(Color.BLUE);
        else if (color.equals("RED"))
            this.setFill(Color.RED);
    }

}
