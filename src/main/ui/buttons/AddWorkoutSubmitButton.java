package ui.buttons;

import model.Date;
import model.Workout;
import ui.GUI;
import ui.screens.ViewWorkout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class AddWorkoutSubmitButton extends Button {
    JEditorPane name;
    JEditorPane month;
    JEditorPane day;
    JEditorPane year;

    public AddWorkoutSubmitButton(GUI gui, JComponent parent, JEditorPane name, JEditorPane month, JEditorPane day,
                                  JEditorPane year) {
        super(gui, parent, gui.getWorkoutSet());
        this.name = name;
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // EFFECTS: produces true if combination of year, month, and day is valid
    private boolean dateValidation(String year, String month, String day) {
        if (!isOnlyIntegers(year) | !isOnlyIntegers(month) | !isOnlyIntegers(day)) {
            return false;
        } else {
            Date date = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            return date.isValidDate();
        }
    }

    // EFFECTS: produces true if the string contains at least one non-whitespace character, false otherwise
    private boolean nameValidation(String command) {
        return Pattern.matches("(.*[A-Za-z0-9]+.*)+", command);
    }

    // EFFECTS: produces true if string contains only integer characters, false otherwise
    public boolean isOnlyIntegers(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    @Override
    protected String getLabel() {
        return "Submit";
    }

    @Override
    protected void addListener() {
        button.addActionListener(new AddWorkoutSubmitButton.SubmitButtonClickHandler());
    }

    private class SubmitButtonClickHandler implements ActionListener {

        // EFFECTS: adds workout and opens view workouts screen
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!dateValidation(year.getText(), month.getText(), day.getText())) {
                JOptionPane.showMessageDialog(parent, "Invalid date combination.");
                Runnable sound = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
                sound.run();
            } else if (!nameValidation(name.getText())) {
                JOptionPane.showMessageDialog(parent, "Name must contain at least one character.");
                Runnable sound = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
                sound.run();
            } else {
                Workout workout = new Workout(new Date(Integer.parseInt(year.getText()),
                        Integer.parseInt(month.getText()), Integer.parseInt(day.getText())), name.getText());
                workoutSet.addWorkout(workout);
                new ViewWorkout(gui, workout);
                gui.getCards().show(gui.getContainer(), "view workout");
            }
        }
    }
}
