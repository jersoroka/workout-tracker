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
    void testGetDate() {
        assertEquals("2021-02-05", testWorkout.getDate());
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
        testWorkout.addExercise("Chin ups");
        assertEquals("Push ups: no sets completed", testWorkout.getExercise(3).getExerciseInfo());
        assertEquals(4, testWorkout.size());
    }

    @Test
    void testRemoveExercise() {
        testWorkout.removeExercise(0);
        assertEquals(1, testWorkout.size());
        assertEquals("Deadlifts: no sets completed", testWorkout.getExercise(0).getExerciseInfo());
        testWorkout.getExercise(0).addSet(10, 225, "");
        testWorkout.addExercise("Deadlifts");
        assertEquals("Deadlifts: Set 1: weight: 225, reps: 10",
                testWorkout.getExercise(0).getExerciseInfo());
        testWorkout.removeExercise(1);
        assertEquals("Deadlifts: Set 1: weight: 225, reps: 10",
                testWorkout.getExercise(0).getExerciseInfo());
    }


}