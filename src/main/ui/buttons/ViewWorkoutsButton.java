package ui.buttons;

import model.WorkoutSet;
import ui.WorkoutLoggerAppGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewWorkoutsButton extends Button {
    public ViewWorkoutsButton(WorkoutLoggerAppGUI workoutLoggerAppGUI, JComponent parent, WorkoutSet workoutSet) {
        super(workoutLoggerAppGUI, parent, workoutSet);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    // EFFECTS: returns view workouts label
    @Override
    protected String getLabel() {
        return "View Workouts";
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
            workoutLoggerAppGUI.getCards().show(workoutLoggerAppGUI.getContainer(), "view workouts");
        }
    }
}
