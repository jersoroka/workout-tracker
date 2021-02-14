package model;

public class Set {
    private int reps;
    private int weight;
    private String comment;

    // REQUIRES: reps >= 0 and weight >= 0
    // EFFECTS: this.reps, this.weight, and this.comment are set to reps, weight, and comment
    public Set(int reps, int weight, String comment) {
        this.reps = reps;
        this.weight = weight;
        this.comment = comment;
    }

    // EFFECTS: returns the reps, weight, and comment as a string.
    // If the comment is empty, the comment is set to none
    public String getSetInfo() {
        if (comment.equals("")) {
            return " weight: " + weight + ", reps: " + reps + ", comment: none";
        } else {
            return " weight: " + weight + ", reps: " + reps + ", comment: " + this.comment;
        }
    }

    public int getReps() {
        return reps;
    }

    public int getWeight() {
        return weight;
    }

    public String getComment() {
        return comment;
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
