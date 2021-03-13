package ui;

import model.Workout;
import model.WorkoutSet;
import ui.buttons.Button;
import ui.buttons.LoadButton;
import ui.buttons.SaveButton;

import javax.swing.*;
import java.awt.*;

public class WorkoutLoggerAppGUI extends JFrame {
    private JFrame frame;
    private JButton button;
    private JLabel label;
    private WorkoutSet workoutSet;


    public WorkoutLoggerAppGUI() {
        initializeFields();
        initializeGraphics();
    }

    // MODIFIES: this
    // EFFECTS: instantiates frame, button, label, and panel
    private void initializeFields() {
        workoutSet = new WorkoutSet();
    }

    // MODIFIES: this
    // EFFECTS: draws the JFrame window where the workout logger app will operate
    //          and populates the save and load buttons
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(800, 600));
        createPersistenceButtons();
        // add something
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // not sure what this one does
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates persistence buttons
    private void createPersistenceButtons() {
        JPanel persistenceArea = new JPanel();
        persistenceArea.setLayout(new GridLayout(0, 1));
        persistenceArea.setSize(new Dimension(0, 0));
        add(persistenceArea, BorderLayout.SOUTH);

        Button saveButton = new SaveButton(persistenceArea, workoutSet);
        Button loadButton = new LoadButton(persistenceArea, workoutSet);
    }

    public static void main(String[] args) {
        new WorkoutLoggerAppGUI();
    }
}
