package ui.buttons;

import model.Exercise;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditExerciseButton extends Button {

    public EditExerciseButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    @Override
    protected String getLabel() {
        Exercise exercise = (Exercise) this.object;
        return "Edit " + exercise.getName();
    }

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
