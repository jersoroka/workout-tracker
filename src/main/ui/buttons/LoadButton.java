package ui.buttons;

import model.WorkoutSet;
import persistence.JsonReader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoadButton extends Button {
    private static final String JSON_STORE = "./data/workoutSet.json";
    private JsonReader jsonReader;
    private WorkoutSet workoutSet;

    public LoadButton(JComponent parent, WorkoutSet workoutSet) {
        super(parent);
        this.workoutSet = workoutSet;
    }

    // EFFECTS: returns load label
    @Override
    protected String getLabel() {
        return "Load";
    }

    // MODIFIES: this
    // EFFECTS: associates button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new LoadButton.LoadButtonClickHandler());
    }

    private class LoadButtonClickHandler implements ActionListener {

        // EFFECTS: loads workouts
        @Override
        public void actionPerformed(ActionEvent e) {
            loadWorkoutSet();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workout set from file
    // code based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void loadWorkoutSet() {
        try {
            workoutSet = jsonReader.read();
            System.out.println("Loaded from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println(("Unable to read from file: " + JSON_STORE));
        }
    }
}