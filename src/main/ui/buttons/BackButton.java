package ui.buttons;

import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
