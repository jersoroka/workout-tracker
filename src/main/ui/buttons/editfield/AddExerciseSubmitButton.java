package ui.buttons.editfield;

import model.Workout;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class representing a button that allows the user to add an exercise to a workout
// buttons developed using https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git
// as template

public class AddExerciseSubmitButton extends Button {
    JEditorPane name;

    // MODIFIES: this
    // EFFECTS: creates a button that allows the user to add an exercise
    public AddExerciseSubmitButton(GUI gui, JComponent parent, Object object, JEditorPane name) {
        super(gui, parent, object);
        this.name = name;
    }

    @Override
    protected String getLabel() {
        return "Add Exercise";
    }

    // MODIFIES: this
    // EFFECTS: associates button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new AddExerciseSubmitButton.ClickHandler());
    }

    // class representing a click handler
    private class ClickHandler implements ActionListener {

        // MODIFIES: this
        // EFFECTS: adds new exercise with user provided name is name is non-zero length.  Otherwise,
        //          makes a sound and creates a popup indicating that the entry is invalid.
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isNameValid(name.getText())) {
                Workout workout = (Workout) object;
                workout.addExercise(name.getText());
                gui.createViewWorkoutScreen(workout);
                gui.createEditExercisesScreen(workout);
                gui.getCards().show(gui.getContainer(), "view workout");
            } else {
                errorPopup("Name must contain at least one character.");
            }
        }
    }
}
