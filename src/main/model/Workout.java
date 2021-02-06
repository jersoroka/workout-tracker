package model;

// Represents a workout having a date (yyyy-mm-dd), workout type, and set of exercises

import java.util.Date;
import java.util.List;

public class Workout {
    private int year;
    private int month;
    private int day;
    private String name;
    private List<Exercise> exercises;

    // REQUIRES: category has a non-zero length
    // EFFECTS: makes a new workout with year, month, day, name, and an empty list of exercises
    public Workout(int year, int month, int day, String category, String name) {
    }

    // MODIFIES: this
    // EFFECTS: adds an exercise to exercises
    public void addExercise() {
    }

    // MODIFIES: this
    // EFFECTS: removes an exercise from exercises
    public void removeExercise(Exercise exercise) {
    }

    // EFFECTS: returns the year, month, and day or the workout as a string in the format "year-month-day"
    public String getDate() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
