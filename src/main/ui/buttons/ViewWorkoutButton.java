package ui.buttons;

import model.Workout;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewWorkoutButton extends Button {

    public ViewWorkoutButton(GUI gui, JComponent parent, Workout workout) {
        super(gui, parent, workout);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    @Override
    protected String getLabel() {
        Workout workout = (Workout) this.object;
        return workout.getName() + ": " + workout.getDate().formatToString();
    }

    @Override
    protected void addListener() {
        button.addActionListener(new ViewWorkoutButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: loads selected workout
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.createViewWorkoutScreen((Workout) object);
            gui.getCards().show(gui.getContainer(), "view workout");
        }
    }

}
