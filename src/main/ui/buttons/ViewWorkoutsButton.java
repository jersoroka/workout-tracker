package ui.buttons;

import model.WorkoutSet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewWorkoutsButton extends Button {
    public ViewWorkoutsButton(JComponent parent, WorkoutSet workoutSet) {
        super(parent, workoutSet);
    }

    // EFFECTS: returns view workouts button
    @Override
    protected String getLabel() {
        return null;
    }

    // MODIFIES: this
    // EFFECTS: associates button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new ViewWorkoutsButton.ViewWorkoutsButtonClickHandler());
    }

    private class ViewWorkoutsButtonClickHandler implements ActionListener {

        // EFFECTS: opens view workout screen when clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            viewWorkoutScreen();
        }
    }

    // EFFECTS: opens view workouts screen
    // TODO: how do you open up a new screen?
    private void viewWorkoutScreen() {}
}
