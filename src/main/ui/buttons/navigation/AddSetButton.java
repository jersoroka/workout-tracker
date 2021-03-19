package ui.buttons.navigation;

import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class that represents a button that directs the user to the add set screen

public class AddSetButton extends Button {

    // MODIFIES: this
    // EFFECTS: constructs an add set navigation button
    public AddSetButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    // EFFECTS: returns add set label
    @Override
    protected String getLabel() {
        return "Add Set";
    }

    // MODIFIES: this
    // EFFECTS: associates button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new AddSetButton.AddSetButtonClickHandler());
    }

    // class that represents a click handler
    private class AddSetButtonClickHandler implements ActionListener {

        // EFFECTS: opens add set screen when clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            //gui.createAddSetScreen((Exercise) object);
            //gui.getCards().show(gui.getContainer(), "add set");
        }
    }
}
