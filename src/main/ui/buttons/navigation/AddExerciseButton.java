package ui.buttons.navigation;

import model.Workout;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class that represents a button that takes the user to the add exercise screen
public class AddExerciseButton extends Button {

    // MODIFIES: this
    // EFFECTS: creates an add exercise button that takes the user to the add exercise screen
    public AddExerciseButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    // EFFECTS: returns add exercise label
    @Override
    protected String getLabel() {
        return "Add Exercise";
    }

    // MODIFIES: this
    // EFFECTS: associates click handler with button
    @Override
    protected void addListener() {
        button.addActionListener(new AddExerciseButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: opens add exercise screen
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.createAddExerciseScreen((Workout) object);
            gui.getCards().show(gui.getContainer(), "add exercise");
        }
    }
}
