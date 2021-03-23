package ui.buttons.persistence;

import model.WorkoutSet;
import persistence.JsonWriter;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// class representing a button that allows the user to save their workouts
// buttons developed using https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git
// as template

public class SaveButton extends Button {
    private static final String JSON_STORE = "./data/workoutSet.json";
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORE);

    // MODIFIES: this
    // EFFECTS: constructs a save button
    public SaveButton(GUI gui, JComponent parent) {
        super(gui, parent);
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
        button.addActionListener(new ClickHandler());
    }

    // class that represents a click handler
    private class ClickHandler implements ActionListener {

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
