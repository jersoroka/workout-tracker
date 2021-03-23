package ui.buttons.persistence;

import persistence.JsonReader;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// class that represents a button that is used to load a previously saved workout from file
// buttons developed using https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git
// as template

public class LoadButton extends Button {
    private static final String JSON_STORE = "./data/workoutSet.json";
    private JsonReader jsonReader = new JsonReader(JSON_STORE);

    // MODIFIES: this
    // EFFECTS: constructs a button that loads a workout set from file
    public LoadButton(GUI gui, JComponent parent) {
        super(gui, parent);
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
        button.addActionListener(new LoadButton.ClickHandler());
    }

    // class that represents a click handler
    private class ClickHandler implements ActionListener {

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
            gui.setWorkoutSet(jsonReader.read());
            System.out.println("Loaded from " + JSON_STORE);
            gui.createViewWorkoutsScreen();
        } catch (IOException e) {
            System.out.println(("Unable to read from file: " + JSON_STORE));
        }
    }
}
