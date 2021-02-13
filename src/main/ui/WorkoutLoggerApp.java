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
        String command;

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
        System.out.println("v -> view, edit, or remove a workout");
        System.out.println("a -> add a workout");
        System.out.println("q -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command in homeScreen
    // Code attributed to TellerApp example
    private void processHomeScreenCommand(String command) {
        if (command.equals("v")) {
            viewWorkouts();
        } else if (command.equals("a")) {
            addWorkout();
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
        String command;

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
            System.out.println(i + " -> " + name + ": " + date);
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
        System.out.println("q -> quit");
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    // Code attributed to TellerApp example
    private void viewWorkout(Workout workout) {
        boolean keepGoing = true;
        String command;

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
        System.out.println("Date of Workout: " + workout.getDate().formatToString());
        System.out.println("Workout Name: " + workout.getName());
        System.out.println("Exercises performed: ");
        for (Exercise exercise : workout.getExercises()) {
            System.out.println("\n" + exercise.getExerciseInfo());
        }
    }

    //EFFECTS: displays prompts to select in viewWorkout to the user
    private void viewWorkoutPrompts(Workout workout) {
        System.out.println("\nSelect one of the following options: ");
        System.out.println("\nEdit Exercises:");
        for (int i = 0; i < workout.getExercises().size(); i++) {
            System.out.println(i + " -> edit " + workout.getExercise(i).getName());
        }
        System.out.println("\nRemove Exercises:");
        for (int i = 0; i < workout.getExercises().size(); i++) {
            int z = i + workout.size();
            System.out.println(z + " -> remove " + workout.getExercise(i).getName());
        }
        System.out.println("\nEdit Workout:");
        System.out.println(workout.size() * 2 + " -> add exercise");
        System.out.println((workout.size() * 2 + 1) + " -> edit workout name");
        System.out.println(((workout.size() * 2) + 2) + " -> edit workout date");
        System.out.println(((workout.size() * 2) + 3) + " -> remove workout");
    }

    // EFFECTS: processes user command in viewWorkout
    // Code attributed to TellerApp example
    private void processViewWorkoutCommand(String command, Workout workout) {
        switch (command) {
            case "b":
                viewWorkouts();
                break;
            case "q":
                System.exit(0);
            case "a":
                addExercise(workout);
                break;
        }

        try {
            Integer.parseInt(command);
        } catch (NumberFormatException e) {
            System.out.println("Please provide a valid input");
            viewWorkout(workout);
        }

        processViewWorkoutCommandNumberedOptions(Integer.parseInt(command), workout);
    }

    // MODIFIES: this
    // EFFECTS: adds an exercise to the workout
    private void addExercise(Workout workout) {
        boolean keepGoing = true;

        while (keepGoing) {
            input.nextLine();
            System.out.println("\nEnter the name of the new exercise");
            String name = input.nextLine();
            workout.addExercise(name);
            Exercise exercise = workout.getExercise(workout.size() - 1);
            System.out.println(name + " has been added to the workout");

            System.out.println("Would you like to add sets to the exercise? Enter y for yes or n for no");
            String command = input.next();
            keepGoing = false;
            processAddExerciseCommands(command, exercise, workout);
        }
    }

    // EFFECTS: processes user commands in addExercise
    private void processAddExerciseCommands(String command, Exercise exercise, Workout workout) {
        if (command.equals("y")) {
            addSet(exercise, workout);
        } else if (command.equals("n")) {
            viewWorkout(workout);
        } else {
            System.out.println("Please provide a valid input");
            processAddExerciseCommands(command, exercise, workout);
        }
    }

    // EFFECTS: process user command in viewWorkout with numbers as options
    // Code attributed to TellerApp example
    private void processViewWorkoutCommandNumberedOptions(int command, Workout workout) {
        if ((0 <= command) & (command < workout.size())) {
            editExercise(workout.getExercise(command), workout);
        } else if ((workout.size() <= command) & (command < workout.size() * 2)) {
            removeExercise(workout.getExercise(command - workout.size()), workout);
        } else if (command == (workout.size() * 2)) {
            addExercise(workout);
        } else if (command == (workout.size() * 2 + 1)) {
            editWorkoutName(workout);
        } else if (command == ((workout.size() * 2) + 2)) {
            editWorkoutDate(workout);
            viewWorkout(workout);
        } else if (command == ((workout.size() * 2) + 3)) {
            removeWorkout(workout);
        }
    }


    // MODIFIES: this
    // EFFECTS: changes workout name
    private void editWorkoutName(Workout workout) {
        boolean keepGoing = true;
        String command;

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
            System.out.println("\nEnter the year the workout is set");
            String year = input.next();
            System.out.println("\nEnter the month of the workout as a number. For example, May is 5 and July is 7");
            String month = input.next();
            System.out.println("Enter the day of the workout");
            String day = input.next();

            if (isNotOnlyIntegersInString(year) | isNotOnlyIntegersInString(month) | isNotOnlyIntegersInString(day)) {
                System.out.println("Please only enter positive integers");
            } else {
                Date date = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                if (workout.setDate(date)) {
                    System.out.println("\nDate changed to " + date.formatToString());
                    keepGoing = false;
                } else {
                    System.out.println("\nThat date is not valid. Please enter a a valid date");
                }
            }
        }
    }

    // EFFECTS: produces true if string does not contain only integers, false otherwise
    private boolean isNotOnlyIntegersInString(String string) {
        try {
            int intString = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
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
        String command;

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
            System.out.println(i + " -> edit Set " + (i + 1));
        }
        for (int i = 0; i < exercise.size(); i++) {
            System.out.println((i + exercise.size())
                    + " -> remove Set " + (i + 1));
        }
        System.out.println(exercise.size() * 2 + " -> add Set");
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
        } else if (intCommand == (exercise.size() * 2)) {
            addSet(exercise, workout);
        } else {
            System.out.println("Please provide a valid input");
            editExercise(exercise, workout);
        }
    }

    // MODIFIES: this
    // EFFECTS: adds set to sets
    private void addSet(Exercise exercise, Workout workout) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\nWhat weight was used? Enter 0 if not applicable.");
            String weight = input.next();

            System.out.println("\nHow many reps were performed? Enter 0 if not applicable.");
            String reps = input.next();
            if (isNotOnlyIntegersInString(weight) | isNotOnlyIntegersInString(reps)) {
                System.out.println("Please enter only non-negative integers");
                addSet(exercise, workout);
            }

            input.nextLine();
            System.out.println("Enter a comment. Leave this field blank if there are no comments");
            String comment = input.nextLine();

            exercise.addSet(Integer.parseInt(reps), Integer.parseInt(weight), comment);
            System.out.println("Added new set to " + workout.getName());
            keepGoing = false;
            viewWorkout(workout);
        }
    }


    // MODIFIES: this
    // EFFECTS: changes workout name
    private void editSet(Set set, Exercise exercise, Workout workout) {
        boolean keepGoing = true;
        String command;

        while (keepGoing) {
            System.out.println("\nSet " + (exercise.indexOf(set) + 1) + ": " + set.getSetInfo());
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
        System.out.println("0 -> edit weight");
        System.out.println("1 -> edit reps");
        System.out.println("2 -> edit comment");
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
        processEditWorkoutCommandNumberedOptions(intCommand, set, exercise, workout);

    }

    // EFFECTS: process user command in editWorkout with numbers as options
    // Code attributed to TellerApp example
    private void processEditWorkoutCommandNumberedOptions(int command, Set set, Exercise exercise, Workout workout) {
        if (command == 0) {
            editSetWeight(set, exercise, workout);
        } else if (command == 1) {
            editSetReps(set, exercise, workout);
        } else if (command == 2) {
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


    private void addWorkout() {
        boolean keepGoing = true;

        while (keepGoing) {
            input.nextLine();
        }
    }




}
