package persistence;

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
    void testWriterEmptyWorkroom() {
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

}
