package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkoutSetTest {
    private WorkoutSet testWorkoutSet;

    @BeforeEach
    void runBefore() {
        testWorkoutSet = new WorkoutSet();
        testWorkoutSet.addWorkout(2021, 2, 3, "legs");
    }

    @Test
    void testAddWorkoutManyParamsManyValid() {
        assertTrue(testWorkoutSet.addWorkout(2021, 2, 3, "pull"));
        assertEquals(2, testWorkoutSet.size());
        assertEquals("pull", testWorkoutSet.getWorkout(1).getName());
        assertEquals("2021-02-03", testWorkoutSet.getWorkout(1).getDate().formatToString());

        assertTrue(testWorkoutSet.addWorkout(2021, 2, 4, "arms"));
        assertEquals(3, testWorkoutSet.size());
        assertEquals("arms", testWorkoutSet.getWorkout(2).getName());
        assertEquals("2021-02-04", testWorkoutSet.getWorkout(2).getDate().formatToString());

        assertTrue(testWorkoutSet.addWorkout(2020, 12, 11, "mobility"));
        assertEquals(4, testWorkoutSet.size());
        assertEquals("mobility", testWorkoutSet.getWorkout(3).getName());
        assertEquals("2020-12-11", testWorkoutSet.getWorkout(3).getDate().formatToString());
    }

    @Test
    void testAddWorkoutManyParamsInvalid() {
        assertFalse(testWorkoutSet.addWorkout(2021, 3, 33, "test workout"));
        assertEquals(1, testWorkoutSet.size());
    }

    @Test
    void testAddWorkoutObject() {
        Date testDate = new Date(2021, 2, 1);
        Workout testWorkout = new Workout(testDate, "chest");
        testWorkoutSet.addWorkout(testWorkout);
        assertEquals(2, testWorkoutSet.size());
    }

    @Test
    void testRemoveWorkoutMany() {
        testWorkoutSet.removeWorkout(0);
        assertEquals(0, testWorkoutSet.size());

        testWorkoutSet.addWorkout(2020, 12, 1, "pull");
        testWorkoutSet.addWorkout(2021, 2, 3, "pull");
        testWorkoutSet.addWorkout(2021, 2, 4, "arms");

        testWorkoutSet.removeWorkout(1);
        assertEquals(2, testWorkoutSet.size());
        assertEquals("2020-12-01", testWorkoutSet.getWorkout(0).getDate().formatToString());
        assertEquals("2021-02-04", testWorkoutSet.getWorkout(1).getDate().formatToString());
    }

    @Test
    void testIndexOf() {
        testWorkoutSet.addWorkout(2021, 2, 28, "chest");
        Workout workout = testWorkoutSet.getWorkout(1);
        assertEquals(1, testWorkoutSet.indexOf(workout));
    }

    @Test
    void testEmptyWorkoutsSize() {
        WorkoutSet testEmptyWorkouts = new WorkoutSet();
        assertEquals(0, testEmptyWorkouts.size());
    }

    @Test
    void testSize() {
        assertEquals(1, testWorkoutSet.size());
        testWorkoutSet.addWorkout(2020, 7, 4, "legs");
        assertEquals(2, testWorkoutSet.size());
    }

}
