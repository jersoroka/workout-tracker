package ui.screens;

import model.Workout;
import ui.GUI;

import javax.swing.*;
import java.awt.*;

public class ViewWorkout extends JFrame {
    JPanel pane;
    GUI gui;
    Workout workout;

    public ViewWorkout(GUI gui, Workout workout) {
        pane = new JPanel();
        this.gui = gui;
        this.workout = workout;
        initializePane();
        createWorkoutSummary();
        createExerciseButtons();
        createDeleteButton();
        createBackButton();
    }

    // MODIFIES: this, gui
    // EFFECTS: creates the window where the user can view a specific workout
    public void initializePane() {
        pane.setLayout(new GridLayout(3, 0, gui.getHorizontalGap(), gui.getVerticalGap()));
        pane.setSize(gui.getScreenWidth(), gui.getScreenHeight());
        gui.getContainer().add(this.getPane(), "view workout");
    }

    // MODIFIES: this
    // EFFECTS: creates text box displaying a summary of the workout
    public void createWorkoutSummary() {

    }

    // MODIFIES: this
    // EFFECTS: adds buttons which each display an exercise done in a workout
    public void createExerciseButtons() {

    }

    // MODIFIES: this
    // EFFECTS: adds a button that allows the user to delete the workout
    public void createDeleteButton() {

    }

    // MODIFIES: this
    // EFFECTS: adds a back button to the screen
    public void createBackButton() {

    }

    public JPanel getPane() {
        return pane;
    }
}
