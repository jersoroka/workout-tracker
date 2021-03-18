package ui.screens;

import model.Exercise;
import model.Workout;
import ui.GUI;
import ui.buttons.navigation.BackButton;
import ui.buttons.editfield.DeleteWorkoutButton;
import ui.buttons.navigation.AddExerciseButton;
import ui.buttons.editfield.EditExerciseButton;
import ui.buttons.editfield.EditExercisesButton;
import ui.buttons.editfield.EditNameAndDateButton;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.List;

import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.JList.VERTICAL;
import static javax.swing.SwingConstants.HORIZONTAL;

public class ViewWorkout extends Screen {
    private static final int LABEL_WIDTH = WIDTH / 3;
    private static final int ENTRY_WIDTH = WIDTH / 2;
    private static final int TEXT_HEIGHT = HEIGHT / 21;
    private Font font = new Font("Dialog", Font.PLAIN, 16);
    private GroupLayout layout;
    Workout workout = (Workout) object;

    // EFFECTS: constructs window to view a specific workout
    public ViewWorkout(GUI gui, Object object) {
        super(gui, object);
        createComponents();
    }

    // MODIFIES: this, gui
    // EFFECTS: creates the window where the user can view a specific workout
    @Override
    protected void initializePane() {
        super.initializePane();
        gui.getContainer().add(this.getPane(), "view workout");
        initializeGroupLayout();
    }

    // MODIFIES: this
    // EFFECTS: sets up group layout
    private void initializeGroupLayout() {
        layout = new GroupLayout(pane);
        pane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
    }

    // MODIFIES: this
    // EFFECTS: creates components for the window and organizes them into the group layout
    private void createComponents() {
        JScrollPane summary = createWorkoutSummary();
        JEditorPane label = label();
        JButton addExerciseButton = new AddExerciseButton(gui, pane, workout).getButton();
        JButton editNameAndDateButton = new EditNameAndDateButton(gui, pane, workout).getButton();
        JButton editExercisesButton = new EditExercisesButton(gui, pane, workout).getButton();
        JButton deleteWorkoutButton = new DeleteWorkoutButton(gui, pane, workout).getButton();
        JButton backButton = new BackButton(gui, pane, "home").getButton();

        setHorizontalGroup(summary, label, addExerciseButton, editNameAndDateButton, editExercisesButton,
                deleteWorkoutButton, backButton);
        setVerticalGroup(summary, label, addExerciseButton, editNameAndDateButton, editExercisesButton,
                deleteWorkoutButton, backButton);

        layout.linkSize(HORIZONTAL, addExerciseButton, editNameAndDateButton, editExercisesButton,
                deleteWorkoutButton, backButton);
        layout.linkSize(VERTICAL, addExerciseButton, editNameAndDateButton, editExercisesButton,
                deleteWorkoutButton, backButton);
    }

    // MODIFIES: this
    // EFFECTS: organizes vertical grouping in group layout
    private void setVerticalGroup(JScrollPane summary, JEditorPane label, JButton addExerciseButton,
                                  JButton editNameAndDateButton, JButton editExercisesButton,
                                  JButton deleteWorkoutButton, JButton backButton) {
        layout.setVerticalGroup((layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(summary)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(label, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addComponent(addExerciseButton)
                                .addComponent(editNameAndDateButton)
                                .addComponent(editExercisesButton)
                                .addComponent(deleteWorkoutButton)
                                .addComponent(backButton)))));
    }

    // MODIFIES: this
    // EFFECTS: organizes horizontal grouping in group layout
    private void setHorizontalGroup(JScrollPane summary, JEditorPane label, JButton addExerciseButton,
                                    JButton editNameAndDateButton, JButton editExercisesButton,
                                    JButton deleteWorkoutButton, JButton backButton) {
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(summary)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(label, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(addExerciseButton)
                        .addComponent(editNameAndDateButton)
                        .addComponent(editExercisesButton)
                        .addComponent(deleteWorkoutButton)
                        .addComponent(backButton)
                ));
    }

    // MODIFIES: this
    // EFFECTS: creates an uneditable text box displaying a summary of the workout
    public JScrollPane createWorkoutSummary() {
        JEditorPane summary = new JEditorPane();
        summary.setFont(new Font("Dialog", Font.PLAIN, 14));
        summary.setEditable(false);
        Workout workout = (Workout) object;

        summary.setText("Workout Information: \n\nDate of workout: " + workout.getDate().formatToString()
                + "\n\nWorkout name: " + workout.getName() + "\n\n" + createExerciseSummary());

        JScrollPane scrollPane = createScrollPane(summary);

        pane.add(scrollPane);

        return scrollPane;
    }

    // EFFECTS: returns a string displaying a summary of exercise information
    public String createExerciseSummary() {
        if (workout.size() == 0) {
            return "No exercises completed.";
        } else {
            StringBuilder exerciseInfo = new StringBuilder();
            for (Exercise e : workout.getExercises()) {
                exerciseInfo.append(e.getExerciseInfo()).append("\n\n ");
            }
            return String.valueOf(exerciseInfo);
        }
    }

    // MODIFIES: this
    // EFFECTS: adds buttons which each display an exercise done in a workout
    private void createExerciseButtons() {
        List<Exercise> exercises = workout.getExercises();
        JPanel exercisesArea = new JPanel();
        JScrollPane scrollPane = createScrollPane(exercisesArea);
        pane.add(scrollPane);
        if (exercises.size() != 0) {
            exercisesArea.setLayout(new GridLayout(exercises.size(), 0,
                    HORIZONTAL_GAP, VERTICAL_GAP));
            createExerciseButton(exercisesArea);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates button corresponding to each exercise in exercises
    private void createExerciseButton(JPanel parent) {
        for (Exercise e : workout.getExercises()) {
            new EditExerciseButton(gui, parent, e);
        }
    }

    // EFFECTS: creates unmodifiable text box
    private JEditorPane label() {
        JEditorPane label = new JEditorPane();
        label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        label.setEditable(false);
        label.setText("Options");
        label.setFont(new Font("Dialog", Font.BOLD, 20));
        label.setPreferredSize(new Dimension(LABEL_WIDTH, TEXT_HEIGHT));
        return label;
    }

}
