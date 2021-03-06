package ui.screens;

import ui.GUI;
import ui.buttons.editfield.AddWorkoutSubmitButton;
import ui.buttons.navigation.BackButton;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

import static javax.swing.GroupLayout.*;
import static javax.swing.SwingConstants.*;

// class representing a screen where a user can add a workout

public class AddWorkout extends Screen {
    private static final int LABEL_WIDTH = WIDTH / 3;
    private static final int ENTRY_WIDTH = WIDTH / 2;
    private static final int TEXT_HEIGHT = HEIGHT / 21;
    private Font font = new Font("Dialog", Font.PLAIN, 16);
    private GroupLayout layout;

    // MODIFIES: this
    // EFFECTS: constructs screen for adding a workout
    public AddWorkout(GUI gui) {
        super(gui, gui.getWorkoutSet());
        createTextFields();
    }

    // MODIFIES: this
    // EFFECTS: creates a window where the user can add a workout
    @Override
    protected void initializePane() {
        super.initializePane();
        gui.getContainer().add(this.getPane(), "add workout");
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
        JEditorPane header = header();
        JEditorPane nameLabel = textBox("Workout Name: ");
        JEditorPane nameEntry = entryField();
        JEditorPane monthLabel = textBox("Month (1-12): ");
        JEditorPane monthEntry = entryField();
        JEditorPane dayLabel = textBox("Day: ");
        JEditorPane dayEntry = entryField();
        JEditorPane yearLabel = textBox("Year: ");
        JEditorPane yearEntry = entryField();
        JButton backButton = new BackButton(gui, pane, "home").getButton();
        JButton submitButton = new AddWorkoutSubmitButton(gui, pane, nameEntry, monthEntry, dayEntry,
                yearEntry).getButton();

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
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(header, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(nameLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(monthLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(dayLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(yearLabel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(nameEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(monthEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(dayEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(yearEntry, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                        .addComponent(submitButton)
                        .addComponent(backButton)));
    }

    // EFFECTS: creates header for the screen
    private JEditorPane header() {
        JEditorPane header = new JEditorPane();
        header.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        header.setPreferredSize(new Dimension(LABEL_WIDTH * 2, TEXT_HEIGHT * 2));
        header.setEditable(false);
        header.setFont(new Font("Dialog", Font.BOLD, 16));
        header.setText("Please enter details for the workout. "
                + "\nEnter the month as a number.");
        return header;
    }

}
