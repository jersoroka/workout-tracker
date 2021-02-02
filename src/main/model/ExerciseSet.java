package model;

import java.util.ArrayList;
import java.util.List;

// Represents a set of exercises
public class ExerciseSet {

    private List<Exercise> exercises;

    public ExerciseSet() {
        exercises = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds an exercise to exercises
    public void addExercise(Exercise exercise) {
    }

    // MODIFIES: this
    // EFFECTS: removes an exercise from exercises
    // !!! what if there is more than one of the same exercises?
    public void removeExercise(Exercise exercise) {
    }
}
