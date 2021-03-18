package ui.buttons;

import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditNameAndDateButton extends Button {

    public EditNameAndDateButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    @Override
    protected String getLabel() {
        return "Edit Name and Date";
    }

    @Override
    protected void addListener() {
        button.addActionListener(new EditNameAndDateButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: opens edit name and date screen
        @Override
        public void actionPerformed(ActionEvent e) {
            //gui.createEditNameAndDateScreen((Workout) object);
            //gui.getCards().show(gui.getContainer(), "edit name and date");
        }
    }
}
