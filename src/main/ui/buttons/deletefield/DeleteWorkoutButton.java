package ui.buttons.deletefield;

import model.Workout;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class that represents a button that allows the user to delete a workout

public class DeleteWorkoutButton extends Button {

    // MODIFIES: this
    // EFFECTS: constructs a button that lets the user delete a workout
    public DeleteWorkoutButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    // EFFECTS: returns the delete workout label
    @Override
    protected String getLabel() {
        return "Delete Workout";
    }

    // MODIFIES: this
    // EFFECTS: adds a listener for this button
    @Override
    protected void addListener() {
        button.addActionListener(new DeleteWorkoutButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: deletes workout and re-opens view workouts screen
        @Override
        public void actionPerformed(ActionEvent e) {
            Workout workout = (Workout) object;
            workoutSet.removeWorkout(workoutSet.indexOf(workout));
            gui.createViewWorkoutsScreen();
            gui.getCards().show(gui.getContainer(), "view workouts");
        }
    }
}
