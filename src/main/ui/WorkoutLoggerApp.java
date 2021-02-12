package ui;

import model.*;

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
                System.exit(0);
            } else {
                keepGoing = false;
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
            homeScreen();
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
                homeScreen();
            } else {
                keepGoing = false;
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
        }

        try {
            Integer.parseInt(command);
        } catch (NumberFormatException e) {
            System.out.println("Please provide a valid input");
            viewWorkouts();
        }

        int intCommand = Integer.parseInt(command);
        if (workoutIndices.contains(intCommand)) {
            viewWorkout(workoutSet.getWorkout(intCommand));
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

            keepGoing = false;
            processViewWorkoutCommand(command, workout);
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
            int z = i + workout.size();
            System.out.println("\n" + Integer.toString(z) + " -> remove " + workout.getExercise(i).getName());
        }
        System.out.println("\n" + Integer.toString((workout.size() * 2)) + " -> edit workout name");
        System.out.println("\n" + Integer.toString((workout.size() * 2) + 1) + " -> edit workout date");
        System.out.println("\n" + Integer.toString((workout.size() * 2) + 2) + " -> remove workout");
    }

    // EFFECTS: processes user command in viewWorkout
    // Code attributed to TellerApp example
    private void processViewWorkoutCommand(String command, Workout workout) {
        if (command.equals("b")) {
            viewWorkouts();
        } else if (command.equals("q")) {
            System.exit(0);
        }

        try {
            Integer.parseInt(command);
        } catch (NumberFormatException e) {
            System.out.println("Please provide a valid input");
            viewWorkout(workout);
        }

        int intCommand = Integer.parseInt(command);
        processViewWorkoutCommandNumberedOptions(intCommand, workout);
    }

    // EFFECTS: process user command in viewWorkout with numbers as options
    // Code attributed to TellerApp example
    private void processViewWorkoutCommandNumberedOptions(int command, Workout workout) {
        if ((0 <= command) & (command < workout.size())) {
            editExercise(workout.getExercise(command), workout);
        } else if ((workout.size() <= command) & (command < workout.size() * 2)) {
            removeExercise(workout.getExercise(command - workout.size()), workout);
        } else if (command == (workout.size() * 2)) {
            editWorkoutName(workout);
        } else if (command == ((workout.size() * 2) + 1)) {
            editWorkoutDate(workout);
        } else if (command == ((workout.size() * 2) + 2)) {
            removeWorkout(workout);
        }
    }


    // MODIFIES: this
    // EFFECTS: changes workout name
    private void editWorkoutName(Workout workout) {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            input.nextLine();
            System.out.println("\nEnter the new name of the workout");
            command = input.nextLine();
            command = command.toLowerCase();
            System.out.println("\nWorkout name changed to " + workout.getName());
            workout.setName(command);
            keepGoing = false;
            viewWorkout(workout);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes workout from workouts
    private void removeExercise(Exercise exercise, Workout workout) {
        int index = workout.indexOf(exercise);
        String exerciseInfo = exercise.getName();
        workout.removeExercise(index);
        System.out.println(exerciseInfo + " successfully removed");
        viewWorkout(workout);
    }

    // MODIFIES: this
    // EFFECTS: changes workout date
    private void editWorkoutDate(Workout workout) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\nEnter the new year of the workout");
            int year = Integer.parseInt(input.next());
            System.out.println("\nEnter the new month of the workout as a number."
                    + "\nFor example, January would be 1 and July would be 7.");
            int month = Integer.parseInt(input.next());
            System.out.println("Enter the new day of the workout");
            int day = Integer.parseInt(input.next());

            Date date = new Date(year, month, day);
            if (workout.setDate(date)) {
                System.out.println("\nDate changed to " + date.formatToString());
                keepGoing = false;
                viewWorkout(workout);
            } else {
                System.out.println("\nThat date is not valid. Please enter a a valid date");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: removes workout from workouts
    private void removeWorkout(Workout workout) {
        int index = workoutSet.indexOf(workout);
        String workoutInfo = workout.getName() + " on " + workout.getDate().formatToString();
        workoutSet.removeWorkout(index);
        System.out.println("\n" + workoutInfo + " successfully removed");
        viewWorkouts();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // Code attributed to TellerApp example
    private void editExercise(Exercise exercise, Workout workout) {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            System.out.println("\n" + exercise.getExerciseInfo());
            editExercisePrompts(exercise);
            displayExitPrompts();
            command = input.next();
            command = command.toLowerCase();

            keepGoing = false;
            processEditExerciseCommand(command, exercise, workout);
        }
    }

    //EFFECTS: displays prompts to select in editExercise to the user
    private void editExercisePrompts(Exercise exercise) {
        System.out.println("\nSelect one of the following options: ");
        for (int i = 0; i < exercise.size(); i++) {
            System.out.println("\n" + Integer.toString(i) + " -> edit Set " + Integer.toString(i + 1));
        }
        for (int i = 0; i < exercise.size(); i++) {
            System.out.println("\n" + Integer.toString(i + exercise.size())
                    + " -> remove Set " + Integer.toString(i + 1));
        }
    }

    // EFFECTS: processes user command in viewWorkout
    // Code attributed to TellerApp example
    private void processEditExerciseCommand(String command, Exercise exercise, Workout workout) {
        if (command.equals("b")) {
            viewWorkout(workout);
        } else if (command.equals("q")) {
            System.exit(0);
        }
        try {
            Integer.parseInt(command);
        } catch (NumberFormatException e) {
            System.out.println("Please provide a valid input");
            editExercise(exercise, workout);
        }
        int intCommand = Integer.parseInt(command);
        if ((0 <= intCommand) & (intCommand < exercise.size())) {
            editSet(exercise.getSet(intCommand), exercise, workout);
        } else if ((exercise.size() <= intCommand) & (intCommand < exercise.size() * 2)) {
            removeSet(exercise.getSet(intCommand - exercise.size()), exercise, workout);
        } else {
            System.out.println("Please provide a valid input");
            editExercise(exercise, workout);
        }
    }

    // MODIFIES: this
    // EFFECTS: changes workout name
    private void editSet(Set set, Exercise exercise, Workout workout) {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            System.out.println("\nSet " + Integer.toString(exercise.indexOf(set) + 1) + ": " + set.getSetInfo());
            editSetPrompts();
            displayExitPrompts();
            command = input.next();
            command = command.toLowerCase();

            keepGoing = false;
            processEditSetCommand(set, command, exercise, workout);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes workout from workouts
    private void removeSet(Set set, Exercise exercise, Workout workout) {
        int index = exercise.indexOf(set);
        exercise.removeSet(index);
        System.out.println("\nSet successfully removed");
        editExercise(exercise, workout);
    }

    //EFFECTS: displays prompts to select in editSet to the user
    private void editSetPrompts() {
        System.out.println("\nSelect one of the following options: ");
        System.out.println("\n 0 -> edit weight");
        System.out.println("\n 1 -> edit reps");
        System.out.println("\n 2 -> edit comment");
    }

    // EFFECTS: processes user command in editSet
    // Code attributed to TellerApp example
    private void processEditSetCommand(Set set, String command, Exercise exercise, Workout workout) {
        if (command.equals("b")) {
            editExercise(exercise, workout);
        } else if (command.equals("q")) {
            System.exit(0);
        }

        try {
            Integer.parseInt(command);
        } catch (NumberFormatException e) {
            System.out.println("Please provide a valid input");
            editSet(set, exercise, workout);
        }

        int intCommand = Integer.parseInt(command);
        if (intCommand == 0) {
            editSetWeight(set, exercise, workout);
        } else if (intCommand == 1) {
            editSetReps(set, exercise, workout);
        } else if (intCommand == 2) {
            editSetComment(set, exercise, workout);
        } else {
            System.out.println("Please provide a valid input");
            editSet(set, exercise, workout);
        }
    }

    // REQUIRES: input must be a non-negative integer
    // MODIFIES: this
    // EFFECTS: changes set reps
    private void editSetReps(Set set, Exercise exercise, Workout workout) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\nEnter the new reps of the set");
            int reps = Integer.parseInt(input.next());
            set.setReps(reps);
            System.out.println("\nReps changed to " + set.getReps());
            keepGoing = false;
            editSet(set, exercise, workout);
        }
    }

    // REQUIRES: input must be a non-negative integer
    // MODIFIES: this
    // EFFECTS: changes set weight
    private void editSetWeight(Set set, Exercise exercise, Workout workout) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\nEnter the new weight of the set");
            int weight = Integer.parseInt(input.next());
            set.setWeight(weight);
            System.out.println("\nWeight changed to " + set.getWeight());
            keepGoing = false;
            editSet(set, exercise, workout);
        }
    }

    // REQUIRES: input must be a non-negative integer
    // MODIFIES: this
    // EFFECTS: changes set weight
    private void editSetComment(Set set, Exercise exercise, Workout workout) {
        boolean keepGoing = true;

        while (keepGoing) {
            input.nextLine();
            System.out.println("\nEnter the new comment in the set");
            String comment = input.nextLine();
            set.setComment(comment);
            System.out.println("\nComment changed to " + set.getComment());
            keepGoing = false;
            editSet(set, exercise, workout);
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


}
