package ui.buttons.navigation;

import model.Exercise;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class representing the edit exercise button

public class EditExerciseButton extends Button {

    // MODIFIES: this
    // EFFECTS: creates edit exercise button
    public EditExerciseButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    // EFFECTS: returns edit label for a specific exercise
    @Override
    protected String getLabel() {
        Exercise exercise = (Exercise) this.object;
        return "Edit " + exercise.getName();
    }

    // MODIFIES: this
    // EFFECTS: adds a listener for this button
    @Override
    protected void addListener() {
        button.addActionListener(new EditExerciseButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: loads selected exercise
        @Override
        public void actionPerformed(ActionEvent e) {
            //
        }
    }
}
