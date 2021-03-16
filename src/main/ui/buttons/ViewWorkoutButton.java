package ui.buttons;

import model.Workout;
import model.WorkoutSet;
import ui.WorkoutLoggerAppGUI;

import javax.swing.*;
import java.awt.*;

public class ViewWorkoutButton {
    protected JButton button;
    protected WorkoutSet workoutSet;
    protected JComponent parent;
    protected WorkoutLoggerAppGUI workoutLoggerAppGUI;
    protected Workout workout;

    public ViewWorkoutButton(WorkoutLoggerAppGUI workoutLoggerAppGUI, JComponent parent,
                             WorkoutSet workoutSet, Workout workout) {
        this.workoutSet = workoutSet;
        this.workoutLoggerAppGUI = workoutLoggerAppGUI;
        this.workout = workout;
        this.parent = parent;
        createButton(parent);
        addListener();
        addToParent();

    }

    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }


    protected String getLabel() {
        return workout.getName() + ": " + workout.getDate().formatToString();
    }

    protected void addListener() {
        System.out.println("Finish this up!");
    }

    // MODIFIES: parent
    // EFFECTS:  adds the given button to the parent component
    public void addToParent() {
        parent.add(button);
    }

    // MODIFIES: this
    // EFFECTS: customizes the button
    protected JButton customizeButton(JButton button) {
        button.setBorderPainted(true);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
        button.setPreferredSize(new Dimension(600, 100));
        return button;
    }


}
