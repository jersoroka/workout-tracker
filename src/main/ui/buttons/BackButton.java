package ui.buttons;

import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BackButton extends Button {
    String card;

    public BackButton(GUI gui, JComponent parent, WorkoutSet workoutSet, String card) {
        super(gui, parent, workoutSet);
        this.card = card;


    }

    // MODIFIES: this, parent
    // EFFECTS: creates new back button
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    // EFFECTS: return back button label
    @Override
    protected String getLabel() {
        return "Back";
    }


    // MODIFIES: this
    // EFFECTS: associates button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new BackButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: returns to previous screen
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCards().show(gui.getContainer(), card);
        }
    }



}
