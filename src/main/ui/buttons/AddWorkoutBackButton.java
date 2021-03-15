package ui.buttons;

import model.WorkoutSet;
import ui.WorkoutLoggerAppGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWorkoutBackButton extends Button {
    public AddWorkoutBackButton(WorkoutLoggerAppGUI workoutLoggerAppGUI, JComponent parent, WorkoutSet workoutSet) {
        super(workoutLoggerAppGUI, parent, workoutSet);
    }

    @Override
    protected String getLabel() {
        return "Back";
    }

    @Override
    protected void addListener() {
        button.addActionListener(new AddWorkoutBackButton.AddWorkoutBackButtonClickHandler());
    }

    private class AddWorkoutBackButtonClickHandler implements ActionListener {

        // EFFECTS: returns to home screen
        @Override
        public void actionPerformed(ActionEvent e) {
            workoutLoggerAppGUI.getCards().show(workoutLoggerAppGUI.getContainer(), "home");
        }
    }
}
