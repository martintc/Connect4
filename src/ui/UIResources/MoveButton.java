package ui.UIResources;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import ui.GUI;

public class MoveButton extends Button {

    private int value;

    public void setValue (int val) {
        value = val;
    }

    public int getValue () {
        return value;
    }



}
