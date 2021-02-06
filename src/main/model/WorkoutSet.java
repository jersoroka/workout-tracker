package model;

import java.util.ArrayList;
import java.util.List;

public class WorkoutSet {
    private List<Workout> workouts;

    // EFFECTS: workout set is empty
    public WorkoutSet() {
        workouts = new ArrayList<>();
    }

    // REQUIRES: 1 <= month <= 12, 1 <= day <= 31
    // MODIFIES: this
    // EFFECTS: adds a new workout to this.workouts with date, name, category, and empty list of exercises
    public void addWorkout(int year, int month, int day, String name) {
    }

    // REQUIRES: index must <= (workouts.size() - 1)
    // MODIFIES: this
    // EFFECTS: removes a workout at index from this.workouts
    public void removeWorkout(int index) {
    }

    // REQUIRES: index must be <= (workouts.size() - 1)
    // EFFECTS: returns the workout at the index
    public Workout getWorkout(int index) {
        return null;
    }

    // EFFECTS: returns the number of items in the set
    public int size() {
        return workouts.size();
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }
}
