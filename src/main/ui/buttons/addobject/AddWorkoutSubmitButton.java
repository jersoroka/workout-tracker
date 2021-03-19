package ui.buttons.addobject;

import model.Date;
import model.Workout;
import ui.GUI;
import ui.buttons.Button;
import ui.screens.ViewWorkout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

// class representing a button that pulls user entered workout field information and adds them to workoutSet if valid

public class AddWorkoutSubmitButton extends Button {
    JEditorPane name;
    JEditorPane month;
    JEditorPane day;
    JEditorPane year;

    // MODIFIES: this
    // EFFECTS: creates submit button
    public AddWorkoutSubmitButton(GUI gui, JComponent parent, JEditorPane name, JEditorPane month, JEditorPane day,
                                  JEditorPane year) {
        super(gui, parent);
        this.name = name;
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // EFFECTS: produces true if combination of year, month, and day is valid, false otherwise
    private boolean dateValidation(String year, String month, String day) {
        if (isOnlyIntegers(year) | isOnlyIntegers(month) | isOnlyIntegers(day)) {
            return false;
        } else {
            Date date = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            return date.isValidDate();
        }
    }

    // EFFECTS: produces true if the string contains at least one non-whitespace character, false otherwise
    private boolean isNameValid(String command) {
        return Pattern.matches("(.*[A-Za-z0-9]+.*)+", command);
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
        if (!dateValidation(year.getText(), month.getText(), day.getText())) {
            JOptionPane.showMessageDialog(parent, "Invalid date combination.");
            playErrorSound();
            return false;
        } else if (!isNameValid(name.getText())) {
            JOptionPane.showMessageDialog(parent, "Name must contain at least one character.");
            playErrorSound();
            return false;
        } else {
            return true;
        }
    }

    // MODIFIES: this
    // EFFECTS: associates button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new AddWorkoutSubmitButton.SubmitButtonClickHandler());
    }

    private class SubmitButtonClickHandler implements ActionListener {

        // MODIFIES: this
        // EFFECTS: adds workout if entries are valid and opens view workout screen
        //          If entry combination is invalid a popup is created and sound is made
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isValid()) {
                Workout workout = new Workout(new Date(Integer.parseInt(year.getText()),
                        Integer.parseInt(month.getText()), Integer.parseInt(day.getText())), name.getText());
                workoutSet.addWorkout(workout);
                gui.createViewWorkoutsScreen();
                new ViewWorkout(gui, workout);
                gui.getCards().show(gui.getContainer(), "view workout");
            }
        }
    }
}
