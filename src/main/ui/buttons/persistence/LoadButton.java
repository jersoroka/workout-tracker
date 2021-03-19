package ui.buttons.persistence;

import persistence.JsonReader;
import ui.GUI;
import ui.buttons.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoadButton extends Button {
    private static final String JSON_STORE = "./data/workoutSet.json";
    private JsonReader jsonReader = new JsonReader(JSON_STORE);

    public LoadButton(GUI gui, JComponent parent) {
        super(gui, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
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
            gui.setWorkoutSet(jsonReader.read());
            System.out.println("Loaded from " + JSON_STORE);
            gui.createViewWorkoutsScreen();
        } catch (IOException e) {
            System.out.println(("Unable to read from file: " + JSON_STORE));
        }
    }
}
