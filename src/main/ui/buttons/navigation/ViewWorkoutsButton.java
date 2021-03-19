package ui.buttons.navigation;

import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class that represents a button that takes the user to a screen showing all their workouts

public class ViewWorkoutsButton extends Button {

    // MODIFIES: this
    // EFFECTS: constructs a view workouts button
    public ViewWorkoutsButton(GUI gui, JComponent parent) {
        super(gui, parent);
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
