package ui.buttons.additionalobjectbutton;

import model.Workout;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditExercisesButton extends AdditionalObjectButton {
    public EditExercisesButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    // EFFECTS: returns edit exercises label
    @Override
    protected String getLabel() {
        return "Edit Exercises";
    }

    @Override
    protected void addListener() {
        button.addActionListener(new EditExercisesButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: loads edit exercises screen
        @Override
        public void actionPerformed(ActionEvent e) {
            //gui.createEditExercisesScreen((Workout) object);
            //gui.getCards().show(gui.getContainer(), "edit exercises");
        }
    }

}
