package ui.buttons.additionalobjectbutton;

import model.WorkoutSet;
import ui.GUI;
import ui.buttons.BasicButton;

import javax.swing.*;

public abstract class AdditionalObjectButton extends BasicButton {
    protected Object object;


    public AdditionalObjectButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent);
        this.object = object;
        createButton(parent);
        addListener();
        addToParent();
    }
}
