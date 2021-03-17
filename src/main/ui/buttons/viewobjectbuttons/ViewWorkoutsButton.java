package ui.buttons.viewobjectbuttons;

import model.WorkoutSet;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewWorkoutsButton extends Button {
    public ViewWorkoutsButton(GUI gui, JComponent parent, WorkoutSet workoutSet) {
        super(gui, parent, workoutSet);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    // EFFECTS: returns view workouts label
    @Override
    protected String getLabel() {
        return "View Workouts";
    }

    // MODIFIES: this
    // EFFECTS: associates button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new ViewWorkoutsButton.ViewWorkoutsButtonClickHandler());
    }

    private class ViewWorkoutsButtonClickHandler implements ActionListener {

        // EFFECTS: opens view workout screen when clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCards().show(gui.getContainer(), "view workouts");
        }
    }
}
