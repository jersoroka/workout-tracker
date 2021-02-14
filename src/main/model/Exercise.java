package model;

import java.util.ArrayList;
import java.util.List;

// Represents an exercise having a name and list of sets performed
public class Exercise {
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

    // REQUIRES: 0 <= index <= (sets.size - 1)
    // MODIFIES: this
    // EFFECTS: removes the set located at index in this.sets
    public void removeSet(int index) {
        sets.remove(index);
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

    // REQUIRES: 0 <= index <= (sets.size() - 1)
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

}
