package ui.buttons.editfield;

import model.Date;
import model.Workout;
import ui.GUI;
import ui.buttons.Button;
import ui.screens.ViewWorkout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class representing a button that edits a workout name and date

public class EditNameAndDateSubmitButton extends Button {
    Workout workout;
    JEditorPane name;
    JEditorPane month;
    JEditorPane day;
    JEditorPane year;

    // MODIFIES: this
    // EFFECTS: creates button that that takes entries, and if valid, makes changes
    public EditNameAndDateSubmitButton(GUI gui, JComponent parent, JEditorPane name, JEditorPane month,
                                       JEditorPane day, JEditorPane year, Workout workout) {
        super(gui, parent);
        this.name = name;
        this.month = month;
        this.day = day;
        this.year = year;
        this.workout = workout;
    }

    // EFFECTS: produces true if combination of year, month, and day is valid, false otherwise
    public boolean isDateValid(String year, String month, String day) {
        if (isOnlyIntegers(year) | isOnlyIntegers(month) | isOnlyIntegers(day)) {
            return false;
        } else {
            Date date = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            return date.isValidDate();
        }
    }

    // EFFECTS: produces true if string does not contain only integers, false otherwise
    public boolean isOnlyIntegers(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    // EFFECTS: returns submit label
    @Override
    protected String getLabel() {
        return "Submit";
    }

    // EFFECTS: produces true if the date combination is valid and the name is non-zero length, false otherwise.
    //          Produces a message dialog that informs the user of the error that they made.
    protected boolean isValid() {
        if (!isDateValid(year.getText(), month.getText(), day.getText())) {
            errorPopup("Invalid date combination.");
            return false;
        } else if (!isNameValid(name.getText())) {
            errorPopup("Name must contain at least one character.");
            return false;
        } else {
            return true;
        }
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
