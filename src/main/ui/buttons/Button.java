package ui.buttons;

import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;
import java.awt.*;

public abstract class Button {
    protected JButton button;
    protected WorkoutSet workoutSet;
    protected JComponent parent;
    protected GUI gui;

    public Button(GUI gui, JComponent parent) {
        this.gui = gui;
        this.parent = parent;
        this.workoutSet = gui.getWorkoutSet();
        createButton(parent);
        addListener();
        addToParent();
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
    protected abstract void createButton(JComponent parent);

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

    public JButton getButton() {
        return button;
    }

    public WorkoutSet getWorkoutSet() {
        return workoutSet;
    }

    public JComponent getParent() {
        return parent;
    }

    public GUI getGui() {
        return gui;
    }
}
