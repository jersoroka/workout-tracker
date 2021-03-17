package ui.screens;

import model.Exercise;
import model.Workout;
import ui.GUI;
import ui.buttons.DeleteWorkoutButton;
import ui.buttons.additionalobjectbutton.EditExerciseButton;
import ui.buttons.BackButton;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewWorkout extends Screen {
    Workout workout = (Workout) object;

    public ViewWorkout(GUI gui, Object object) {
        super(gui, object, "view workout");
        createWorkoutSummary();
        createExerciseButtons();
        createDeleteButton();
        createBackButton("view workouts");
    }

    // MODIFIES: this, gui
    // EFFECTS: creates the window where the user can view a specific workout
    @Override
    protected void initializePane() {
        super.initializePane();
        gui.getContainer().add(this.getPane(), cardName);
        pane.setLayout(new GridLayout(4, 0, gui.getHorizontalGap(), gui.getVerticalGap()));

    }

    // MODIFIES: this
    // EFFECTS: creates an uneditable text box displaying a summary of the workout
    public void createWorkoutSummary() {
        JEditorPane summary = new JEditorPane();
        summary.setEditable(false);
        Workout workout = (Workout) object;

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


}