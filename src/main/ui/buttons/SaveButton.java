package ui.buttons;

import model.WorkoutSet;
import persistence.JsonWriter;
import ui.WorkoutLoggerAppGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class SaveButton extends Button {
    private static final String JSON_STORE = "./data/workoutSet.json";
    private JsonWriter jsonWriter;
    private WorkoutSet workoutSet;

    public SaveButton(JComponent parent, WorkoutSet workoutSet) {
        super(parent);
        this.workoutSet = workoutSet;
    }

    // EFFECTS: returns save label
    @Override
    protected String getLabel() {
        return "Save";
    }

    // MODIFIES: this
    // EFFECTS: associates button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new SaveToolClickHandler());
    }


    private class SaveToolClickHandler implements ActionListener {

        // EFFECTS: saves workouts
        @Override
        public void actionPerformed(ActionEvent e) {
            saveWorkoutSet();
        }
    }

    // EFFECTS: saves the workout set to file
    // code based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void saveWorkoutSet() {
        try {
            jsonWriter.open();
            jsonWriter.write(workoutSet);
            jsonWriter.close();
            System.out.println("Saved workout logger to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

}