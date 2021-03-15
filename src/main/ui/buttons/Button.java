package ui.buttons;

import model.WorkoutSet;
import ui.WorkoutLoggerAppGUI;

import javax.swing.*;

public abstract class Button {
    protected JButton button;
    protected WorkoutSet workoutSet;
    protected JComponent parent;
    protected WorkoutLoggerAppGUI workoutLoggerAppGUI;

    public Button(WorkoutLoggerAppGUI workoutLoggerAppGUI, JComponent parent, WorkoutSet workoutSet) {
        this.workoutSet = workoutSet;
        this.workoutLoggerAppGUI = workoutLoggerAppGUI;
        createButton(parent);
        this.parent = parent;
        addListener();
        addToParent();
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
