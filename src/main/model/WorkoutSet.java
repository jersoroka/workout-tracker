package model;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.List;

public class WorkoutSet {
    private List<Workout> workouts;

    // EFFECTS: instantiates an empty workout set
    // TODO: check language for the effects
    // TODO: check if capital letters are needed for specifications
    public WorkoutSet() {
        workouts = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: if date is valid, add workout with date constructed from year, month, and day, and name and return true.
    // If date is invalid, return false and do not add a workout.
    public boolean addWorkout(int year, int month, int day, String name) {
        Date date = new Date(year, month, day);
        if (date.isValidDate()) {
            Workout workout = new Workout(date, name);
            workouts.add(workout);
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: index must <= (workouts.size() - 1)
    // MODIFIES: this
    // EFFECTS: removes a workout at index from this.workouts
    public void removeWorkout(int index) {
        workouts.remove(index);
    }

    // REQUIRES: index must be <= (workouts.size() - 1)
    // EFFECTS: returns the workout at the index
    public Workout getWorkout(int index) {
        return workouts.get(index);
    }

    // EFFECTS: returns the number of items in the set
    public int size() {
        return workouts.size();
    }

}
