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
    // Code template attributed to TellerApp example
    private void runWorkoutLogger() {
        init();
        homeScreen();
    }

    // MODIFIES: this
    // EFFECTS: initializes workouts
    // Code template attributed to TellerApp example
    private void init() {
        workoutSet = new WorkoutSet();
        input = new Scanner(System.in);

        addPushWorkout();
        addLegsWorkout();
    }

    // MODIFIES: this
    // EFFECTS: adds a push workout containing bench press and overhead press to workouts
    private void addPushWorkout() {
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
    }

    // MODIFIES: this
    // EFFECTS: adds a legs workout containing front squats and Romanian deadlifts to workouts
    private void addLegsWorkout() {
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

    // EFFECTS: processes user inputs
    private void homeScreen() {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            displayHomeScreenPrompts();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
                System.exit(0);
            } else {
                processHomeScreenCommand(command);
            }
        }
    }

    // EFFECTS: displays prompts to enter in homeScreen
    private void displayHomeScreenPrompts() {
        System.out.println("\nSelect from:");
        System.out.println("\nv -> view, edit, or remove a workout");
        System.out.println("\na -> add a workout");
        System.out.println("\nq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command in homeScreen
    // Code attributed to TellerApp example
    private void processHomeScreenCommand(String command) {
        if (command.equals("v")) {
            viewWorkouts();
        } else if (command.equals("a")) {
            addWorkoutNavigator();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // Code attributed to TellerApp example
    private void viewWorkouts() {
        boolean keepGoing = true;
        String command = null;

        List<Integer> workoutIndices = new ArrayList<>();
        for (int i = 0; i < workoutSet.size(); i++) {
            workoutIndices.add(i);
        }
        while (keepGoing) {
            displayWorkoutsPrompts();
            displayExitPrompts();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("b")) {
                keepGoing = false;
            } else {
                processViewWorkoutsCommand(command, workoutIndices);
            }
        }
    }

    // EFFECTS: displays menu of workouts to user
    private void displayWorkoutsPrompts() {
        System.out.println("\nSelect one of the following workouts:");
        for (int i = 0; i < workoutSet.size(); i++) {
            String date = workoutSet.getWorkout(i).getDate().formatToString();
            String name = workoutSet.getWorkout(i).getName();
            System.out.println("\n" + Integer.toString(i) + " -> " + name + ": " + date);
        }
    }

    // EFFECTS: processes user command in viewWorkouts
    // Code attributed to TellerApp example
    private void processViewWorkoutsCommand(String command, List<Integer> workoutIndices) {
        if (command.equals("q")) {
            System.exit(0);
        } else if (workoutIndices.contains(Integer.parseInt(command))) {
            viewWorkout(workoutSet.getWorkout(Integer.parseInt(command)));
        } else {
            System.out.println("Please provide a valid input");
            viewWorkouts();
        }
    }

    // EFFECTS: displays prompts to either go back to the previous screen or quit to user
    private void displayExitPrompts() {
        System.out.println("\nb -> back");
        System.out.println("\nq -> quit");
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    // Code attributed to TellerApp example
    private void viewWorkout(Workout workout) {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            viewWorkoutSummary(workout);
            viewWorkoutPrompts(workout);
            displayExitPrompts();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("b")) {
                keepGoing = false;
            } else if (Integer.parseInt(command) == (workout.size() * 2)) {
                keepGoing = false;
                removeWorkout(workout);
            } else {
                processViewWorkoutCommand(command, workout);
            }
        }
    }

    // EFFECTS: produces information on the workout
    private void viewWorkoutSummary(Workout workout) {
        System.out.println("\n Below is a summary of the selected workout: ");
        System.out.println("\n Date of Workout: " + workout.getDate().formatToString());
        System.out.println("\n Workout Name: " + workout.getName());
        System.out.println("\n Exercises performed: ");
        for (Exercise exercise : workout.getExercises()) {
            System.out.println("\n" + exercise.getExerciseInfo());
        }
    }

    //EFFECTS: displays prompts to select in viewWorkout to the user
    private void viewWorkoutPrompts(Workout workout) {
        System.out.println("\nSelect one of the following options: ");
        for (int i = 0; i < workout.getExercises().size(); i++) {
            System.out.println("\n" + Integer.toString(i) + " -> edit " + workout.getExercise(i).getName());
        }
        for (int i = 0; i < workout.getExercises().size(); i++) {
            int z = i + 2;
            System.out.println("\n" + Integer.toString(z) + " -> remove " + workout.getExercise(i).getName());
        }
        System.out.println("\n" + Integer.toString(workout.size() * 2) + " -> remove workout");
    }

    // EFFECTS: processes user command in viewWorkout
    // Code attributed to TellerApp example
    private void processViewWorkoutCommand(String command, Workout workout) {
        System.out.println(Integer.toString(workout.size() * 2));
        if (command.equals("q")) {
            System.exit(0);
        } else if (workout.getExercises().contains(Integer.parseInt(command))) {
            editExercise(workout.getExercise(Integer.parseInt(command)));
        } else if (workout.getExercises().contains(Integer.parseInt(command + workout.size()))) {
            removeExercise(workout.getExercise(Integer.parseInt(command)));
        } else {
            System.out.println("Please provide a valid input");
            viewWorkouts();
        }
    }

    // MODIFIES: this
    // EFFECTS: removes workout from workouts
    private void removeWorkout(Workout workout) {
        int index = workoutSet.indexOf(workout);
        String workoutInfo = workout.getName() + " on " + workout.getDate().formatToString();
        workoutSet.removeWorkout(index);
        System.out.println(workoutInfo + " successfully removed");
        homeScreen();
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
    private void removeExercise(Exercise exercise) {
    }

    // MODIFIES: this
    // EFFECTS: adds exercise
    private void addExercise() {
    }

    // MODIFIES: this
    // EFFECTS: edits exercise
    private void editExercise(Exercise exercise) {
    }


}
