package model;

import java.util.List;

public class WorkoutSet {
    private List<Workout> workouts;

    // MODIFIES: this
    // EFFECTS: adds a new workout to this.workouts
    public void addWorkout() {
    }

    // MODIFIES: this
    // EFFECTS: removes a workout from this.workouts
    public void removeWorkout(Workout workout) {
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }
}
