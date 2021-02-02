package model;

// Represents a workout having a date (yyyy-mm-dd), workout type, and set of exercises

import java.util.Date;
import java.util.List;

public class Workout {
    private Date date;
    private String name;
    private String category;
    private List<Exercise> exercises;

    // REQUIRES: category has a non-zero length
    // EFFECTS: makes a new workout with current date, name, category, and an empty list of exercises
    public Workout(String category, String name) {
    }

    // MODIFIES: this
    // EFFECTS: adds an exercise to exercises
    public void addExercise() {
    }

    // MODIFIES: this
    // EFFECTS: removes an exercise from exercises
    public void removeExercise(Exercise exercise) {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(int year, int month, int day) { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
