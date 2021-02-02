package model;

public class Set {
    private int reps;
    private int weight;
    private int duration;
    private String comment;

    // REQUIRES: reps, weight, and duration must be >= 0
    // EFFECTS: this.reps, this.weight, this.duration, and this.comment are set to reps, weight, duration, and comment
    public Set(int reps, int weight, int duration, String comment){}

    public int getReps() {
        return reps;
    }

    // REQUIRES: reps >= 0
    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    // REQUIRES: weight >= 0
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDuration() {
        return duration;
    }

    // REQUIRES: duration >= 0
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
