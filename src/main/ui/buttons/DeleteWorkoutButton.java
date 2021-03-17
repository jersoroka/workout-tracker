package ui.buttons;

import model.Workout;
import model.WorkoutSet;
import ui.GUI;
import ui.buttons.additionalobjectbutton.AdditionalObjectButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteWorkoutButton extends AdditionalObjectButton {


    public DeleteWorkoutButton(GUI gui, JComponent parent, WorkoutSet workoutSet, Object object) {
        super(gui, parent, workoutSet, object);
    }

    @Override
    protected String getLabel() {
        return "Delete Workout";
    }

    @Override
    protected void addListener() {
        button.addActionListener(new DeleteWorkoutButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: deletes workout and re-opens view workouts screen
        @Override
        public void actionPerformed(ActionEvent e) {
            Workout workout = (Workout) object;
            workoutSet.removeWorkout(workoutSet.indexOf(workout));
            gui.createViewWorkoutsScreen();
            gui.getCards().show(gui.getContainer(), "view workouts");
        }
    }
}
