package ui.screens;

import model.Workout;
import model.WorkoutSet;
import ui.GUI;
import ui.buttons.BackButton;
import ui.buttons.additionalobjectbutton.ViewWorkoutButton;

import javax.swing.*;
import java.awt.*;

public class ViewWorkouts extends Screen {

    public ViewWorkouts(GUI gui, String cardName) {
        super(gui, gui.getWorkoutSet(), cardName);
        createWorkoutsPane();
    }

    @Override
    protected void initializePane() {
        super.initializePane();
        pane.setLayout(new GridLayout(1, 0, gui.getHorizontalGap(), gui.getVerticalGap()));
    }

    // MODIFIES: this
    // EFFECTS: creates the window where the user can view previous workouts
    private void createWorkoutsPane() {
        JScrollPane scrollPane = createScrollPane(pane);
        gui.getContainer().add(scrollPane, "view workouts");
        createViewWorkoutButtons();
    }

    // MODIFIES: this
    // EFFECTS: creates buttons corresponding to each workout in workoutSet and adds back button
    private void createViewWorkoutButtons() {
        JPanel workoutsArea = new JPanel();
        WorkoutSet workoutSet = gui.getWorkoutSet();

        workoutsArea.setLayout(new GridLayout(workoutSet.size() + 1, 0,
                gui.getHorizontalGap(), gui.getVerticalGap()));
        pane.add(workoutsArea, BorderLayout.NORTH);

        for (Workout workout : workoutSet.getWorkouts()) {
            new ViewWorkoutButton(gui, workoutsArea, workoutSet, workout);
        }

        new BackButton(gui, workoutsArea, workoutSet, "home");
    }


}
