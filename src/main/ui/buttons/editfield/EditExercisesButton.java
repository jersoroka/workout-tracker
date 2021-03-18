package ui.buttons.editfield;

import model.Workout;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class that represents a button labelled "Edit exercises" that takes user to edit exercises screen

public class EditExercisesButton extends Button {

    // MODIFIES: this
    // EFFECTS: constructs a button that when pressed, lets the user edit exercises
    public EditExercisesButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    // EFFECTS: returns edit exercises label
    @Override
    protected String getLabel() {
        return "Edit Exercises";
    }

    // MODIFIES: this
    // EFFECTS: adds a listener for this button
    @Override
    protected void addListener() {
        button.addActionListener(new EditExercisesButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: loads edit exercises screen
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.createEditExercisesScreen((Workout) object);
            gui.getCards().show(gui.getContainer(), "edit exercises");
        }
    }

}
