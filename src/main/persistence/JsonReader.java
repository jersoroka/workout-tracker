package persistence;

import model.Date;
import model.Exercise;
import model.Workout;
import model.WorkoutSet;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Represents a reader that reads workout set from source file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    // code attributed to JsonSerializationDemo
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workout set from file and returns it
    // throws IOException if an error occurs reading data from file
    // code attributed to JsonSerializationDemo
    public WorkoutSet read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkoutSet(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    // code attributed to JsonSerializationDemo
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    // code attributed to JsonSerializationDemo
    private WorkoutSet parseWorkoutSet(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        WorkoutSet workoutSet = new WorkoutSet();
        addWorkouts(workoutSet, jsonObject);
        return workoutSet;
    }

    // MODIFIES: workoutSet
    // EFFECTS: parses thingies from JSON object and adds them to workout set
    // code attributed to JsonSerializationDemo
    private void addWorkouts(WorkoutSet workoutSet, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("workouts");
        for (Object json : jsonArray) {
            JSONObject nextWorkout = (JSONObject) json;
            addWorkout(workoutSet, nextWorkout);
        }
    }

    // MODIFIES: workoutSet
    // EFFECTS: parses workout from JSON object and adds it to workout set
    private void addWorkout(WorkoutSet workoutSet, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        JSONObject date = jsonObject.getJSONObject("date");
        JSONObject exercises = jsonObject.getJSONObject("exercises");
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

    // EFFECTS: parses exercises from JSON object and returns it
    private List<Exercise> addExercises(Workout workout, JSONObject exercises) {
        JSONArray jsonArray = exercises.getJSONArray("exercise");
        List<Exercise> parsedExercises = new ArrayList<>();
        for (Object json: jsonArray) {
            JSONObject exercise = (JSONObject) json;
            addExercise(workout, exercise);
        }
        return parsedExercises;
    }

    // EFFECTS: parses exercise from JSON object and adds it to exercises
    private void addExercise(Workout workout, JSONObject exercise) {
        JSONArray jsonArray = exercise.getJSONArray("sets");
        String name = exercise.getString("name");
        workout.addExercise(name);
        Exercise parsedExercise = workout.getExercise(workout.size() - 1);

        for (Object json: jsonArray) {
            JSONObject set = (JSONObject) json;
            addSet(parsedExercise, set);
        }
    }

    // EFFECTS: parses set from JSON object and adds it to exercise
    private void addSet(Exercise exercise, JSONObject set) {
        int reps = set.getInt("reps");
        int weight = set.getInt("weight");
        String comment = set.getString("comment");
        exercise.addSet(reps, weight, comment);
    }



}
