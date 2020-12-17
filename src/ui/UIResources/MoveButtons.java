package ui.UIResources;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class MoveButtons extends HBox {

    private HBox moveOptionPane;
    private Button moveButtons[];

    public MoveButtons () {
        moveButtons = new Button [7];
        for (int i = 0; i < 7; i++) {
            moveButtons[i] = new Button();
            moveButtons[i].setText(Integer.toString((i+1)));
        }
        for (int i = 0; i < 7; i++) this.getChildren().add(moveButtons[i]);
    }

    public MoveButtons getMoveButtonPane () {
        return this;
    }


}
