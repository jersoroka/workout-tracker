package ui;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WorkoutLoggerApp {
    private WorkoutSet workoutSet;
    private Scanner input;

    // EFFECTS: runs the workout logger app
    public WorkoutLoggerApp() {
        runWorkoutLogger();
    }

    // EFFECTS: processes user input
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
    // EFFECTS: adds a push workout to workouts
    private void addPushWorkout() {
        workoutSet.addWorkout(2021, 2, 1, "push");
        Workout push = workoutSet.getWorkout(0);
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
    // EFFECTS: adds a legs workout to workouts
    private void addLegsWorkout() {
        workoutSet.addWorkout(2021, 2, 3, "legs");
        Workout legs = workoutSet.getWorkout(1);
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
    // EFFECTS: processes user inputs
    private void homeScreen() {
        boolean keepGoing = true;
        String command;

        while (keepGoing) {
            displayHomeScreenPrompts();
            command = input.next();
            command = command.toLowerCase();

            processExitPrompt(command);
            keepGoing = false;
            processHomeScreenCommand(command);
        }
    }

    // EFFECTS: displays prompts to enter in homeScreen
    private void displayHomeScreenPrompts() {
        System.out.println("\nSelect from:");
        System.out.println("v -> view, edit, or remove a workout");
        System.out.println("a -> add a workout");
        System.out.println("q -> quit");
    }

    // EFFECTS: processes user command in homeScreen
    private void processHomeScreenCommand(String command) {
        if (command.equals("v")) {
            viewWorkouts();
        } else if (command.equals("a")) {
            addWorkout();
        } else {
            invalidInput();
            homeScreen();
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void viewWorkouts() {
        String command;
        boolean keepGoing = true;

        List<Integer> workoutIndices = new ArrayList<>();
        for (int i = 0; i < workoutSet.size(); i++) {
            workoutIndices.add(i);
        }
        while (keepGoing) {
            displayWorkoutsPrompts();
            displayExitAndBackPrompts();
            command = input.next();
            command = command.toLowerCase();

            processExitPrompt(command);
            if (processBackPrompt(command)) {
                keepGoing = false;
                homeScreen();
            } else {
                processViewWorkoutsCommand(command, workoutIndices);
            }
        }
    }

    // EFFECTS: displays menu of workouts to user
    private void displayWorkoutsPrompts() {
        if (workoutSet.size() == 0) {
            System.out.println("No workouts completed");
        } else {
            System.out.println("\nSelect one of the following workouts:");
            for (int i = 0; i < workoutSet.size(); i++) {
                String date = workoutSet.getWorkout(i).getDate().formatToString();
                String name = workoutSet.getWorkout(i).getName();
                System.out.println(i + " -> " + name + ": " + date);
            }
        }
    }

    // EFFECTS: processes user command in viewWorkouts
    private void processViewWorkoutsCommand(String command, List<Integer> workoutIndices) {
        if (isOnlyIntegers(command) & (0 <= Integer.parseInt(command))
                & Integer.parseInt(command) < workoutSet.size()) {
            int intCommand = Integer.parseInt(command);
            if (workoutIndices.contains(intCommand)) {
                viewWorkout(workoutSet.getWorkout(intCommand));
            }
        } else {
            invalidInput();
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void viewWorkout(Workout workout) {
        String command;
        boolean keepGoing = true;

        while (keepGoing) {
            viewWorkoutSummary(workout);
            viewWorkoutPrompts(workout);
            displayExitAndBackPrompts();
            command = input.next();
            command = command.toLowerCase();

            processExitPrompt(command);
            if (processBackPrompt(command)) {
                keepGoing = false;
                homeScreen();
            } else if (command.equals(Integer.toString((workout.size() * 2) + 3))) {
                removeWorkout(workout);
                keepGoing = false;
                viewWorkouts();
            } else {
                processViewWorkoutCommand(command, workout);
            }
        }
    }

    // EFFECTS: produces information on the workout
    private void viewWorkoutSummary(Workout workout) {
        System.out.println("\nBelow is a summary of the selected workout: ");
        System.out.println("Date of Workout: " + workout.getDate().formatToString());
        System.out.println("Workout Name: " + workout.getName());
        if (workout.size() == 0) {
            System.out.println("No exercises completed");
        } else {
            System.out.println("\nExercises performed: ");
            for (Exercise exercise : workout.getExercises()) {
                System.out.println("\n" + exercise.getExerciseInfo());
            }
        }
    }

    //EFFECTS: displays prompts to select in viewWorkout to the user
    private void viewWorkoutPrompts(Workout workout) {
        System.out.println("\nSelect one of the following options: ");
        if (workout.size() > 0) {
            System.out.println("\nEdit Exercises:");
            for (int i = 0; i < workout.getExercises().size(); i++) {
                System.out.println(i + " -> edit " + workout.getExercise(i).getName());
            }
            System.out.println("\nRemove Exercises:");
            for (int i = 0; i < workout.getExercises().size(); i++) {
                int z = i + workout.size();
                System.out.println(z + " -> remove " + workout.getExercise(i).getName());
            }
        }
        System.out.println("\nEdit Workout:");
        System.out.println(workout.size() * 2 + " -> add exercise");
        System.out.println((workout.size() * 2 + 1) + " -> edit workout name");
        System.out.println(((workout.size() * 2) + 2) + " -> edit workout date");
        System.out.println(((workout.size() * 2) + 3) + " -> remove workout");
    }

    // EFFECTS: processes user command in viewWorkout
    private void processViewWorkoutCommand(String command, Workout workout) {
        if (isOnlyIntegers(command)) {
            int intCommand = Integer.parseInt(command);
            if ((0 <= intCommand) & (intCommand < workout.size())) {
                editExercise(workout.getExercise(intCommand), workout);
            } else if ((workout.size() <= intCommand) & (intCommand < workout.size() * 2)) {
                removeExercise(workout.getExercise(intCommand - workout.size()), workout);
            } else if (intCommand == (workout.size() * 2)) {
                addExercise(workout);
            } else if (intCommand == (workout.size() * 2 + 1)) {
                setWorkoutName(workout);
            } else if (intCommand == ((workout.size() * 2) + 2)) {
                setWorkoutDate(workout);
            }
        } else {
            invalidInput();
        }
    }


    // MODIFIES: this, workout
    // EFFECTS: adds an exercise to the workout
    private void addExercise(Workout workout) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\nEnter the name of the new exercise");
            String name = input.useDelimiter("\\n").next();
            if (isNotOnlyWhitespace(name)) {
                workout.addExercise(name);
                Exercise exercise = workout.getExercise(workout.size() - 1);
                System.out.println(name + " has been added to the workout");
                addSetToExercise(exercise, workout);
                keepGoing = false;
            } else {
                invalidMinimumCharacterInput();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: asks the user if they would like to add sets to an exercise and directs to the appropriate menu
    private void addSetToExercise(Exercise exercise, Workout workout) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\nWould you like to add a set to this exercise? Enter y for yes and n for no");
            String command = input.next();

            if ((!command.equals("y") & !command.equals("n"))) {
                invalidInput();
            } else if (command.equals("y")) {
                addSet(exercise, workout);
            } else {
                keepGoing = false;
            }
        }
    }

    // MODIFIES: this, workout
    // EFFECTS: sets workout name
    private void setWorkoutName(Workout workout) {
        boolean keepGoing = true;
        String command;

        while (keepGoing) {
            System.out.println("\nEnter the new name of the workout");
            command = input.useDelimiter("\\n").next();
            if (isNotOnlyWhitespace(command)) {
                command = command.toLowerCase();
                workout.setName(command);
                System.out.println("\nWorkout name set to " + workout.getName());
                workout.setName(command);
                keepGoing = false;
            } else {
                invalidMinimumCharacterInput();
            }
        }
    }

    // REQUIRES: workout contains exercise
    // MODIFIES: workout
    // EFFECTS: removes exercise from workout
    private void removeExercise(Exercise exercise, Workout workout) {
        int index = workout.indexOf(exercise);
        String exerciseInfo = exercise.getName();
        workout.removeExercise(index);
        System.out.println(exerciseInfo + " successfully removed");
    }

    // MODIFIES: this, workout
    // EFFECTS: changes workout date
    private void setWorkoutDate(Workout workout) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\nEnter the year the workout is set");
            String year = input.next();
            System.out.println("Enter the month of the workout as a number. For example, May is 5 and July is 7");
            String month = input.next();
            System.out.println("Enter the day of the workout");
            String day = input.next();

            if (!isOnlyIntegers(year) | !isOnlyIntegers(month) | !isOnlyIntegers(day)) {
                System.out.println("Please only enter positive integers");
            } else {
                Date date = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                if (workout.setDate(date)) {
                    System.out.println("\nDate set to " + date.formatToString());
                    keepGoing = false;
                } else {
                    System.out.println("\nThat date is not valid. Please enter a a valid date");
                }
            }
        }
    }

    // REQUIRES: workoutSet contains workout
    // MODIFIES: this
    // EFFECTS: removes workout from workouts
    private void removeWorkout(Workout workout) {
        int index = workoutSet.indexOf(workout);
        String workoutInfo = workout.getName() + " on " + workout.getDate().formatToString();
        workoutSet.removeWorkout(index);
        System.out.println("\n" + workoutInfo + " successfully removed");
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void editExercise(Exercise exercise, Workout workout) {
        String command;

        while (true) {
            System.out.println("\n" + exercise.getExerciseInfo());
            editExercisePrompts(exercise);
            displayExitAndBackPrompts();
            command = input.next();
            command = command.toLowerCase();

            processExitPrompt(command);
            if (processBackPrompt(command)) {
                break;
            } else {
                processEditExerciseCommand(command, exercise, workout);
            }
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
    private void processEditExerciseCommand(String command, Exercise exercise, Workout workout) {
        if (isOnlyIntegers(command)) {
            int intCommand = Integer.parseInt(command);
            if ((0 <= intCommand) & (intCommand < exercise.size())) {
                editSet(exercise.getSet(intCommand), exercise);
            } else if ((exercise.size() <= intCommand) & (intCommand < exercise.size() * 2)) {
                removeSet(exercise.getSet(intCommand - exercise.size()), exercise, workout);
            } else if (intCommand == (exercise.size() * 2)) {
                addSet(exercise, workout);
                viewWorkout(workout);
            }
        } else {
            invalidInput();
        }
    }

    // MODIFIES: exercise
    // EFFECTS: adds set to exercise
    private void addSet(Exercise exercise, Workout workout) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\nWhat weight was used? Enter 0 if not applicable.");
            String weight = input.next();

            System.out.println("How many reps were performed? Enter 0 if not applicable.");
            String reps = input.next();
            if (!isOnlyIntegers(weight) | !isOnlyIntegers(reps)
                    | (Integer.parseInt(reps) < 0) | (Integer.parseInt(weight) < 0)) {
                System.out.println("Please enter only non-negative integers");
            } else {
                System.out.println("Enter a comment. Leave this field blank if there are no comments");
                String comment = input.useDelimiter("\\n").next();

                exercise.addSet(Integer.parseInt(reps), Integer.parseInt(weight), comment);
                System.out.println("Added new set to " + workout.getName());
                keepGoing = false;
            }
        }
    }


    // MODIFIES: workout
    // EFFECTS: changes workout name
    private void editSet(Set set, Exercise exercise) {
        String command;

        while (true) {
            System.out.println("\nSet " + (exercise.indexOf(set) + 1) + ": " + set.getSetInfo());
            editSetPrompts();
            displayExitAndBackPrompts();
            command = input.next();
            command = command.toLowerCase();

            processExitPrompt(command);
            if (processBackPrompt(command)) {
                break;
            } else {
                processEditSetCommand(set, command);
            }
        }
    }

    // REQUIRES: exercise contains set
    // MODIFIES: this
    // EFFECTS: removes workout from workouts
    private void removeSet(Set set, Exercise exercise, Workout workout) {
        int index = exercise.indexOf(set);
        exercise.removeSet(index);
        System.out.println("\nSet successfully removed");
    }

    //EFFECTS: displays prompts to select in editSet to the user
    private void editSetPrompts() {
        System.out.println("\nSelect one of the following options: ");
        System.out.println("0 -> edit weight");
        System.out.println("1 -> edit reps");
        System.out.println("2 -> edit comment");
    }

    // EFFECTS: processes user command in editSet
    private void processEditSetCommand(Set set, String command) {
        if (isOnlyIntegers(command)) {
            if (command.equals(Integer.toString(0))) {
                setWeight(set);
            } else if (command.equals(Integer.toString(1))) {
                setReps(set);
            } else if (command.equals(Integer.toString(2))) {
                setComment(set);
            }
        } else {
            invalidInput();
        }
    }

    // MODIFIES: set
    // EFFECTS: changes set reps
    private void setReps(Set set) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\nEnter the new reps of the set");
            String reps = input.next();
            if (isOnlyIntegers(reps) & (Integer.parseInt(reps) >= 0)) {
                set.setReps(Integer.parseInt(reps));
                System.out.println("\nReps changed to " + set.getReps());
                keepGoing = false;
            } else {
                invalidNegativeInput();
            }
        }
    }

    // MODIFIES: set
    // EFFECTS: changes set weight
    private void setWeight(Set set) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\nEnter the new weight of the set");
            String weight = input.next();
            if (isOnlyIntegers(weight) & (Integer.parseInt(weight) >= 0)) {
                set.setWeight(Integer.parseInt(weight));
                System.out.println("\nWeight changed to " + set.getWeight());
                keepGoing = false;
            } else {
                invalidNegativeInput();
            }
        }
    }

    // MODIFIES: set
    // EFFECTS: changes set comment
    private void setComment(Set set) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\nEnter the new comment in the set");
            String comment = input.useDelimiter("\\n").next();
            set.setComment(comment);
            System.out.println("\nComment changed to " + set.getComment());
            keepGoing = false;
        }
    }

    // MODIFIES: this
    // EFFECTS: adds workout to workoutSet
    private void addWorkout() {
        boolean keepGoing = true;
        Date date = new Date(2021, 1, 1);
        Workout workout = new Workout(date, "default");

        while (keepGoing) {
            setWorkoutName(workout);
            setWorkoutDate(workout);
            workoutSet.addWorkout(workout);
            keepGoing = false;
            System.out.println("\nWorkout name set to " + workout.getName());
            viewWorkout(workout);
        }
    }

    // EFFECTS: produces true if string contains only integer characters, false otherwise
    private boolean isOnlyIntegers(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // EFFECTS: produces true if the string contains at least one non-whitespace character, false otherwise
    private boolean isNotOnlyWhitespace(String command) {
        return Pattern.matches("(.*[A-Za-z0-9]+.*)+", command);
    }

    // EFFECTS: displays prompts to either go back to the previous screen or quit to user
    private void displayExitAndBackPrompts() {
        System.out.println("\nb -> back");
        System.out.println("q -> quit");
    }

    // EFFECTS: if the user inputted "q", exit the program
    private void processExitPrompt(String command) {
        if (command.equals("q")) {
            System.exit(0);
        }
    }

    // EFFECTS: returns true if the user inputted "b", otherwise returns false
    private boolean processBackPrompt(String command) {
        return (command.equals("b"));
    }


    // EFFECTS: prints message to user that the input is invalid
    private void invalidInput() {
        System.out.println("Please provide a valid input");
    }

    // EFFECTS: prints message to user that the input is invalid because it is negative
    private void invalidNegativeInput() {
        System.out.println("Please provide only non-negative inputs");
    }

    // EFFECTS: prints message to user that the input is invalid because it does not contain at least one character
    private void invalidMinimumCharacterInput() {
        System.out.println("Please provide an input with at least one letter or number");
    }


}
