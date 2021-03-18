package ui.screens;

import model.Workout;
import ui.GUI;
import ui.buttons.addobject.AddWorkoutSubmitButton;
import ui.buttons.addobject.EditNameAndDateSubmitButton;
import ui.buttons.navigation.BackButton;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.SwingConstants.HORIZONTAL;

// class representing a window where the user can edit the name and date of a workout

public class EditNameAndDate extends Screen {
    private static final int LABEL_WIDTH = WIDTH / 3;
    private static final int ENTRY_WIDTH = WIDTH / 2;
    private static final int TEXT_HEIGHT = HEIGHT / 21;
    private Font font = new Font("Dialog", Font.PLAIN, 16);
    private GroupLayout layout;

    // MODIFIES: this
    // EFFECTS: constructs screen for editing a workout
    public EditNameAndDate(GUI gui, Object object) {
        super(gui, object);
        createTextFields();
    }

    // MODIFIES: this, gui
    // EFFECTS: creates a window where the user can edit a workout name and date
    @Override
    protected void initializePane() {
        super.initializePane();
        gui.getContainer().add(this.getPane(), "edit name and date");
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
        Workout workout = (Workout) object;
        JEditorPane header = header();
        JEditorPane nameLabel = textBox("Workout Name: ");
        JEditorPane nameEntry = entryField();
        nameEntry.setText(workout.getName());
        JEditorPane monthLabel = textBox("Month (1-12): ");
        JEditorPane monthEntry = entryField();
        JEditorPane dayLabel = textBox("Day: ");
        JEditorPane dayEntry = entryField();
        JEditorPane yearLabel = textBox("Year: ");
        JEditorPane yearEntry = entryField();

        monthEntry.setText(String.valueOf(workout.getDate().getMonth()));
        dayEntry.setText(String.valueOf(workout.getDate().getDay()));
        yearEntry.setText(String.valueOf(workout.getDate().getYear()));

        JButton backButton = new BackButton(gui, pane, "home").getButton();
        JButton submitButton = new EditNameAndDateSubmitButton(gui, pane, nameEntry, monthEntry, dayEntry,
                yearEntry, workout).getButton();

        setHorizontalGroup(nameLabel, nameEntry, monthLabel, monthEntry, dayLabel, dayEntry, yearLabel,
                yearEntry, backButton, submitButton, header);

        setVerticalGroup(nameLabel, nameEntry, monthLabel, monthEntry, dayLabel, dayEntry, yearLabel,
                yearEntry, backButton, submitButton, header);

        layout.linkSize(HORIZONTAL, backButton, submitButton);
    }

    // MODIFIES: this
    // EFFECTS: organizes vertical grouping in group layout
    private void setVerticalGroup(JEditorPane nameLabel, JEditorPane nameEntry, JEditorPane monthLabel,
                                  JEditorPane monthEntry, JEditorPane dayLabel, JEditorPane dayEntry,
                                  JEditorPane yearLabel, JEditorPane yearEntry, JButton backButton,
                                  JButton submitButton, JEditorPane header) {
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(header, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup()
                        .addComponent(nameLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(nameEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
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

    // MODIFIES: this
    // EFFECTS: organizes horizontal grouping in group layout
    private void setHorizontalGroup(JEditorPane nameLabel, JEditorPane nameEntry, JEditorPane monthLabel,
                                    JEditorPane monthEntry, JEditorPane dayLabel, JEditorPane dayEntry,
                                    JEditorPane yearLabel, JEditorPane yearEntry, JButton backButton,
                                    JButton submitButton, JEditorPane header) {
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(header, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(nameLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(monthLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(dayLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(yearLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(nameEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(monthEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(dayEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(yearEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                        .addComponent(submitButton)
                        .addComponent(backButton)));
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

    // EFFECTS: creates user entry field
    private JEditorPane entryField() {
        JEditorPane field = new JEditorPane();
        field.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        field.setPreferredSize(new Dimension(ENTRY_WIDTH, TEXT_HEIGHT));
        field.setFont(font);
        return field;
    }

    // EFFECTS: creates header for the screen
    private JEditorPane header() {
        JEditorPane header = new JEditorPane();
        header.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        header.setPreferredSize(new Dimension(LABEL_WIDTH * 2, TEXT_HEIGHT * 2));
        header.setEditable(false);
        header.setFont(new Font("Dialog", Font.BOLD, 16));
        header.setText("Edit the followings details as needed. "
                + "\nEnter the month as a number.");
        return header;
    }
}
