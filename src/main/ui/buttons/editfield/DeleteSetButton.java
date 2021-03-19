package ui.buttons.editfield;

import model.Exercise;
import model.Set;
import model.Workout;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class that represents a button that deletes a specific set

public class DeleteSetButton extends Button {
    Exercise exercise;
    Workout workout;

    // MODIFIES: this
    // EFFECTS: constructs a delete set button
    public DeleteSetButton(GUI gui, JComponent parent, Object object, Exercise exercise, Workout workout) {
        super(gui, parent, object);
        this.exercise = exercise;
        this.workout = workout;
    }

    // EFFECTS: returns the delete set name
    @Override
    protected String getLabel() {
        return "Delete";
    }

    // MODIFIES: this
    // EFFECTS: adds a listener for this button
    @Override
    protected void addListener() {
        button.addActionListener(new DeleteSetButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: deletes set and re-opens view exercises window
        @Override
        public void actionPerformed(ActionEvent e) {
            Set set = (Set) object;
            exercise.removeSet(set);

            gui.createViewWorkoutScreen(workout);
            gui.createEditExercisesScreen(workout);

            gui.getCards().show(gui.getContainer(), "edit exercises");
        }
    }

}
