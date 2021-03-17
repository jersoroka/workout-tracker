package ui.screens;

import ui.GUI;
import ui.buttons.AddWorkoutSubmitButton;
import ui.buttons.BackButton;

import javax.swing.*;
import java.awt.*;
import java.security.acl.Group;

import static javax.swing.GroupLayout.*;
import static javax.swing.SwingConstants.*;

public class AddWorkout extends Screen {
    GroupLayout layout;

    public AddWorkout(GUI gui, String cardName) {
        super(gui, gui.getWorkoutSet(), cardName);
        createTextFields();
    }

    @Override
    protected void initializePane() {
        super.initializePane();
        gui.getContainer().add(this.getPane(), cardName);
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
    // EFFECTS: creates each text box and their corresponding entry field, then adds it to the
    //          group layout
    private void createTextFields() {
        JEditorPane workoutNameLabel = textBox("Workout Name: ");
        JEditorPane workoutNameEntry = entryField();
        JEditorPane monthLabel = textBox("Month: ");
        JEditorPane monthEntry = entryField();
        JEditorPane dayLabel = textBox("Day: ");
        JEditorPane dayEntry = entryField();
        JEditorPane yearLabel = textBox("Year: ");
        JEditorPane yearEntry = entryField();
        JButton backButton = new BackButton(gui, pane, gui.getWorkoutSet(), "home").getButton();
        JButton submitButton = new AddWorkoutSubmitButton(gui, pane, gui.getWorkoutSet()).getButton();

        setHorizontalGroup(workoutNameLabel, workoutNameEntry, monthLabel, monthEntry, dayLabel, dayEntry, yearLabel,
                yearEntry, backButton, submitButton);

        setVerticalGroup(workoutNameLabel, workoutNameEntry, monthLabel, monthEntry, dayLabel, dayEntry, yearLabel,
                yearEntry, backButton, submitButton);

        layout.linkSize(HORIZONTAL, backButton, submitButton);
    }

    private void setVerticalGroup(JEditorPane workoutNameLabel, JEditorPane workoutNameEntry, JEditorPane monthLabel,
                                  JEditorPane monthEntry, JEditorPane dayLabel, JEditorPane dayEntry,
                                  JEditorPane yearLabel, JEditorPane yearEntry, JButton backButton,
                                  JButton submitButton) {
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(workoutNameLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(workoutNameEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup()
                        .addComponent(monthLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(monthEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup()
                        .addComponent(dayLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(dayEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup()
                        .addComponent(yearLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(yearEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addComponent(submitButton)
                .addComponent(backButton));
    }

    private void setHorizontalGroup(JEditorPane workoutNameLabel, JEditorPane workoutNameEntry, JEditorPane monthLabel,
                                    JEditorPane monthEntry, JEditorPane dayLabel, JEditorPane dayEntry,
                                    JEditorPane yearLabel, JEditorPane yearEntry, JButton backButton,
                                    JButton submitButton) {
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)

                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(workoutNameLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(monthLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(dayLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(yearLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))

                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(workoutNameEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(monthEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(dayEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(yearEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))

                        .addComponent(submitButton)
                        .addComponent(backButton)));
    }


    // EFFECTS: creates unmodifiable text box
    private JEditorPane textBox(String entry) {
        JEditorPane label = new JEditorPane();
        label.setEditable(false);
        label.setText(entry);
        label.setPreferredSize(new Dimension(WIDTH / 20, HEIGHT / 50));
        return label;
    }

    // EFFECTS: creates user entry field
    private JEditorPane entryField() {
        JEditorPane field = new JEditorPane();
        field.setPreferredSize(new Dimension(WIDTH / 7, HEIGHT / 50));
        return field;
    }
}
