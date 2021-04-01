package model;

import model.exceptions.EmptyStringException;
import model.exceptions.InvalidIndexException;
import model.exceptions.NegativeValueException;
import model.exceptions.ObjectDoesNotExistException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents an exercise having a name and list of sets performed
public class Exercise implements Writable {
    private String name;
    private List<Set> sets;

    // EFFECTS: this.name is set to name and an empty list of sets is made.
    //          Throws EmptyStringException if name is an empty string.
    public Exercise(String name) throws EmptyStringException {
        if (name.length() == 0) {
            throw new EmptyStringException();
        }
        this.name = name;
        sets = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a set to this.sets. If reps or weight are less than 0, throws NegativeValueException.
    public void addSet(int reps, int weight, String comment) throws NegativeValueException {
        if (reps < 0 | weight < 0) {
            throw new NegativeValueException();
        }
        Set set = new Set(reps, weight, comment);
        this.sets.add(set);
    }

    // MODIFIES: this
    // EFFECTS: removes the set located at index in this.sets.
    //          If index < 0 or index >= sets.size(), throws InvalidIndexException.
    public void removeSet(int index) throws InvalidIndexException {
        if (index < 0 | index > sets.size()) {
            throw new InvalidIndexException();
        }
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

    // EFFECTS: returns the index of the set. If set is not found in sets, throws ObjectDoesNotExistException.
    public int indexOf(Set set) throws ObjectDoesNotExistException {
        if (!sets.contains(set)) {
            throw new ObjectDoesNotExistException();
        }
        return sets.indexOf(set);
    }

    // EFFECTS: returns the number of sets in this.sets
    public int size() {
        return this.sets.size();
    }

    // EFFECTS: returns the set at the index.
    //          If index < 0 or index >= sets.size(), throws InvalidIndexException.
    public Set getSet(int index) throws InvalidIndexException {
        if (index < 0 | index > sets.size()) {
            throw new InvalidIndexException();
        }
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
