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
                setInfo.append("\nSet ").append(stringSetNumber).append(s.getSetInfo());
            }
            return this.name + ": " + setInfo;
        }
    }

    // TODO: add tests
    // EFFECTS: returns the index of the set
    public int indexOf(Set set) {
        return sets.indexOf(set);
    }

    // EFFECTS: returns the number of sets in this.sets
    public int size() {
        return this.sets.size();
    }

    // EFFECTS: returns the set at the index
    public Set getSet(int index) {
        return this.sets.get(index);
    }

    // MODIFIES: this
    // EFFECTS: adds an empty set to this.sets
    public void addSet(int reps, int weight, String comment) {
        this.sets.add(new Set(reps, weight, comment));
    }

    // MODIFIES: this
    // EFFECTS: removes the set at the index of this.sets
    public void removeSet(int index) {
        sets.remove(index);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Set> getSets() {
        return sets;
    }

}
