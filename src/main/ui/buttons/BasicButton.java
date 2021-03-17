package ui.buttons;

import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;

public abstract class BasicButton {
    protected GUI gui;
    protected JComponent parent;
    protected WorkoutSet workoutSet;
    protected JButton button;

    public BasicButton(GUI gui, JComponent parent, WorkoutSet workoutSet) {
        this.gui = gui;
        this.parent = parent;
        this.workoutSet = workoutSet;
    }

    // MODIFIES: this
    // EFFECTS: customizes the button
    protected JButton customizeButton(JButton button) {
        button.setBorderPainted(true);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
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
}
