package ui.buttons.navigation;

import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class that represents a back button

public class BackButton extends Button {
    String card;

    // MODIFIES: this
    // EFFECTS: creates a back button that returns the user to the previous screen
    public BackButton(GUI gui, JComponent parent, String card) {
        super(gui, parent);
        this.card = card;
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

    // class that represents a click handler
    private class ClickHandler implements ActionListener {

        // EFFECTS: returns to previous screen and plays a sound
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCards().show(gui.getContainer(), card);
        }
    }



}
