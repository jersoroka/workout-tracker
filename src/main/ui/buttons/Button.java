package ui.buttons;

import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;
import java.awt.*;

// abstract class representing a button

public abstract class Button {
    protected JButton button;
    protected WorkoutSet workoutSet;
    protected JComponent parent;
    protected GUI gui;
    protected Object object;

    // MODIFIES: this
    // EFFECTS: creates button
    public Button(GUI gui, JComponent parent) {
        this.gui = gui;
        this.parent = parent;
        this.workoutSet = gui.getWorkoutSet();
        createButton(parent);
        addListener();
        addToParent();
    }

    // MODIFIES: this
    // EFFECTS: creates button and accepts an extra object argument
    public Button(GUI gui, JComponent parent, Object object) {
        this.gui = gui;
        this.parent = parent;
        this.workoutSet = gui.getWorkoutSet();
        this.object = object;
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

    // EFFECTS: plays an error sound
    protected void playErrorSound() {
        Runnable sound = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
        sound.run();
    }

    // getters

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
