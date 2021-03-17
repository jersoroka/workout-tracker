package ui.buttons;

import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWorkoutSubmitButton extends Button {

    public AddWorkoutSubmitButton(GUI gui, JComponent parent, WorkoutSet workoutSet) {
        super(gui, parent, workoutSet);
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
            // addWorkout();
            gui.getCards().show(gui.getContainer(), "view workouts");
        }
    }

//    // MODIFIES: this
//    // EFFECTS: adds workout to workoutSet
//    private void addWorkout() {
//        boolean keepGoing = true;
//        Date date = new Date(2021, 1, 1);
//        Workout workout = new Workout(date, "default");
//
//        while (keepGoing) {
//            setWorkoutName(workout);
//            setWorkoutDate(workout);
//            workoutSet.addWorkout(workout);
//            keepGoing = false;
//            System.out.println("\nWorkout name set to " + workout.getName());
//            viewWorkouts();
//        }
//    }
//
//    // MODIFIES: this, workout
//    // EFFECTS: sets workout name
//    private void setWorkoutName(Workout workout) {
//        boolean keepGoing = true;
//        String command;
//
//        while (keepGoing) {
//            System.out.println("\nEnter the new name of the workout");
//            command = input.useDelimiter("\\n").next();
//            if (isNotOnlyWhitespace(command)) {
//                command = command.toLowerCase();
//                workout.setName(command);
//                System.out.println("\nWorkout name set to " + workout.getName());
//                workout.setName(command);
//                keepGoing = false;
//            } else {
//                invalidMinimumCharacterInput();
//            }
//        }
//    }
//
//    // MODIFIES: this, workout
//    // EFFECTS: changes workout date
//    private void setWorkoutDate(Workout workout) {
//        boolean keepGoing = true;
//
//        while (keepGoing) {
//            System.out.println("\nEnter the year the workout is set");
//            String year = input.next();
//            System.out.println("Enter the month of the workout as a number. For example, May is 5 and July is 7");
//            String month = input.next();
//            System.out.println("Enter the day of the workout");
//            String day = input.next();
//
//            if (!isOnlyIntegers(year) | !isOnlyIntegers(month) | !isOnlyIntegers(day)) {
//                System.out.println("Please only enter positive integers");
//            } else {
//                Date date = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
//                if (workout.setDate(date)) {
//                    System.out.println("\nDate set to " + date.formatToString());
//                    keepGoing = false;
//                } else {
//                    System.out.println("\nThat date is not valid. Please enter a a valid date");
//                }
//            }
//        }
//    }
}
