package model;

// Represents a workout having a date (yyyy-mm-dd), workout type, and set of exercises

import java.util.ArrayList;
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
    public Workout(int year, int month, int day, String name) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
        exercises = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds an exercise with an empty list of sets to exercises
    public void addExercise(String name) {
        exercises.add(new Exercise(name));
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

    // EFFECTS: returns the year, month, and day or the workout as a string in the format "year-month-day"
    public String getDate() {
        String year = Integer.toString(this.year);
        String month = Integer.toString(this.month);
        String day = String.valueOf(this.day);

        if (this.month <= 9 & this.day <= 9) {
            return year + "-0" + month + "-0" + day;
        }
        if (this.month <= 9) {
            return year + "-0" + month + "-" + day;
        }
        if (this.day <= 9) {
            return year + "-" + month + "-0" + day;
        } else {
            return year + "-" + month + "-" + day;
        }
    }

    public void changeDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
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
