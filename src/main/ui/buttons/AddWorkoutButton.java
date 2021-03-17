package ui.buttons;

import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWorkoutButton extends Button {

    public AddWorkoutButton(GUI gui, JComponent parent) {
        super(gui, parent, gui.getWorkoutSet());
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    // EFFECTS: returns add workout label
    @Override
    protected String getLabel() {
        return "Add Workout";
    }

    // MODIFIES: this
    // EFFECTS: associates button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new AddWorkoutButton.AddWorkoutButtonClickHandler());
    }

    private class AddWorkoutButtonClickHandler implements ActionListener {

        // EFFECTS: opens add workout screen when clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.createViewWorkoutsScreen();
            gui.getCards().show(gui.getContainer(), "add workout");
        }
    }

}
