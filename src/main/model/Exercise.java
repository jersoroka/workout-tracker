package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents an exercise having a name and list of sets performed
public class Exercise implements Writable {
    private String name;
    private List<Set> sets;

    // REQUIRES: name has a non-zero length
    // EFFECTS: this.name is set to name and an empty list of sets is made
    public Exercise(String name) {
        this.name = name;
        sets = new ArrayList<>();
    }

    // REQUIRES: reps >= 0 and weight >= 0
    // MODIFIES: this
    // EFFECTS: adds a set to this.sets
    public void addSet(int reps, int weight, String comment) {
        Set set = new Set(reps, weight, comment);
        this.sets.add(set);
    }

    // REQUIRES: 0 <= index < sets.size()
    // MODIFIES: this
    // EFFECTS: removes the set located at index in this.sets
    public void removeSet(int index) {
        sets.remove(index);
    }

    // MODIFIES: this
    // EFFECTS: removes the set from exercises
    public void removeSet(Set set) {
        sets.remove(set);
    }


    // EFFECTS: returns the name of the exercise and list of sets completed as a string
    public String getExerciseInfo() {
        if (sets.size() == 0) {
            return this.name + ": no sets completed";
        } else {
            int setNumber = 0;
            StringBuilder setInfo = new StringBuilder();
            for (Set s : sets) {
                setNumber += 1;
                String stringSetNumber = Integer.toString(setNumber);
                setInfo.append("\nSet ").append(stringSetNumber).append(": ").append(s.getSetInfo());
            }
            return this.name + ": " + setInfo;
        }
    }

    // REQUIRES: set must be in this.exercise.sets
    // EFFECTS: returns the index of the set
    public int indexOf(Set set) {
        return sets.indexOf(set);
    }


    // EFFECTS: returns the number of sets in this.sets
    public int size() {
        return this.sets.size();
    }

    // REQUIRES: 0 <= index < sets.size()
    // EFFECTS: returns the set at the index
    public Set getSet(int index) {
        return this.sets.get(index);
    }

    public String getName() {
        return name;
    }

    // REQUIRES: name has non-zero length
    public void setName(String name) {
        this.name = name;
    }

    public List<Set> getSets() {
        return sets;
    }

    @Override
    // EFFECTS: returns exercise as JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("sets", setsToJson());
        return json;
    }

    // EFFECTS: returns sets as a JSON array
    // code based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private JSONArray setsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Set set: sets) {
            jsonArray.put(set.toJson());
        }
        return jsonArray;
    }
}
