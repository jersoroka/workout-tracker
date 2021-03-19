package ui.buttons.navigation;

import model.Set;
import model.Workout;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditSetButton extends Button {

    // MODIFIES: this, gui, parent
    // EFFECTS: creates edit set button
    public EditSetButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    // EFFECTS: return edit set label
    @Override
    protected String getLabel() {
        return "Edit";
    }

    // MODIFIES: this
    // EFFECTS: adds a listener for this button
    @Override
    protected void addListener() {
        new EditSetButton.ClickHandler();
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: opens edit set screen
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.createEditSetScreen((Set) object);
            gui.getCards().show(gui.getContainer(), "edit set");
        }
    }
}
