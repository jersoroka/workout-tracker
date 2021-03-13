package ui;

import model.WorkoutSet;
import ui.buttons.*;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.*;

public class WorkoutLoggerAppGUI extends JFrame {
    private WorkoutSet workoutSet;


    public WorkoutLoggerAppGUI() {
        super("Workout Logger App");
        initializeFields();
        initializeGraphics();
    }

    // MODIFIES: this
    // EFFECTS: instantiates frame, button, label, and panel
    private void initializeFields() {
        workoutSet = new WorkoutSet();
    }

    // MODIFIES: this
    // EFFECTS: draws the JFrame window where the workout logger app will operate
    //          and populates the save and load buttons
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(800, 600));
        createHomeMenuButtons();
        createPersistenceButtons();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // not sure what this one does
        setVisible(true);
    }

    private void createHomeMenuButtons() {
        JPanel homeArea = new JPanel();
        homeArea.setLayout(new GridLayout(0, 1));
        homeArea.setSize(new Dimension(0, 0));
        add(homeArea, BorderLayout.CENTER);

        Button addWorkout = new AddWorkoutButton(homeArea, workoutSet);
        Button viewWorkouts = new ViewWorkoutsButton(homeArea, workoutSet);
    }

    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates persistence buttons
    private void createPersistenceButtons() {
        JPanel persistenceArea = new JPanel();
        persistenceArea.setLayout(new GridLayout(0, 1));
        persistenceArea.setSize(new Dimension(0, 0));
        add(persistenceArea, BorderLayout.SOUTH);

        Button saveButton = new SaveButton(persistenceArea, workoutSet);
        Button loadButton = new LoadButton(persistenceArea, workoutSet);
    }

    public static void main(String[] args) {
        new WorkoutLoggerAppGUI();
    }
}
