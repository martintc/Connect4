package ui.UIResources;

import javafx.scene.layout.HBox;

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
