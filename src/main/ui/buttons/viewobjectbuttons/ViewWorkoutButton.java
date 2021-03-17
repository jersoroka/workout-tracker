package ui.buttons.viewobjectbuttons;

import model.Workout;
import model.WorkoutSet;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewWorkoutButton extends ViewObjectButton {

    public ViewWorkoutButton(GUI gui, JComponent parent, WorkoutSet workoutSet, Workout workout) {
        super(gui, parent, workoutSet, workout);
    }

    @Override
    protected String getLabel() {
        Workout workout = (Workout) this.object;
        return workout.getName() + ": " + workout.getDate().formatToString();
    }

    @Override
    protected void addListener() {
        button.addActionListener(new ViewWorkoutButton.ClickHandler());
    }

    private class ClickHandler implements ActionListener {

        // EFFECTS: loads selected workout
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.createViewWorkoutScreen((Workout) object);
            gui.getCards().show(gui.getContainer(), "view workout");
        }
    }

//    protected JButton button;
//    protected WorkoutSet workoutSet;
//    protected JComponent parent;
//    protected GUI gui;
//    protected Workout workout;
//
//    public ViewWorkoutButton(GUI gui, JComponent parent,
//                             WorkoutSet workoutSet, Workout workout) {
//        this.workoutSet = workoutSet;
//        this.gui = gui;
//        this.workout = workout;
//        this.parent = parent;
//        createButton(parent);
//        addListener();
//        addToParent();
//
//    }
//
//    protected void createButton(JComponent parent) {
//        button = new JButton(getLabel());
//        button = customizeButton(button);
//    }
//
//
//    protected String getLabel() {
//        return workout.getName() + ": " + workout.getDate().formatToString();
//    }
//
//    protected void addListener() {
//        System.out.println("Finish this up!");
//    }
//
//    // MODIFIES: parent
//    // EFFECTS:  adds the given button to the parent component
//    public void addToParent() {
//        parent.add(button);
//    }
//
//    // MODIFIES: this
//    // EFFECTS: customizes the button
//    protected JButton customizeButton(JButton button) {
//        button.setBorderPainted(true);
//        button.setFocusPainted(true);
//        button.setContentAreaFilled(true);
//        button.setPreferredSize(new Dimension(600, 100));
//        return button;
//    }


}
