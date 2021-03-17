package ui.buttons.backbuttons;

import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewWorkoutBackButton extends BackButton {
    public ViewWorkoutBackButton(GUI gui, JComponent parent, WorkoutSet workoutSet) {
        super(gui, parent, workoutSet);
    }

    // MODIFIES: this
    // EFFECTS: associates button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new ViewWorkoutBackButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: returns to view workouts screen
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCards().show(gui.getContainer(), "view workouts");
        }
    }
}
