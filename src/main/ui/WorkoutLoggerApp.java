package ui;

import model.Exercise;
import model.Workout;
import model.WorkoutSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkoutLoggerApp {
    private WorkoutSet workoutSet;
    private Scanner input;
    private Workout push;
    private Workout legs;

    // EFFECTS: runs the workout logger app
    public WorkoutLoggerApp() {
        runWorkoutLogger();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // Code attributed to TellerApp example
    private void runWorkoutLogger() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
    }

    private void init() {
        workoutSet = new WorkoutSet();
        input = new Scanner(System.in);

        workoutSet.addWorkout(2021, 2, 1, "push");

        push = workoutSet.getWorkout(0);
        push.addExercise("bench press");
        Exercise benchPress = push.getExercise(0);
        push.addExercise("overhead press");
        Exercise overheadPress = push.getExercise(1);

        benchPress.addSet(10, 135, "warmup");
        benchPress.addSet(10, 185, "working set");
        benchPress.addSet(8, 115, "3 second pause");

        overheadPress.addSet(10, 95, "warmup");
        overheadPress.addSet(5, 135, "RPE 8");
        overheadPress.addSet(5, 125, "RPE 8");

        workoutSet.addWorkout(2021, 2, 3, "legs");
        legs = workoutSet.getWorkout(1);
        legs.addExercise("front squat");
        Exercise frontSquat = legs.getExercise(0);
        legs.addExercise("romanian deadlift");
        Exercise romanianDeadlift = legs.getExercise(1);

        frontSquat.addSet(10, 135, "warmup");
        frontSquat.addSet(10, 185, "working set");
        frontSquat.addSet(8, 115, "slow descent, explosive out of bottom");

        romanianDeadlift.addSet(10, 95, "warmup");
        romanianDeadlift.addSet(5, 135, "RPE 8");
        romanianDeadlift.addSet(5, 125, "RPE 8");

    }

    // MODIFIES: this
    // EFFECTS: processes user command
    // Code attributed to TellerApp example
    private void processCommand(String command) {
        if (command.equals("v")) {
            viewWorkoutsNavigator();
        } else if (command.equals("a")) {
            addWorkoutNavigator();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: displays menu of options to enter
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\nv -> view, edit, or remove a workout");
        System.out.println("\na -> add a workout");
        System.out.println("\nq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // Code attributed to TellerApp example
    private void viewWorkoutsNavigator() {
        boolean keepGoing = true;
        String command = null;

        List<Integer> workouts = new ArrayList<>();
        for (int i = 0; i < workoutSet.size(); i++) {
            workouts.add(i);
        }

        while (keepGoing) {
            viewWorkouts();
            displayExits();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
                keepGoing = false;
            } else if (command.equals("b")) {
                keepGoing = false;
            } else if (workouts.contains(Integer.parseInt(command))) {
                viewWorkoutNavigator(workoutSet.getWorkout(Integer.parseInt(command)));
            } else {
                System.out.println("Please provide a valid input");
                viewWorkoutsNavigator();
            }
        }
    }

    private void displayExits() {
        System.out.println("\nb -> back");
        System.out.println("\nq -> quit");
    }

    // TODO: create a view of the name of the workout and the day
    // TODO: allows the user to select a workout
    // TODO: once a workout is selected, the user is given an option to either view the workout, edit via editWorkout,
    //  or remove via removeWorkout
    // EFFECTS: displays menu of workouts to user
    private void viewWorkouts() {
        System.out.println("\nSelect one of the following workouts:");
        for (int i = 0; i < workoutSet.size(); i++) {
            String date = workoutSet.getWorkout(i).getDate().formatToString();
            String name = workoutSet.getWorkout(i).getName();
            System.out.println("\n" + Integer.toString(i) + " -> " + name + ": " + date);
        }
    }

    private void viewWorkout(Workout workout) {
        System.out.println("\n Below is a summary of the selected workout: ");
        System.out.println("\n Date of Workout: " + workout.getDate().formatToString());
        System.out.println("\n Workout Name: " + workout.getName());
        System.out.println("\n Exercises performed: ");
        for (Exercise exercise : workout.getExercises()) {
            System.out.println("\n" + exercise.getExerciseInfo());
        }

        for (int i = 0; i < workout.getExercises().size(); i++) {
            System.out.println("\n" + Integer.toString(i) + " -> edit " + workout.getExercise(i).getName());
        }

        for (int i = 0; i < workout.getExercises().size(); i++) {
            int z = i + 2;
            System.out.println("\n" + Integer.toString(z) + " -> remove " + workout.getExercise(i).getName());
        }

    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // Code attributed to TellerApp example
    private void viewWorkoutNavigator(Workout workout) {
        boolean keepGoing = true;
        String command = null;

        List<Integer> workouts = new ArrayList<>();
        for (int i = 0; i < workoutSet.size(); i++) {
            workouts.add(i);
        }

        while (keepGoing) {
            viewWorkout(workout);
            displayExits();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
                keepGoing = false;
                keepGoing = false;
            } else if (command.equals("b")) {
                keepGoing = false;
            } else if (workout.getExercises().contains(Integer.parseInt(command))) {
                keepGoing = false;
                viewExercise(workout.getExercise(Integer.parseInt(command)));
            } else {
                System.out.println("Please provide a valid input");
                viewWorkoutsNavigator();
            }
        }
    }

    private void viewExercise(Exercise exercise) {
        System.out.println("\nSelect one of the following sets:");
        for (int i = 0; i < workoutSet.size(); i++) {
            String date = workoutSet.getWorkout(i).getDate().formatToString();
            String name = workoutSet.getWorkout(i).getName();
            System.out.println("\n" + Integer.toString(i) + " -> " + name + ": " + date);
        }
    }

    private void addWorkoutNavigator() {
    }

    // TODO: adds a new workout to workouts
    // TODO: create input validation statements for dates
    // TODO: once a workout is added, give the user an option to add exercises via editWorkout
    // MODIFIES: this
    // EFFECTS: adds a workout the workouts
    private void addWorkout() {
    }

    // MODIFIES: this
    // EFFECTS: edits the date, name, or exercises in workout
    private void editWorkout() {
    }

    // MODIFIES: this
    // EFFECTS: removes workout from workouts
    private void removeWorkout() {
    }

    // MODIFIES: this
    // EFFECTS: changes the date of the workout
    private void changeDate() {
    }

    // MODIFIES: this
    // EFFECTS: changes the name of the workout
    private void changeWorkoutName() {
    }

    // EFFECTS: displays the exercises in the workout
    private void displayExercises() {
    }

    // MODIFIES: this
    // EFFECTS: removes exercise
    private void removeExercise() {
    }

    // MODIFIES: this
    // EFFECTS: adds exercise
    private void addExercise() {
    }


}
