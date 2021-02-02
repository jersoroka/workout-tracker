package model;

// Represents a workout having a date (yyyy-mm-dd), workout type, and set of exercises

import java.util.Date;

public class Workout {
    private Date date;
    private String name;
    private String category;
    private ExerciseSet exercises;

    // REQUIRES: category has a non-zero length
    // EFFECTS: makes a new workout with current date, name, category, and an empty ExerciseSet
    public Workout(String category, String name) {
    }

    // MODIFIES: this
    // EFFECTS: renames the category of the workout to newCategory
    public void setCategory(String newName) {
    }

    // MODIFIES: this
    // EFFECTS: renames the name of the workout to newName
    public void setName(String newCategory) {}

    // EFFECTS: returns the category of the workout
    public String getCategory() {
        return this.category;
    }

    // EFFECTS: returns the exercises in the workout
    public ExerciseSet getExerciseSet() {
        return this.exercises;
    }

    // EFFECTS: returns the name of the workout
    public String getName() {
        return this.name;
    }
}
