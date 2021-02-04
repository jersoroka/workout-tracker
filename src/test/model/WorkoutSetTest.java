package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkoutSetTest {
    private WorkoutSet testWorkoutSet;

    @BeforeEach
    void runBefore() {
        testWorkoutSet = new WorkoutSet();
        testWorkoutSet.addWorkout(2021, 2, 3, "legs");
    }

    @Test
    void testAddWorkout() {
        testWorkoutSet.addWorkout(2021, 2, 3, "pull");
        assertEquals(2, testWorkoutSet.size());
        assertEquals("pull",  testWorkoutSet.getWorkout(1).getName());
        assertEquals("2021-02-03", testWorkoutSet.getWorkout(1).getDate());
        testWorkoutSet.addWorkout(2021, 2, 0, "arms");
        assertEquals(3, testWorkoutSet.size());
        assertEquals("arms",  testWorkoutSet.getWorkout(1).getName());
        assertEquals("2021-02-04", testWorkoutSet.getWorkout(1).getDate());
        testWorkoutSet.addWorkout(2020, 12, 11, "mobility");
        assertEquals(4, testWorkoutSet.size());
        assertEquals("mobility",  testWorkoutSet.getWorkout(1).getName());
        assertEquals("2020-12-11", testWorkoutSet.getWorkout(1).getDate());
    }

    @Test
    void testRemoveWorkout() {
        testWorkoutSet.removeWorkout(0);
        assertEquals(0, testWorkoutSet.size());
        testWorkoutSet.addWorkout(2020, 12, 1, "pull");
    }
}
