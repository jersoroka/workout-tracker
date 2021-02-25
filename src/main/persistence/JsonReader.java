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
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    // code attributed to JsonSerializationDemo
    // TODO: does your workout set need to have a name so that it is unique from others?
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

    // TODO: watch a JSON video - what are you supposed to call to get the date, exercises?
    // MODIFIES: workoutSet
    // EFFECTS: parses thingy from JSON object and adds it to workout set
    private void addWorkout(WorkoutSet workoutSet, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Date date = jsonObject.getJSONObject("date");
        List<Exercise> exercises = jsonObject.getJSONObject("exercises");
        Workout workout = new Workout(name, date, exercises);
        workoutSet.addWorkout(workout);
    }

    // TODO: addExercise

    // TODO: addSet
}
