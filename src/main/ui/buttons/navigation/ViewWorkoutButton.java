package ui.buttons.navigation;

import model.Workout;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class representing a button that brings a user to the screen that views a specific workout

public class ViewWorkoutButton extends Button {

    // MODIFIES: this
    // EFFECTS: constructs a view workout button
    public ViewWorkoutButton(GUI gui, JComponent parent, Workout workout) {
        super(gui, parent, workout);
    }

    // EFFECTS: returns view workout label
    @Override
    protected String getLabel() {
        Workout workout = (Workout) this.object;
        return workout.getName() + ": " + workout.getDate().formatToString();
    }

    // MODIFIES: this
    // EFFECTS: adds a listener for this button
    @Override
    protected void addListener() {
        button.addActionListener(new ViewWorkoutButton.ClickHandler());
    }

    // class that represents a click handler
    private class ClickHandler implements ActionListener {

        // EFFECTS: loads selected workout
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.createViewWorkoutScreen((Workout) object);
            gui.getCards().show(gui.getContainer(), "view workout");
        }
    }

}
