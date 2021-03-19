package ui.screens;

import model.Exercise;
import model.Set;
import model.Workout;
import ui.GUI;
import ui.buttons.editfield.DeleteExerciseButton;
import ui.buttons.editfield.DeleteSetButton;
import ui.buttons.navigation.AddSetButton;
import ui.buttons.navigation.BackButton;
import ui.buttons.navigation.EditExerciseNameButton;
import ui.buttons.navigation.EditSetButton;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;

public class EditExercises extends Screen {
    private JTabbedPane tabbedPane;
    private static final int LABEL_WIDTH = WIDTH / 3;
    private static final int ENTRY_WIDTH = WIDTH / 2;
    private static final int TEXT_HEIGHT = HEIGHT / 21;
    private Font font = new Font("Dialog", Font.PLAIN, 16);

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
        JEditorPane nameLabel = textBox("Name: ");
        JButton editNameButton = new EditExerciseNameButton(gui, pane, exercise).getButton();
        // TODO: make this a combo box instead
        JComboBox setComboBox = createSetComboBox(exercise);
        //JPanel sets = createSetSection(exercise);
        JButton addSetButton = new AddSetButton(gui, parent, exercise).getButton();
        JButton deleteExerciseButton = new DeleteExerciseButton(gui, parent, object, exercise).getButton();
        JButton backButton = new BackButton(gui, pane, "view workouts").getButton();

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(nameLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addComponent(editNameButton))
                        .addComponent(setComboBox)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(addSetButton)
                                .addComponent(deleteExerciseButton)
                                .addComponent(backButton))
                ));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(nameLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(editNameButton))
                .addComponent(setComboBox)
                .addGroup(layout.createParallelGroup()
                        .addComponent(addSetButton)
                        .addComponent(deleteExerciseButton)
                        .addComponent(backButton))
        );
    }

    // EFFECTS: creates unmodifiable text box
    private JEditorPane textBox(String entry) {
        JEditorPane label = new JEditorPane();
        label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        label.setEditable(false);
        label.setText(entry);
        label.setFont(new Font("Dialog", Font.BOLD, 16));
        label.setPreferredSize(new Dimension(LABEL_WIDTH, TEXT_HEIGHT));
        return label;
    }

    // EFFECTS: creates combo box containing every set in exercise
    private JComboBox createSetComboBox(Exercise exercise) {
        List<String> setNames = new ArrayList<>();
        for (int i = 1; i == exercise.getSets().size(); i++) {
            setNames.add("Set " + i);
        }
        JComboBox setComboBox = new JComboBox();
        setComboBox.addItem("Test Set");
        setComboBox.addItem("Test Set 2");
        return setComboBox;
    }

    // EFFECTS: creates entry fields and buttons for each set in exercise
    private JPanel createSetSection(Exercise exercise) {
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(exercise.getSets().size(), 0));

        for (int i = 0; i < exercise.getSets().size(); i++) {
            JPanel setPane = new JPanel();
            Set set = exercise.getSet(i);
            JEditorPane setLabel = textBox("Set " + i);
            JButton editSetButton = new EditSetButton(gui, setPane, set).getButton();
            JButton deleteSetButton = new DeleteSetButton(gui, setPane, set, exercise, (Workout) object).getButton();

            GroupLayout setLayout = initializeGroupLayout(setPane);
            setHorizontalGroupSet(setLabel, editSetButton, deleteSetButton, setLayout);
            setVerticalGroupSet(setLabel, editSetButton, deleteSetButton, setLayout);

            setPane.setLayout(setLayout);
            pane.add(setPane);
        }

        return pane;
    }

    // MODIFIES: setLayout
    // EFFECTS: organizes vertical group layout for a set
    private void setVerticalGroupSet(JEditorPane setLabel, JButton editSetButton, JButton deleteSetButton,
                                     GroupLayout setLayout) {
        setLayout.setVerticalGroup(setLayout.createSequentialGroup()
                .addGroup(setLayout.createParallelGroup()
                        .addComponent(setLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(editSetButton)
                        .addComponent(deleteSetButton)));
    }

    // MODIFIES: setLayout
    // EFFECTS: organizes horizontal group layout for a set
    private void setHorizontalGroupSet(JEditorPane setLabel, JButton editSetButton, JButton deleteSetButton,
                                       GroupLayout setLayout) {
        setLayout.setHorizontalGroup(setLayout.createSequentialGroup()
                .addComponent(setLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                .addComponent(editSetButton)
                .addComponent(deleteSetButton));
    }
}
