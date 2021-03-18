package ui.buttons.editfield;

import model.Exercise;
import model.Workout;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class that represents a button that allows the user to delete an exercise

public class DeleteExerciseButton extends Button {
    Exercise exercise;

    // MODIFIES: this
    // EFFECTS: constructs a button that lets the user delete an exercise
    public DeleteExerciseButton(GUI gui, JComponent parent, Object object, Exercise exercise) {
        super(gui, parent, object);
        this.exercise = exercise;
    }

    // EFFECTS: returns the delete exercise label
    @Override
    protected String getLabel() {
        return null;
    }

    // MODIFIES: this
    // EFFECTS: adds a listener for this button
    @Override
    protected void addListener() {
        button.addActionListener(new DeleteExerciseButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: deletes exercise and re-opens view exercise window
        @Override
        public void actionPerformed(ActionEvent e) {
            Workout workout = (Workout) object;
            workout.removeExercise(workout.indexOf(exercise));

            gui.createViewWorkoutScreen(workout);
            gui.createEditExercisesScreen(workout);

            gui.getCards().show(gui.getContainer(), "edit exercises");
        }
    }
}
