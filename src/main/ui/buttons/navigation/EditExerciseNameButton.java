package ui.buttons.navigation;

import model.Exercise;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class representing a button that brings the user to the edit exercise name screen

public class EditExerciseNameButton extends Button {

    // MODIFIES: this
    // EFFECTS: creates edit exercise name button
    public EditExerciseNameButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    // EFFECTS: return edit exercise name label
    @Override
    protected String getLabel() {
        return "Edit Name";
    }

    // MODIFIES: this
    // EFFECTS: adds a listener for this button
    @Override
    protected void addListener() {
        button.addActionListener(new EditExerciseNameButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: opens edit exercise name screen
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.createEditExerciseNameScreen((Exercise) object);
            gui.getCards().show(gui.getContainer(), "edit exercise name");
        }
    }
}
