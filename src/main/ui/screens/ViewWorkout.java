package ui.screens;

import model.Exercise;
import model.Workout;
import ui.GUI;
import ui.buttons.DeleteWorkoutButton;
import ui.buttons.additionalobjectbutton.EditExerciseButton;
import ui.buttons.backbuttons.ViewWorkoutBackButton;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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
        pane.setLayout(new GridLayout(4, 0, gui.getHorizontalGap(), gui.getVerticalGap()));
        pane.setSize(gui.getScreenWidth(), gui.getScreenHeight());
        gui.getContainer().add(this.getPane(), "view workout");
    }

    // MODIFIES: this
    // EFFECTS: creates an uneditable text box displaying a summary of the workout
    public void createWorkoutSummary() {
        JEditorPane summary = new JEditorPane();
        summary.setEditable(false);

        summary.setText("Workout Information: \n\nDate of workout: " + workout.getDate().formatToString()
                + "\n\nWorkout name: " + workout.getName() + "\n\n" + createExerciseSummary());

        JScrollPane scrollPane = createScrollPane(summary);

        pane.add(scrollPane);
    }

    // EFFECTS: returns a string displaying a summary of exercise information
    public String createExerciseSummary() {
        if (workout.size() == 0) {
            return "No exercises completed.";
        } else {
            StringBuilder exerciseInfo = new StringBuilder();
            for (Exercise e : workout.getExercises()) {
                exerciseInfo.append(e.getExerciseInfo()).append("\n\n ");
            }
            return String.valueOf(exerciseInfo);
        }
    }

    // MODIFIES: this
    // EFFECTS: adds buttons which each display an exercise done in a workout
    private void createExerciseButtons() {
        List<Exercise> exercises = workout.getExercises();
        JPanel exercisesArea = new JPanel();
        JScrollPane scrollPane = createScrollPane(exercisesArea);
        pane.add(scrollPane);
        if (exercises.size() != 0) {
            exercisesArea.setLayout(new GridLayout(exercises.size(), 0,
                    gui.getHorizontalGap(), gui.getVerticalGap()));
            createExerciseButton(exercisesArea);
        }
    }

    // MODIFIES: parent
    // EFFECTS: adds scroll pane to parent
    private JScrollPane createScrollPane(JComponent parent) {
        return new JScrollPane(parent,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    // MODIFIES: this
    // EFFECTS: creates button corresponding to each exercise in exercises
    private void createExerciseButton(JPanel parent) {
        for (Exercise e: workout.getExercises()) {
            new EditExerciseButton(gui, parent, gui.getWorkoutSet(), e);
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a button that allows the user to delete the workout
    public void createDeleteButton() {
        new DeleteWorkoutButton(gui, pane, gui.getWorkoutSet(), workout);
    }

    // MODIFIES: this
    // EFFECTS: adds a back button to the screen
    public void createBackButton() {
        new ViewWorkoutBackButton(gui, pane, gui.getWorkoutSet());

    }

    public JPanel getPane() {
        return pane;
    }
}
