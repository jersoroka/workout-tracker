package ui.buttons.addobject;

import model.Workout;
import ui.GUI;
import ui.screens.ViewWorkout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class representing a button that edits a workout name and date

public class EditNameAndDateSubmitButton extends AddWorkoutSubmitButton {
    Workout workout;

    // MODIFIES: this
    // EFFECTS: creates button that that takes entries, and if valid, makes changes
    public EditNameAndDateSubmitButton(GUI gui, JComponent parent, JEditorPane name, JEditorPane month,
                                       JEditorPane day, JEditorPane year, Workout workout) {
        super(gui, parent, name, month, day, year);
        this.workout = workout;
    }

    // MODIFIES: this
    // EFFECTS: associates button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new EditNameAndDateSubmitButton.SubmitButtonClickHandler());
    }

    private class SubmitButtonClickHandler implements ActionListener {

        // MODIFIES: this
        // EFFECTS: edits workout if entries are valid and opens view workout screen
        //          If entry combination is invalid a popup is created and sound is made
        public void actionPerformed(ActionEvent e) {
            if (isValid()) {
                workout.getDate().setYear(Integer.parseInt(year.getText()));
                workout.getDate().setMonth(Integer.parseInt(month.getText()));
                workout.getDate().setDay(Integer.parseInt(day.getText()));
                workout.setName(name.getText());

                gui.createViewWorkoutsScreen();
                gui.createViewWorkoutScreen(workout);
                new ViewWorkout(gui, workout);
                gui.getCards().show(gui.getContainer(), "view workout");
            }
        }
    }
}
