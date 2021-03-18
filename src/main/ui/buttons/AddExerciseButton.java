package ui.buttons;

import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddExerciseButton extends Button {

    public AddExerciseButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
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
            //gui.createEditExerciseScreen((Workout) object);
            //gui.getCards().show(gui.getContainer(), "add exercise");
        }
    }
}
