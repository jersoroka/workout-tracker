package ui.buttons.deletefield;

import model.Exercise;
import model.Workout;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class that represents a button that allows the user to delete an exercise
// buttons developed using https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git
// as template

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
        return "Delete Exercise";
    }

    // MODIFIES: this
    // EFFECTS: adds a listener for this button
    @Override
    protected void addListener() {
        button.addActionListener(new DeleteExerciseButton.ClickHandler());
    }

    // class representing a click handler
    private class ClickHandler implements ActionListener {

        // MODIFIES: this
        // EFFECTS: deletes exercise and re-opens view exercises window
        @Override
        public void actionPerformed(ActionEvent e) {
            Workout workout = (Workout) object;
            workout.removeExercise(workout.indexOf(exercise));

            gui.createViewWorkoutScreen(workout);
            gui.createEditExercisesScreen(workout);

            gui.getCards().show(gui.getContainer(), "view workouts");
        }
    }
}
