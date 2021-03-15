package ui;

import model.WorkoutSet;
import ui.buttons.*;
import ui.buttons.Button;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;

public class WorkoutLoggerAppGUI extends JFrame {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 10;
    private static WorkoutLoggerAppGUI workoutLoggerAppGUI;

    private CardLayout cards;
    private JPanel homeScreen;
    private Container container;
    private WorkoutSet workoutSet;

    public WorkoutLoggerAppGUI() {
        initializeCardLayout();
        initializeFields();
        createHomeScreen();
        createAddWorkoutScreen();
        createViewWorkoutsScreen();
    }

    // MODIFIES: this
    // EFFECTS: creates the window where the user can add a workout
    private void createAddWorkoutScreen() {
        JPanel addWorkoutScreen = new JPanel();
        addWorkoutScreen.setLayout(new GridLayout(2, 0, HORIZONTAL_GAP, VERTICAL_GAP));
        addWorkoutScreen.setSize(WIDTH, HEIGHT);
        container.add(addWorkoutScreen, "add workout");
    }

    // MODIFIES: this
    // EFFECTS: creates the window where the user can view previous workouts
    private void createViewWorkoutsScreen() {
        JPanel viewWorkoutsScreen = new JPanel();
        viewWorkoutsScreen.setLayout(new GridLayout(2, 0, HORIZONTAL_GAP, VERTICAL_GAP));
        viewWorkoutsScreen.setSize(WIDTH, HEIGHT);
        container.add(viewWorkoutsScreen, "view workouts");
    }


    // MODIFIES: this
    // EFFECTS: draws the JFrame window where the workout logger app will operate
    //          and populates the save and load buttons
    private void createHomeScreen() {
        JPanel homeScreen = new JPanel();
        homeScreen.setLayout(new GridLayout(2, 0, HORIZONTAL_GAP, VERTICAL_GAP));
        homeScreen.setSize(WIDTH, HEIGHT);
        createHomeScreenWorkoutButtons(homeScreen);
        createPersistenceButtons(homeScreen);
        container.add(homeScreen, "home");
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
    }

    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates persistence buttons
    private void createPersistenceButtons(JPanel homeScreen) {
        JPanel persistenceArea = new JPanel();
        persistenceArea.setLayout(new GridLayout(2, 0, HORIZONTAL_GAP, VERTICAL_GAP));
        homeScreen.add(persistenceArea, BorderLayout.SOUTH);
        Button saveButton = new SaveButton(this, persistenceArea, workoutSet);
        Button loadButton = new LoadButton(this, persistenceArea, workoutSet);
    }

    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates the buttons on the home screen
    //          that correspond to workout options
    private void createHomeScreenWorkoutButtons(JPanel homeScreen) {
        JPanel homeArea = new JPanel();
        homeArea.setLayout(new GridLayout(2, 0, HORIZONTAL_GAP, VERTICAL_GAP));
        homeScreen.add(homeArea, BorderLayout.NORTH);
        Button addWorkout = new AddWorkoutButton(this, homeArea, workoutSet);
        Button viewWorkouts = new ViewWorkoutsButton(this, homeArea, workoutSet);
    }

    // getters

    public CardLayout getCards() {
        return cards;
    }

    public JPanel getHomeScreen() {
        return homeScreen;
    }

    public Container getContainer() {
        return container;
    }

    public WorkoutSet getWorkoutSet() {
        return workoutSet;
    }

    public static void main(String[] args) {
        workoutLoggerAppGUI = new WorkoutLoggerAppGUI();
        workoutLoggerAppGUI.setTitle("Workout Logger App");
        workoutLoggerAppGUI.setSize(800, 600);
        workoutLoggerAppGUI.setResizable(false);
        workoutLoggerAppGUI.setVisible(true);
        workoutLoggerAppGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
