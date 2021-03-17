package ui.buttons.additionalobjectbutton;

import model.Exercise;
import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditExerciseButton extends AdditionalObjectButton {

    public EditExerciseButton(GUI gui, JComponent parent, WorkoutSet workoutSet, Object object) {
        super(gui, parent, workoutSet, object);
    }

    @Override
    protected String getLabel() {
        Exercise exercise = (Exercise) this.object;
        return exercise.getName();
    }

    @Override
    protected void addListener() {
        button.addActionListener(new EditExerciseButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: loads selected exercise
        @Override
        public void actionPerformed(ActionEvent e) {
            //
        }
    }
}
