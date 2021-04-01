package ui;

import model.Exercise;
import model.Workout;
import model.WorkoutSet;
import ui.screens.*;

import javax.swing.*;
import java.awt.*;

// class representing the graphical user interface for a workout logger

public class GUI extends JFrame {
    private static final int HEIGHT = 450;
    private static final int WIDTH = 600;

    private CardLayout cards;
    private Container container;
    private WorkoutSet workoutSet;

    public GUI() {
        initializeLookAndFeel();
        initializeCardLayout();
        initializeFields();
        createHomeScreen();
        createAddWorkoutScreen();
        createViewWorkoutsScreen();
    }

    // MODIFIES: this
    // EFFECTS: initializes the look and feel of the GUI
    private void initializeLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            // use default look and feel if exception is thrown
        }

        setTitle("Workout Logger App");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // MODIFIES: this
    // EFFECTS: draws the JFrame window which holds all the interfaces for the workout logger app
    private void initializeCardLayout() {
        container = getContentPane();
        cards = new CardLayout();
        container.setLayout(cards);
    }

    // MODIFIES: this
    // EFFECTS: instantiates frame, button, label, panel, and default workouts
    private void initializeFields() {
        workoutSet = new WorkoutSet();
    }

    // MODIFIES: this
    // EFFECTS: draws the JFrame window where the workout logger app will operate
    //          and populates the save and load buttons
    private void createHomeScreen() {
        new Home(this);
    }

    // MODIFIES: this
    // EFFECTS: creates the window where the user can add a workout
    public void createAddWorkoutScreen() {
        new AddWorkout(this);
    }

    // MODIFIES: this
    // EFFECTS: creates the window where the user can view previous workouts
    public void createViewWorkoutsScreen() {
        new ViewWorkouts(this);
    }

    // MODIFIES: this
    // EFFECTS: creates the window where the user can add an exercise to a workout
    public void createAddExerciseScreen(Workout workout) {
        new AddExercise(this, workout);
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
    // EFFECTS: creates the window where the user can edit a workouts name and date
    public void createEditNameAndDateScreen(Workout workout) {
        new EditNameAndDate(this, workout);
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

    // setters

    public void setWorkoutSet(WorkoutSet workoutSet) {
        this.workoutSet = workoutSet;
    }

    public static void main(String[] args) {
        new GUI();
    }
}
