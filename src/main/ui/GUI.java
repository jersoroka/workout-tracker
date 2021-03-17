package ui;

import model.Exercise;
import model.Workout;
import model.WorkoutSet;
import ui.buttons.*;
import ui.buttons.Button;
import ui.buttons.BackButton;
import ui.buttons.additionalobjectbutton.ViewWorkoutButton;
import ui.buttons.additionalobjectbutton.ViewWorkoutsButton;
import ui.screens.AddWorkout;
import ui.screens.HomeScreen;
import ui.screens.ViewWorkout;
import ui.screens.ViewWorkouts;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private static final int HEIGHT = 1600;
    private static final int WIDTH = 2000;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 10;
    private static GUI gui;

    private CardLayout cards;
    private Container container;
    private WorkoutSet workoutSet;

    public GUI() {
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
    // EFFECTS: creates the window where the user can view information about a specific workout
    public void createViewWorkoutScreen(Workout workout) {
        new ViewWorkout(this, workout);
    }


    // MODIFIES: this
    // EFFECTS: draws the JFrame window where the workout logger app will operate
    //          and populates the save and load buttons
    private void createHomeScreen() {
        new HomeScreen(this);
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
        workoutSet.addWorkout(2021, 2, 27, "legs");
        Workout legsWorkout = workoutSet.getWorkout(0);
        legsWorkout.addExercise("front squats");
        Exercise frontSquats = legsWorkout.getExercise(0);
        frontSquats.addSet(10, 135, "warmup");
        frontSquats.addSet(10, 155, "");
        legsWorkout.addExercise("leg curls");
        Exercise legCurls = legsWorkout.getExercise(1);
        legCurls.addSet(20, 45, "");

        workoutSet.addWorkout(2021, 2, 28, "back");
        Workout backWorkout = workoutSet.getWorkout(1);
        backWorkout.addExercise("rows");
        Exercise rows = backWorkout.getExercise(0);
        rows.addSet(10, 75, "fast reps");
        rows.addSet(12, 85, "");

        workoutSet.addWorkout(2021, 7, 4, "test");
        workoutSet.addWorkout(2021, 7, 1, "test");
        workoutSet.addWorkout(2021, 3, 14, "test");
        workoutSet.addWorkout(2021, 7, 4, "test");
        workoutSet.addWorkout(2021, 7, 1, "test");
        workoutSet.addWorkout(2021, 3, 14, "test");
        workoutSet.addWorkout(2021, 7, 4, "test");
        workoutSet.addWorkout(2021, 7, 1, "test");
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
        gui.setSize(800, 600);
        gui.setResizable(false);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
