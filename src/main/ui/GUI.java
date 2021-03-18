package ui;

import model.Exercise;
import model.Workout;
import model.WorkoutSet;
import ui.screens.*;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private static final int HEIGHT = 450;
    private static final int WIDTH = 600;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 10;
    private static GUI gui;

    private CardLayout cards;
    private Container container;
    private WorkoutSet workoutSet;

    public GUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            // use default look and feel if exception is thrown
        }
        initializeCardLayout();
        initializeFields();
        createHomeScreen();
        createAddWorkoutScreen();
        createViewWorkoutsScreen();
    }

    // MODIFIES: this
    // EFFECTS: creates the window where the user can add a workout
    private void createAddWorkoutScreen() {
        new AddWorkout(this);
    }

    // MODIFIES: this
    // EFFECTS: creates the window where the user can view previous workouts
    public void createViewWorkoutsScreen() {
        new ViewWorkouts(this);
    }

    // MODIFIES: this
    // EFFECTS: creates the window where the user can edit exercises in a workout
    public void createEditExercisesScreen(Workout workout) {
        new EditExercises(this, workout);
    }

    // MODIFIES: this
    // EFFECTS: creates the window where the user can view information about a specific workout
    public void createViewWorkoutScreen(Workout workout) {
        new ViewWorkout(this, workout);
    }


    // MODIFIES: this
    // EFFECTS: draws the JFrame window where the workout logger app will operate
    //          and populates the save and load buttons
    private void createHomeScreen() {
        new Home(this);
    }

    // MODIFIES: this
    // EFFECTS: creates the window where the user can edit a workouts name and date
    public void createEditNameAndDateScreen(Workout workout) {
        new EditNameAndDate(this, workout);
    }

    // MODIFIES: this
    // EFFECTS: draws the JFrame window which holds all the interfaces for the workout logger app
    private void initializeCardLayout() {
        container = getContentPane();
        cards = new CardLayout();
        container.setLayout(cards);
    }

    // MODIFIES: this
    // EFFECTS: instantiates frame, button, label, and panel
    private void initializeFields() {
        workoutSet = new WorkoutSet();
        createDefaultLegsWorkout();
        createDefaultBackWorkout();
        createEmptyTestWorkouts();
    }

    // EFFECTS: creates default back workout
    private void createDefaultBackWorkout() {
        workoutSet.addWorkout(2021, 2, 28, "back");
        Workout backWorkout = workoutSet.getWorkout(1);
        backWorkout.addExercise("rows");
        Exercise rows = backWorkout.getExercise(0);
        rows.addSet(10, 75, "fast reps");
        rows.addSet(12, 85, "");
    }

    // EFFECTS: creates empty test workouts
    private void createEmptyTestWorkouts() {
        workoutSet.addWorkout(2021, 7, 4, "test");
        workoutSet.addWorkout(2021, 7, 1, "test");
        workoutSet.addWorkout(2021, 3, 14, "test");
        workoutSet.addWorkout(2021, 7, 4, "test");
        workoutSet.addWorkout(2021, 7, 1, "test");
        workoutSet.addWorkout(2021, 3, 14, "test");
        workoutSet.addWorkout(2021, 7, 4, "test");
        workoutSet.addWorkout(2021, 7, 1, "test");
    }

    // MODIFIES: this
    // EFFECTS: creates default leg workout
    private void createDefaultLegsWorkout() {
        workoutSet.addWorkout(2021, 2, 27, "legs");
        Workout legsWorkout = workoutSet.getWorkout(0);
        legsWorkout.addExercise("front squats");
        Exercise frontSquats = legsWorkout.getExercise(0);
        frontSquats.addSet(10, 135, "warmup");
        frontSquats.addSet(10, 155, "");
        legsWorkout.addExercise("leg curls");
        Exercise legCurls = legsWorkout.getExercise(1);
        legCurls.addSet(20, 45, "");
    }

    // getters

    public CardLayout getCards() {
        return cards;
    }

    public Container getContainer() {
        return container;
    }

    public WorkoutSet getWorkoutSet() {
        return workoutSet;
    }

    public static void main(String[] args) {
        gui = new GUI();
        gui.setTitle("Workout Logger App");
        gui.setSize(WIDTH, HEIGHT);
        gui.setResizable(false);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
