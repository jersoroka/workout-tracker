package model;

import model.exceptions.EmptyStringException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a workout having a date, name, and a set of exercises
public class Workout implements Writable {
    private Date date;
    private String name;
    private List<Exercise> exercises;

    // REQUIRES: name has non-zero length, date is valid
    // EFFECTS: makes a new workout with this.date set to date, this.name set to name, and an empty list of exercises
    public Workout(Date date, String name) {
        this.date = date;
        this.name = name;
        exercises = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds an exercise with name to an empty list of sets to exercises
    public void addExercise(String name) {
        try {
            Exercise exercise = new Exercise(name);
            exercises.add(exercise);
        } catch (EmptyStringException e) {
            System.out.println("Exercise could not be added. Name must have non-zero length.");
        }
    }

    // REQUIRES: 0 <= index < exercises.size()
    // MODIFIES: this
    // EFFECTS: removes the exercise at the index from exercises
    public void removeExercise(int index) {
        exercises.remove(index);
    }

    // REQUIRES: exercise must be in exercises
    // EFFECTS: returns the index of an exercise in exercises
    public int indexOf(Exercise exercise) {
        return exercises.indexOf(exercise);
    }

    // EFFECTS: returns the number of exercises in exercises
    public int size() {
        return exercises.size();
    }

    // REQUIRES: 0 <= index < exercises.size()
    // EFFECTS: returns the exercise at the index
    public Exercise getExercise(int index) {
        return exercises.get(index);
    }

    // EFFECTS: returns the date of the workout
    public Date getDate() {
        return date;
    }

    // MODIFIES: this
    // EFFECTS: returns true if the new date is valid and sets this.date to date.
    // Otherwise return false and do not change this.date.
    public boolean setDate(Date date) {
        if (date.isValidDate()) {
            this.date = date;
            return true;
        } else {
            return false;
        }
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

    @Override
    // EFFECTS: returns workout as JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("date", date.toJson());
        json.put("name", name);
        json.put("exercises", exercisesToJson());
        return json;
    }

    // EFFECTS: returns exercises as a JSON array
    // code based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private JSONArray exercisesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Exercise exercise : exercises) {
            jsonArray.put(exercise.toJson());
        }
        return jsonArray;
    }
}
