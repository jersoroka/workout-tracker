package ui.buttons.navigation;

import model.Exercise;
import model.Workout;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

// class representing a button that changes the exercise name

public class EditExerciseNameButton extends Button {
    JEditorPane name;
    Workout workout;

    // MODIFIES: this
    // EFFECTS: creates edit exercise name button
    public EditExerciseNameButton(GUI gui, JComponent parent, Object object, JEditorPane name,
                                  Workout workout) {
        super(gui, parent, object);
        this.name = name;
        this.workout = workout;
    }

    // EFFECTS: return submit new name label
    @Override
    protected String getLabel() {
        return "Submit New Name";
    }

    // EFFECTS: produces true if the string contains at least one non-whitespace character, false otherwise
    private boolean isNameValid(String command) {
        return Pattern.matches("(.*[A-Za-z0-9]+.*)+", command);
    }

    // MODIFIES: this
    // EFFECTS: adds a listener for this button
    @Override
    protected void addListener() {
        button.addActionListener(new EditExerciseNameButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: if the name is non-zero length, changes the exercise name. Otherwise creates a pop-up
        //          and plays a sound that alerts the user of the error.
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isNameValid(name.getText())) {
                Exercise exercise = (Exercise) object;
                exercise.setName(name.getText());
                gui.createViewWorkoutScreen(workout);
                gui.createEditExercisesScreen(workout);
                gui.getCards().show(gui.getContainer(), "edit exercises");
            } else {
                JOptionPane.showMessageDialog(parent, "Name must contain at least one character.");
                playErrorSound();
            }
        }
    }
}
