package model;

public class Set {
    private int reps;
    private int weight;
    private String comment;

    // REQUIRES: reps, weight, and duration must be >= 0
    // EFFECTS: this.reps, this.weight, and this.comment are set to reps, weight, duration, and comment
    public Set(int reps, int weight, String comment) {
        this.reps = reps;
        this.weight = weight;
        this.comment = comment;
    }

    // EFFECTS: returns the reps, weight, and comment of the set as a string.
    // If the comment is empty, the comment section is not included.
    public String getSetInfo() {
        if (comment.equals("")) {
            return "weight: " + weight + ", reps: " + reps;
        } else {
            return "weight: " + weight + ", reps: " + reps + ", comment: " + this.comment;
        }
    }


    // REQUIRES: reps >= 0
    public void setReps(int reps) {
        this.reps = reps;
    }

    // REQUIRES: weight >= 0
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
