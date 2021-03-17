package ui.buttons.backbuttons;

import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewWorkoutsBackButton extends BackButton {
    public ViewWorkoutsBackButton(GUI gui, JComponent parent, WorkoutSet workoutSet) {
        super(gui, parent, workoutSet);
    }

    // MODIFIES: this
    // EFFECTS: associates button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new ViewWorkoutsBackButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: returns to home screen when clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCards().show(gui.getContainer(), "home");
        }
    }
}
