package ui.buttons;

import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditExercisesButton extends Button {
    public EditExercisesButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    // EFFECTS: returns edit exercises label
    @Override
    protected String getLabel() {
        return "Edit Exercises";
    }

    @Override
    protected void addListener() {
        button.addActionListener(new EditExercisesButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: loads edit exercises screen
        @Override
        public void actionPerformed(ActionEvent e) {
            //gui.createEditExercisesScreen((Workout) object);
            //gui.getCards().show(gui.getContainer(), "edit exercises");
        }
    }

}
