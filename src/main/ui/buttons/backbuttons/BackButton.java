package ui.buttons.backbuttons;

import model.WorkoutSet;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;


public abstract class BackButton extends Button {

    public BackButton(GUI gui, JComponent parent, WorkoutSet workoutSet) {
        super(gui, parent, workoutSet);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    @Override
    protected String getLabel() {
        return "Back";
    }

}
