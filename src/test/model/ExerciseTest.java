package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseTest {
    private Exercise testExercise;

    @BeforeEach
    void runBefore() {
        testExercise = new Exercise("Chest");
    }

    @Test
    void testEmptySetsSize() {
        assertEquals(0, testExercise.size());
    }

    @Test
    void testManySetsSize() {
        testExercise.addSet(10, 135, "easy");
        testExercise.addSet(10, 135, "");
        testExercise.addSet(12, 95, "AMRAP");
        assertEquals(3, testExercise.size());
    }

    @Test
    void testAddSets() {
        testExercise.addSet(10, 225, "");
        assertEquals(1, testExercise.getSets().size());
        assertEquals("weight: 225, reps: 10", testExercise.getSet(0).getSetInfo());
        testExercise.addSet(10, 315, "");
        assertEquals(2, testExercise.getSets().size());
        assertEquals("weight: 315, reps: 10", testExercise.getSet(1).getSetInfo());
    }

    @Test
    void testRemoveSets() {
        testExercise.addSet(5, 225, "RPE 9");
        testExercise.addSet(5, 200, "RPE 7");
        assertEquals("weight: 225, reps: 5, comment: RPE 9", testExercise.getSet(0).getSetInfo());
        assertEquals("weight: 200, reps: 5, comment: RPE 7", testExercise.getSet(1).getSetInfo());
        testExercise.removeSet(0);
        assertEquals(1, testExercise.getSets().size());
        assertEquals("weight: 200, reps: 5, comment: RPE 7", testExercise.getSet(0).getSetInfo());
        testExercise.removeSet(0);
        assertEquals(0, testExercise.getSets().size());
    }

    @Test
    void testGetExerciseInfo() {
        // !!!
    }

    @Test
    void testGetName() {
        assertEquals("Chest", testExercise.getName());
    }

    @Test
    void testSetName() {
        testExercise.setName("Legs");
        assertEquals("Legs", testExercise.getName());
    }


}
