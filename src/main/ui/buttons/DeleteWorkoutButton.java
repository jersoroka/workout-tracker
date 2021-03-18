package ui.buttons;

import model.Workout;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteWorkoutButton extends Button {


    public DeleteWorkoutButton(GUI gui, JComponent parent, Object object) {
        super(gui, parent, object);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
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
