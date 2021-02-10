package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest {
    private Workout testWorkout;

    @BeforeEach
    void runBefore() {
        Date testDate = new Date(2021, 2, 5);
        testWorkout = new Workout(testDate, "test");
        testWorkout.addExercise("Deadlifts");
        testWorkout.addExercise("Front squats");
    }

    @Test
    void testGetDate() {
        Date date = testWorkout.getDate();
        assertEquals("2021-02-05", date.formatToString());

        date.setYear(2020);
        date.setMonth(1);
        date.setDay(20);
        assertEquals("2020-01-20", date.formatToString());

    }

    @Test
    void testSize() {
        assertEquals(2, testWorkout.size());
    }

    @Test
    void testAddExercise() {
        testWorkout.addExercise("Chin ups");
        assertEquals("Chin ups: no sets completed", testWorkout.getExercise(2).getExerciseInfo());
        assertEquals(3, testWorkout.size());
        testWorkout.addExercise("Push ups");
        assertEquals("Push ups: no sets completed", testWorkout.getExercise(3).getExerciseInfo());
        assertEquals(4, testWorkout.size());
    }

    @Test
    void testRemoveExercise() {
        testWorkout.removeExercise(0);
        assertEquals(1, testWorkout.size());
        assertEquals("Front squats: no sets completed", testWorkout.getExercise(0).getExerciseInfo());
        testWorkout.getExercise(0).addSet(10, 225, "");

        testWorkout.addExercise("Deadlifts");
        testWorkout.removeExercise(0);
        assertEquals("Deadlifts: no sets completed",
                testWorkout.getExercise(0).getExerciseInfo());
    }


}