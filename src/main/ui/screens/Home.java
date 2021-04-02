package ui.screens;

import ui.GUI;
import ui.buttons.navigation.AddWorkoutButton;
import ui.buttons.Button;
import ui.buttons.persistence.LoadButton;
import ui.buttons.persistence.SaveButton;
import ui.buttons.navigation.ViewWorkoutsButton;

import javax.swing.*;
import java.awt.*;

// class representing the home screen
public class Home extends Screen {

    // MODIFIES: this
    // EFFECTS: makes a home screen
    public Home(GUI gui) {
        super(gui, gui.getWorkoutSet());
        createWorkoutButtons();
        createPersistenceButtons();
    }

    // MODIFIES: this
    // EFFECTS: adds a new card to this and initializes the layout
    @Override
    protected void initializePane() {
        super.initializePane();
        gui.getContainer().add(this.getPane(), "home");
        pane.setLayout(new GridLayout(4, 0, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates persistence buttons
    private void createPersistenceButtons() {
        JPanel persistenceArea = new JPanel();
        persistenceArea.setLayout(new GridLayout(2, 0, HORIZONTAL_GAP, VERTICAL_GAP));
        pane.add(persistenceArea);
        Button saveButton = new SaveButton(gui, persistenceArea);
        Button loadButton = new LoadButton(gui, persistenceArea);
    }

    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates the buttons on the home screen
    //          that correspond to workout options
    private void createWorkoutButtons() {
        JPanel homeArea = new JPanel();
        homeArea.setLayout(new GridLayout(2, 0, HORIZONTAL_GAP, VERTICAL_GAP));
        pane.add(homeArea);
        Button addWorkout = new AddWorkoutButton(gui, homeArea);
        Button viewWorkouts = new ViewWorkoutsButton(gui, homeArea);
    }
}
