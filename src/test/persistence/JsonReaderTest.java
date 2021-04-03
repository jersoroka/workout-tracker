package persistence;

import model.Exercise;
import model.Set;
import model.Workout;
import model.WorkoutSet;
import model.exceptions.InvalidIndexException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{

    @Test
        // code attributed to JsonSerializationDemo
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            WorkoutSet workoutSet = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
        // code attributed to JsonSerializationDemo
    void testReaderEmptyWorkoutSet() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkoutSet.json");
        try {
            WorkoutSet workoutSet = reader.read();
            assertEquals(0, workoutSet.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
        // code attributed to JsonSerializationDemo
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkoutSet.json");
        try {
            WorkoutSet workoutSet = reader.read();

            Workout testWorkout = workoutSet.getWorkout(0);
            checkWorkout("chest", 2021, 2, 27, 2, testWorkout);

            Exercise benchPress = testWorkout.getExercise(0);
            checkExercise("bench press", 3, benchPress);
            checkSet(10, 135, "none", benchPress.getSet(0));
            checkSet(10, 135, "medium speed", benchPress.getSet(1));
            checkSet(12,115,"burnout", benchPress.getSet(2));
            Exercise overheadPress = testWorkout.getExercise(1);
            checkExercise("overhead press", 2, overheadPress);
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (InvalidIndexException e) {
            fail("InvalidIndexException should not be thrown.");
        }
    }

    @Test
        // code attributed to JsonSerializationDemo
    void testReaderInvalidSetInWorkoutSet() {
        JsonReader reader = new JsonReader("./data/testReaderInvalidWorkoutSet.json");
        try {
            WorkoutSet workoutSet = reader.read();

            Workout testWorkout = workoutSet.getWorkout(0);
            checkWorkout("chest", 2021, 2, 27, 2, testWorkout);

            Exercise benchPress = testWorkout.getExercise(0);
            checkExercise("bench press", 2, benchPress);
            checkSet(10, 135, "medium speed", benchPress.getSet(0));
            checkSet(12,115,"burnout", benchPress.getSet(1));
            Exercise overheadPress = testWorkout.getExercise(1);
            checkExercise("overhead press", 2, overheadPress);
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (InvalidIndexException e) {
            fail("InvalidIndexException should not be thrown.");
        }
    }
}
