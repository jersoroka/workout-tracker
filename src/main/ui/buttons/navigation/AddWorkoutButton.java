package ui.buttons.navigation;

import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class that represents a button that directs the user to the add workout screen
// buttons developed using https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git
// as template

public class AddWorkoutButton extends Button {

    // MODIFIES: this
    // EFFECTS: constructs an add workout navigation button
    public AddWorkoutButton(GUI gui, JComponent parent) {
        super(gui, parent);
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
        button.addActionListener(new AddWorkoutButton.ClickHandler());
    }

    // class that represents a click handler
    private class ClickHandler implements ActionListener {

        // EFFECTS: opens add workout screen when clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.createViewWorkoutsScreen();
            gui.getCards().show(gui.getContainer(), "add workout");
        }
    }

}
