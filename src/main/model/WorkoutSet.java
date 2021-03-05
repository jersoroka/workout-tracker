package model;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a set of workouts
public class WorkoutSet implements Writable {
    private List<Workout> workouts;

    // EFFECTS: makes an empty set of workouts
    public WorkoutSet() {
        workouts = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: if date is valid, return true add workout with this.name set to name and date constructed from year,
    // month, and day. If date is invalid, return false and do not add a workout.
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

    // REQUIRES: workout must have a valid date
    // MODIFIES: this
    // EFFECTS: adds workout to workouts
    public void addWorkout(Workout workout) {
        this.workouts.add(workout);
    }


    // REQUIRES: 0 <= index < workouts.size()
    // MODIFIES: this
    // EFFECTS: removes a workout at index from this.workouts
    public void removeWorkout(int index) {
        workouts.remove(index);
    }

    // REQUIRES: 0 <= index < workouts.size()
    // EFFECTS: returns the workout at the index
    public Workout getWorkout(int index) {
        return workouts.get(index);
    }

    // EFFECTS: returns the number of items in the set
    public int size() {
        return workouts.size();
    }

    // REQUIRES: workout must be in workouts
    // EFFECTS: returns the index of the workout
    public int indexOf(Workout workout) {
        return workouts.indexOf(workout);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("workouts", workoutsToJson());
        return json;
    }

    // EFFECTS: returns workouts as a JSON array
    // code based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private JSONArray workoutsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Workout workout : workouts) {
            jsonArray.put(workout.toJson());
        }
        return jsonArray;
    }
}
