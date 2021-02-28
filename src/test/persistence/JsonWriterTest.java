package persistence;

import model.Exercise;
import model.Workout;
import model.WorkoutSet;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{

    @Test
    // code attributed to JsonSerializationDemo
    void testWriterInvalidFile() {
        try {
            WorkoutSet workoutSet = new WorkoutSet();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    // code attributed to JsonSerializationDemo
    void testWriterEmptyWorkoutSet() {
        try {
            WorkoutSet workoutSet = new WorkoutSet();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkoutSet.json");
            writer.open();
            writer.write(workoutSet);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkoutSet.json");
            workoutSet = reader.read();
            assertEquals(0, workoutSet.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    // code attributed to JsonSerializationDemo
    void testWriterGeneralWorkoutSet() {
        try {
            WorkoutSet workoutSet = makeWorkoutSet();
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkoutSet.json");
            writer.open();
            writer.write(workoutSet);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkoutSet.json");
            workoutSet = reader.read();

            Workout legsWorkout = workoutSet.getWorkout(0);
            checkWorkout("legs", 2021,2,27, 2,legsWorkout);
            Exercise frontSquats = legsWorkout.getExercise(0);
            checkExercise("front squats", 2, frontSquats);
            checkSet(10, 135, "warmup", frontSquats.getSet(0));
            checkSet(10, 155, "", frontSquats.getSet(1));
            Exercise legCurls = legsWorkout.getExercise(1);
            checkExercise("leg curls", 1, legCurls);
            checkSet(20, 45, "", legCurls.getSet(0));

            Workout backWorkout = workoutSet.getWorkout(1);
            checkWorkout("back", 2021, 2, 28, 1, backWorkout);
            Exercise rows = backWorkout.getExercise(0);
            checkExercise("rows", 2, rows);
            checkSet(10,75,"fast reps", rows.getSet(0));
            checkSet(12,85,"", rows.getSet(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
