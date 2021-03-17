package ui.buttons.viewobjectbuttons;

import model.WorkoutSet;
import ui.GUI;
import ui.buttons.BasicButton;

import javax.swing.*;

public abstract class ViewObjectButton extends BasicButton {
    protected Object object;


    public ViewObjectButton(GUI gui, JComponent parent, WorkoutSet workoutSet, Object object) {
        super(gui, parent, workoutSet);
        this.object = object;
        createButton(parent);
        addListener();
        addToParent();
    }
}
