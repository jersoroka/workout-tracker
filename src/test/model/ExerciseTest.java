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
    void testGetExerciseInfoNoSets() {
        assertEquals(testExercise.getName() + ": no sets completed", testExercise.getExerciseInfo());
    }

    @Test
    void testGetExerciseInfoOneSet() {
        testExercise.addSet(10, 135, "moves fast");
        assertEquals(testExercise.getName() + ": \nSet 1: " + testExercise.getSet(0).getSetInfo(),
                testExercise.getExerciseInfo());
    }

    @Test
    void testGetExerciseInfoManySets() {
        testExercise.addSet(10, 135, "moves fast");
        testExercise.addSet(12, 185, "");
        testExercise.addSet(8, 225, "moves slow");
        assertEquals(testExercise.getName() + ": \nSet 1: " + testExercise.getSet(0).getSetInfo() +
                        "\nSet 2: " + testExercise.getSet(1).getSetInfo() +
                        "\nSet 3: " + testExercise.getSet(2).getSetInfo(),
                testExercise.getExerciseInfo());

    }

    @Test
    void testAddSets() {
        testExercise.addSet(10, 225, "");
        assertEquals(1, testExercise.getSets().size());
        assertEquals("weight: 225, reps: 10, comment: none", testExercise.getSet(0).getSetInfo());
        testExercise.addSet(10, 315, "heavy");
        assertEquals(2, testExercise.getSets().size());
        assertEquals("weight: 315, reps: 10, comment: heavy", testExercise.getSet(1).getSetInfo());
    }

    @Test
    void testRemoveSets() {
        testExercise.addSet(5, 225, "RPE 9");
        testExercise.addSet(5, 200, "RPE 7");
        testExercise.addSet(10, 100, "AMRAP");

        testExercise.removeSet(0);
        assertEquals(2, testExercise.getSets().size());
        assertEquals("weight: 200, reps: 5, comment: RPE 7", testExercise.getSet(0).getSetInfo());
        assertEquals("weight: 100, reps: 10, comment: AMRAP", testExercise.getSet(1).getSetInfo());

        testExercise.removeSet(0);
        assertEquals(1, testExercise.getSets().size());
        assertEquals("weight: 100, reps: 10, comment: AMRAP", testExercise.getSet(0).getSetInfo());

        testExercise.removeSet(0);
        assertEquals(0, testExercise.getSets().size());
    }

    @Test
    void testIndexOf() {
        testExercise.addSet(5, 225, "RPE 9");
        Set testSet = testExercise.getSet(0);
        testExercise.addSet(10, 225, "");
        assertEquals(0, testExercise.indexOf(testSet));
    }

    @Test
    void testManySetsSize() {
        testExercise.addSet(10, 135, "easy");
        testExercise.addSet(10, 135, "");
        testExercise.addSet(12, 95, "AMRAP");
        assertEquals(3, testExercise.size());
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
