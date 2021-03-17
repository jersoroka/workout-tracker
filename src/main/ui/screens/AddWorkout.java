package ui.screens;

import ui.GUI;
import ui.buttons.AddWorkoutSubmitButton;
import ui.buttons.BackButton;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

import static javax.swing.GroupLayout.*;
import static javax.swing.SwingConstants.*;

public class AddWorkout extends Screen {
    private static final int LABEL_WIDTH = WIDTH / 15;
    private static final int ENTRY_WIDTH = WIDTH / 5;
    private static final int TEXT_HEIGHT = HEIGHT / 50;
    private Font font = new Font("Dialog", Font.PLAIN, 16);
    private GroupLayout layout;

    public AddWorkout(GUI gui) {
        super(gui, gui.getWorkoutSet());
        createTextFields();
    }

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
        JButton backButton = new BackButton(gui, pane, gui.getWorkoutSet(), "home").getButton();
        JButton submitButton = new AddWorkoutSubmitButton(gui, pane, nameEntry, monthEntry, dayEntry,
                yearEntry).getButton();

        setHorizontalGroup(nameLabel, nameEntry, monthLabel, monthEntry, dayLabel, dayEntry, yearLabel,
                yearEntry, backButton, submitButton, header);

        setVerticalGroup(nameLabel, nameEntry, monthLabel, monthEntry, dayLabel, dayEntry, yearLabel,
                yearEntry, backButton, submitButton, header);

        layout.linkSize(HORIZONTAL, backButton, submitButton);
    }

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
        header.setPreferredSize(new Dimension(ENTRY_WIDTH, TEXT_HEIGHT * 2));
        header.setEditable(false);
        header.setFont(new Font("Dialog", Font.BOLD, 16));
        header.setText("Please enter details for the workout. "
                + "\nEnter the month of the workout as a number.");
        return header;
    }

}
