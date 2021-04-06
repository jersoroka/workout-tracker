package ui.screens;

import model.Exercise;
import model.Workout;
import ui.GUI;
import ui.buttons.deletefield.DeleteExerciseButton;
import ui.buttons.navigation.BackButton;
import ui.buttons.editfield.EditExerciseNameButton;

import javax.swing.*;
import java.util.List;

import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;

// class representing a screen where a user can edit the exercises of a workout

public class EditExercises extends Screen {
    private JTabbedPane tabbedPane;

    // MODIFIES: this
    // EFFECTS: constructs a screen for editing exercises in a workout
    public EditExercises(GUI gui, Object object) {
        super(gui, object);
    }

    // MODIFIES: this
    // EFFECTS: creates a tabbed screen and adds card to container
    @Override
    protected void initializePane() {
        super.initializePane();
        initializeTabbedPane();
        gui.getContainer().add(tabbedPane, "edit exercises");
    }

    // MODIFIES: this
    // EFFECTS: sets up the tabbed pane for each exercise
    private void initializeTabbedPane() {
        List<Exercise> exercises = ((Workout) object).getExercises();

        tabbedPane = new JTabbedPane();
        for (Exercise exercise : exercises) {
            initializeExercisePane(exercise);
        }
    }

    // MODIFIES: this
    // EFFECTS: sets up a JScrollPane for each exercise
    private void initializeExercisePane(Exercise exercise) {
        JPanel exercisePane = new JPanel();
        initializeExercisePane(exercisePane, exercise);
        tabbedPane.addTab(exercise.getName(), exercisePane);
    }

    // MODIFIES: exercisePane
    // EFFECTS: adds labels, buttons, and entry fields for a specific exercise tab
    private void initializeExercisePane(JPanel parent, Exercise exercise) {
        GroupLayout layout = initializeGroupLayout(parent);
        createComponents(layout, parent, exercise);
    }

    // MODIFIES: this
    // EFFECTS: creates components for the tab and organizes them into the group layout
    private void createComponents(GroupLayout layout, JPanel parent, Exercise exercise) {
        JEditorPane nameEntry = entryField();
        JButton editNameButton = new EditExerciseNameButton(gui, pane, exercise, nameEntry,
                (Workout) object).getButton();
        JButton deleteExerciseButton = new DeleteExerciseButton(gui, parent, object, exercise).getButton();
        JButton backButton = new BackButton(gui, pane, "view workout").getButton();

        setHorizontalGroup(layout, nameEntry, editNameButton, deleteExerciseButton, backButton);
        setVerticalGroup(layout, nameEntry, editNameButton, deleteExerciseButton, backButton);
    }

    // MODIFIES: layout
    // EFFECTS: organizes components into vertical groups in layout
    private void setVerticalGroup(GroupLayout layout, JEditorPane nameEntry, JButton editNameButton,
                                  JButton deleteExerciseButton, JButton backButton) {
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(nameEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(editNameButton))
                .addGroup(layout.createParallelGroup()
                        .addComponent(deleteExerciseButton)
                        .addComponent(backButton)));
    }

    // MODIFIES: this
    // EFFECTS: organizes components into horizontal groups in layout
    private void setHorizontalGroup(GroupLayout layout, JEditorPane nameEntry, JButton editNameButton,
                                    JButton deleteExerciseButton, JButton backButton) {
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(nameEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addComponent(editNameButton))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteExerciseButton)
                                .addComponent(backButton))));
    }

}
