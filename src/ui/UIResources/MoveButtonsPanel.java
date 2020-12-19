package ui.UIResources;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import ui.GUI;

public class MoveButtonsPanel extends HBox {

    private HBox moveOptionPane;
    private MoveButton moveButtons[];

    public MoveButtonsPanel() {
        moveButtons = new MoveButton[7];
        for (int i = 0; i < 7; i++) {
            moveButtons[i] = new MoveButton();
            moveButtons[i].setValue(i);
            moveButtons[i].setText(Integer.toString((i+1)));
        }
        for (int i = 0; i < 7; i++) this.getChildren().add(moveButtons[i]);
    }

    public MoveButtonsPanel getMoveButtonPane () {
        return this;
    }


}
