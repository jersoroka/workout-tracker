package model;

import java.util.List;

// Represents an exercise having a name and list of sets performed
public class Exercise {
    private String name;
    private String category;
    private List<Set> sets;

    // REQUIRES: name has a non-zero length
    // EFFECTS: this.name is set to name and an empty list of sets is made
    public Exercise(String name) {
    }

    // MODIFIES: this
    // EFFECTS: adds a new set to this.sets
    public void addSet() {
    }

    // MODIFIES: this
    // EFFECTS: removes a set from this.sets
    public void removeSet(Set set) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
