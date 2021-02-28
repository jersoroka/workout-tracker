package persistence;

import model.Date;
import model.Exercise;
import model.Set;
import model.Workout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkWorkout(String name, int year, int month, int day, int size, Workout workout) {
        assertEquals(name, workout.getName());
        assertEquals(size, workout.size());

        Date date = workout.getDate();
        assertEquals(year, date.getYear());
        assertEquals(month, date.getMonth());
        assertEquals(day, date.getDay());
    }

    protected void checkExercise(String name, int size, Exercise exercise) {
        assertEquals(name, exercise.getName());
        assertEquals(size, exercise.size());
    }

    protected void checkSet(int reps, int weight, String comment, Set set) {
        assertEquals(reps, set.getReps());
        assertEquals(weight, set.getWeight());
        assertEquals(comment, set.getComment());
    }
}
