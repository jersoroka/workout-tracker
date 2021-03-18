package ui.buttons;

import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;
import java.awt.*;

public abstract class BasicButton {
    protected GUI gui;
    protected JComponent parent;
    protected WorkoutSet workoutSet;
    protected JButton button;

    public BasicButton(GUI gui, JComponent parent) {
        this.gui = gui;
        this.parent = parent;
        this.workoutSet = gui.getWorkoutSet();
    }

    // MODIFIES: this
    // EFFECTS: customizes the button
    protected JButton customizeButton(JButton button) {
        button.setBorderPainted(true);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
        button.setFont(new Font("Dialog", Font.PLAIN, 18));
        return button;
    }

    // EFFECTS: creates button with appropriate label
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    // EFFECTS: Returns the string for the label
    protected abstract String getLabel();

    // MODIFIES: this
    // EFFECTS: adds a listener for this button
    protected abstract void addListener();

    // MODIFIES: parent
    // EFFECTS:  adds the given button to the parent component
    public void addToParent() {
        parent.add(button);
    }

    public GUI getGui() {
        return gui;
    }

    public JComponent getParent() {
        return parent;
    }

    public WorkoutSet getWorkoutSet() {
        return workoutSet;
    }

    public JButton getButton() {
        return button;
    }
}
