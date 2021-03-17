package ui.buttons;

import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWorkoutBackButton extends Button {
    public AddWorkoutBackButton(GUI gui, JComponent parent, WorkoutSet workoutSet) {
        super(gui, parent, workoutSet);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    @Override
    protected String getLabel() {
        return "Back";
    }

    @Override
    protected void addListener() {
        button.addActionListener(new AddWorkoutBackButton.AddWorkoutBackButtonClickHandler());
    }

    private class AddWorkoutBackButtonClickHandler implements ActionListener {

        // EFFECTS: returns to home screen
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCards().show(gui.getContainer(), "home");
        }
    }
}
