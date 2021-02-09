package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest {
    private Workout testWorkout;

    @BeforeEach
    void runBefore() {

        testWorkout = new Workout(2021, 2, 5, "test");
        testWorkout.addExercise("Deadlifts");
        testWorkout.addExercise("Front squats");
    }

    @Test
    void testChangeDate() {
        testWorkout.changeDate(2020, 3, 19);
        assertEquals("2020-03-19", testWorkout.getDate());
    }

    @Test
    void testGetDate() {
        assertEquals("2021-02-05", testWorkout.getDate());
        testWorkout.changeDate(2020, 1, 20);
        assertEquals("2020-01-20", testWorkout.getDate());
        testWorkout.changeDate(2000, 10,30);
        assertEquals("2000-10-30", testWorkout.getDate());
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