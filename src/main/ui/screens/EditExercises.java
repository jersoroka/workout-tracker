package ui.screens;

import model.Exercise;
import model.Workout;
import ui.GUI;
import ui.buttons.editfield.DeleteExerciseButton;
import ui.buttons.navigation.BackButton;
import ui.buttons.navigation.EditExerciseNameButton;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;

public class EditExercises extends Screen {
    private JTabbedPane tabbedPane;
    private static final int LABEL_WIDTH = WIDTH / 3;
    private static final int ENTRY_WIDTH = WIDTH / 2;
    private static final int TEXT_HEIGHT = HEIGHT / 21;
    private Font font = new Font("Dialog", Font.PLAIN, 18);

    public EditExercises(GUI gui, Object object) {
        super(gui, object);
    }

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
        for (Exercise exercise: exercises) {
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
    // EFFECTS: sets up group layout
    private GroupLayout initializeGroupLayout(JPanel parent) {
        GroupLayout layout = new GroupLayout(parent);
        parent.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        return layout;
    }

    // MODIFIES: this
    // EFFECTS: creates components for the tab and organizes them into the group layout
    private void createComponents(GroupLayout layout, JPanel parent, Exercise exercise) {
        JEditorPane nameEntry = entryField();
        JButton editNameButton = new EditExerciseNameButton(gui, pane, exercise, nameEntry, (Workout) object).getButton();
        JButton deleteExerciseButton = new DeleteExerciseButton(gui, parent, object, exercise).getButton();
        JButton backButton = new BackButton(gui, pane, "view workouts").getButton();

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(nameEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addComponent(editNameButton))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteExerciseButton)
                                .addComponent(backButton))
                ));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(nameEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(editNameButton))
                .addGroup(layout.createParallelGroup()
                        .addComponent(deleteExerciseButton)
                        .addComponent(backButton))
        );
    }

    // EFFECTS: creates user entry field
    private JEditorPane entryField() {
        JEditorPane field = new JEditorPane();
        field.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        field.setPreferredSize(new Dimension(ENTRY_WIDTH, TEXT_HEIGHT));
        field.setFont(font);
        return field;
    }

}
