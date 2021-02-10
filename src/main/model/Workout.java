package model;

// Represents a workout having a date (yyyy-mm-dd), workout type, and set of exercises

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private Date date;
    private String name;
    private List<Exercise> exercises;

    // EFFECTS: makes a new workout with year, month, day, name, and an empty list of exercises
    public Workout(Date date, String name) {
        this.date = date;
        this.name = name;
        exercises = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds an exercise with name to an empty list of sets to exercises
    public void addExercise(String name) {
        Exercise exercise = new Exercise(name);
        exercises.add(exercise);
    }

    // MODIFIES: this
    // EFFECTS: removes the exercise at the index from exercises
    public void removeExercise(int index) {
        exercises.remove(index);
    }

    // EFFECTS: returns the exercise at the index
    public Exercise getExercise(int index) {
        return exercises.get(index);
    }

    // EFFECTS: returns the number of exercises in exercises
    public int size() {
        return exercises.size();
    }

    // EFFECTS: returns the date of the workout
    public Date getDate() {
        return date;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

}
