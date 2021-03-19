package ui.screens;

import model.Workout;
import ui.GUI;
import ui.buttons.editfield.AddExerciseSubmitButton;
import ui.buttons.navigation.BackButton;

import javax.swing.*;

import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;

// class representing a screen where a user can add an exercise to a specific workout

public class AddExercise extends Screen {
    GroupLayout layout;

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
        layout = initializeGroupLayout(pane);
        createComponents(layout, (Workout) object);
        gui.getContainer().add(this.getPane(), "add exercise");
    }

    // MODIFIES: this
    // EFFECTS: creates components for the tab and organizes them into the group layout
    private void createComponents(GroupLayout layout, Workout workout) {
        JEditorPane nameLabel = textBox("Exercise Name: ");
        JEditorPane nameEntry = entryField();
        JButton backButton = new BackButton(gui, pane, "view workout").getButton();
        JButton submitButton = new AddExerciseSubmitButton(gui, pane, workout, nameEntry).getButton();

        setHorizontalGroup(layout, nameLabel, nameEntry, backButton, submitButton);

        setVerticalGroup(layout, nameLabel, nameEntry, backButton, submitButton);
    }

    // MODIFIES: layout
    // EFFECTS: organizes vertical grouping in group layout
    private void setVerticalGroup(GroupLayout layout, JEditorPane nameLabel, JEditorPane nameEntry, JButton backButton,
                                  JButton submitButton) {
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(nameLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(nameEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup()
                        .addComponent(submitButton)
                        .addComponent(backButton)));
    }

    // MODIFIES: layout
    // EFFECTS: organizes horizontal grouping in group layout
    private void setHorizontalGroup(GroupLayout layout, JEditorPane nameLabel, JEditorPane nameEntry,
                                    JButton backButton, JButton submitButton) {
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(nameLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(submitButton))
                .addGroup(layout.createParallelGroup()
                        .addComponent(nameEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(backButton)));
    }


}
