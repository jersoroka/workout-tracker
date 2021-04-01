package persistence;

import model.Date;
import model.Exercise;
import model.Workout;
import model.WorkoutSet;
import model.exceptions.NegativeValueException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads workout set from source file
// code based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workout set from file and returns it
    // throws IOException if an error occurs reading data from file
    public WorkoutSet read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkoutSet(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workout set from JSON object and returns it
    private WorkoutSet parseWorkoutSet(JSONObject jsonObject) {
        WorkoutSet workoutSet = new WorkoutSet();
        addWorkouts(workoutSet, jsonObject);
        return workoutSet;
    }

    // MODIFIES: workoutSet
    // EFFECTS: parses workouts from JSON object and adds them to workout set
    private void addWorkouts(WorkoutSet workoutSet, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("workouts");
        for (Object json : jsonArray) {
            JSONObject nextWorkout = (JSONObject) json;
            addWorkout(workoutSet, nextWorkout);
        }
    }

    // MODIFIES: workoutSet
    // EFFECTS: parses individual workout from JSON object and adds it to workout set
    private void addWorkout(WorkoutSet workoutSet, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        JSONObject date = jsonObject.getJSONObject("date");
        JSONArray exercises = jsonObject.getJSONArray("exercises");
        Workout workout = new Workout(parseDate(date), name);
        addExercises(workout, exercises);
        workoutSet.addWorkout(workout);
    }

    // EFFECTS: parses date from JSON object and returns it
    private Date parseDate(JSONObject date) {
        int year = date.getInt("year");
        int month = date.getInt("month");
        int day = date.getInt("day");
        return new Date(year, month, day);
    }

    // MODIFIES: workout
    // EFFECTS: parses exercises from JSON object and adds it to workout
    private void addExercises(Workout workout, JSONArray exercises) {
        for (Object json : exercises) {
            JSONObject exercise = (JSONObject) json;
            addExercise(workout, exercise);
        }
    }

    // MODIFIES: workout
    // EFFECTS: parses exercise from JSON object and adds it to exercises in workout
    private void addExercise(Workout workout, JSONObject exercise) {
        JSONArray jsonArray = exercise.getJSONArray("sets");
        String name = exercise.getString("name");
        workout.addExercise(name);
        Exercise parsedExercise = workout.getExercise(workout.size() - 1);

        for (Object json : jsonArray) {
            JSONObject set = (JSONObject) json;
            addSet(parsedExercise, set);
        }
    }

    // MODIFIES: exercise
    // EFFECTS: parses set from JSON object and adds it to exercise
    private void addSet(Exercise exercise, JSONObject set) {
        int reps = set.getInt("reps");
        int weight = set.getInt("weight");
        String comment = set.getString("comment");
        try {
            exercise.addSet(reps, weight, comment);
        } catch (NegativeValueException e) {
            System.out.println("Caught negative value exception.");
        }
    }

}
