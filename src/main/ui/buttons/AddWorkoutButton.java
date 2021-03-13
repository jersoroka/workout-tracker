package ui.buttons;

import model.WorkoutSet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWorkoutButton extends Button {

    public AddWorkoutButton(JComponent parent, WorkoutSet workoutSet) {
        super(parent, workoutSet);
    }

    // EFFECTS: returns add workout label
    @Override
    protected String getLabel() {
        return "Add Workout";
    }

    // MODIFIES: this
    // EFFECTS: associates button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new AddWorkoutButton.AddWorkoutButtonClickHandler());
    }

    private class AddWorkoutButtonClickHandler implements ActionListener {

        // EFFECTS: opens add workout screen when clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            addWorkoutScreen();
        }
    }

    // EFFECTS: opens add workout screen
    // TODO: how do you open up a new screen?
    private void addWorkoutScreen() {}
}
