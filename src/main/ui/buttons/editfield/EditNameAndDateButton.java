package ui.buttons.editfield;

import model.Workout;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class that represents a button that allows the user to edit the name and date of a workout

public class EditNameAndDateButton extends Button {

    // MODIFIES: this
    // EFFECTS: creates a button labelled "Edit Name and Date"
    public EditNameAndDateButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    // EFFECTS: returns edit name and date label
    @Override
    protected String getLabel() {
        return "Edit Name and Date";
    }

    // MODIFIES: this
    // EFFECTS: adds a listener for this button
    @Override
    protected void addListener() {
        button.addActionListener(new EditNameAndDateButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: opens edit name and date screen
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.createEditNameAndDateScreen((Workout) object);
            gui.getCards().show(gui.getContainer(), "edit name and date");
        }
    }
}
