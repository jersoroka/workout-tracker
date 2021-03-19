package ui.screens;

import ui.GUI;

// class representing a screen where a user can add an exercise to a specific workout

public class AddExercise extends Screen {

    // MODIFIES: this
    // EFFECTS: constructs a screen for adding a new exercise
    public AddExercise(GUI gui, Object object) {
        super(gui, object);
    }

    // MODIFIES: this, gui
    // EFFECTS: creates a window where the user can add an exercise
    @Override
    protected void initializePane() {
        super.initializePane();
        gui.getContainer().add(this.getPane(), "add workout");
    }
}
