package ui.buttons;

import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

// abstract class representing a button
// buttons developed using https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git
// as template

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

    // EFFECTS: produces true if the string contains at least one non-whitespace character, false otherwise
    protected boolean isNameValid(String command) {
        return Pattern.matches("(.*[A-Za-z0-9]+.*)+", command);
    }

    // EFFECTS: produces true if string does not contain only integers, false otherwise
    protected boolean isOnlyIntegers(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    // MODIFIES: this
    // EFFECTS: produces error sound and error popup displaying message
    protected void errorPopup(String message) {
        playErrorSound();
        JOptionPane.showMessageDialog(parent, message);
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
