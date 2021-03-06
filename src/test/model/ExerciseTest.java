package model;

import model.exceptions.EmptyStringException;
import model.exceptions.InvalidIndexException;
import model.exceptions.NegativeValueException;
import model.exceptions.ObjectDoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ExerciseTest {
    private Exercise testExercise;

    @BeforeEach
    void runBefore() {
        try {
            testExercise = new Exercise("Chest");
        } catch (EmptyStringException e) {
            fail("EmptyStringException should not be thrown.");
        }
    }

    @Test
    void testGetExerciseInfoNoSets() {
        assertEquals(testExercise.getName() + ": no sets completed", testExercise.getExerciseInfo());
    }

    @Test
    void testGetExerciseInfoOneSet() {
        try {
            testExercise.addSet(10, 135, "moves fast");
            assertEquals(testExercise.getName() + ": \nSet 1: " + testExercise.getSet(0).getSetInfo(),
                    testExercise.getExerciseInfo());
        } catch (NegativeValueException | InvalidIndexException e) {
            fail("Exception should not be thrown.");
        }
    }

    @Test
    void testGetExerciseInfoManySets() {
        try {
            testExercise.addSet(10, 135, "moves fast");
            testExercise.addSet(12, 185, "");
            testExercise.addSet(8, 225, "moves slow");
            assertEquals(testExercise.getName() + ": \nSet 1: " + testExercise.getSet(0).getSetInfo() +
                            "\nSet 2: " + testExercise.getSet(1).getSetInfo() +
                            "\nSet 3: " + testExercise.getSet(2).getSetInfo(),
                    testExercise.getExerciseInfo());
        } catch (NegativeValueException | InvalidIndexException e) {
            fail("Exception should not be thrown.");
        }
    }

    @Test
    void testAddSets() {
        try {
            testExercise.addSet(10, 225, "");
            assertEquals(1, testExercise.getSets().size());
            assertEquals("weight: 225, reps: 10, comment: none", testExercise.getSet(0).getSetInfo());
            testExercise.addSet(10, 315, "heavy");
            assertEquals(2, testExercise.getSets().size());
            assertEquals("weight: 315, reps: 10, comment: heavy", testExercise.getSet(1).getSetInfo());
        } catch (NegativeValueException | InvalidIndexException e) {
            fail("Exception should not be thrown.");
        }
    }

    @Test
    void testAddSetsThrowNegativeValueException() {
        try {
            testExercise.addSet(-10, 225, "");
            fail("NegativeValueException should be thrown.");
        } catch (NegativeValueException e) {
            // expected
        }

        try {
            testExercise.addSet(10, -225, "");
            fail("NegativeValueException should be thrown.");
        } catch (NegativeValueException e) {
            // expected
        }

        try {
            testExercise.addSet(-10, -225, "");
            fail("NegativeValueException should be thrown.");
        } catch (NegativeValueException e) {
            // expected
        }
        assertEquals(0, testExercise.getSets().size());
    }

    @Test
    void testRemoveSets() {
        try {
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
        } catch (NegativeValueException | InvalidIndexException e) {
            fail("Exception should not be thrown.");
        }
    }

    @Test
    void testRemoveSetsThrowsInvalidIndexException() {
        try {
            testExercise.addSet(5, 225, "RPE 9");
            testExercise.removeSet(-1);
            fail("InvalidIndexException should have been thrown.");
        } catch (NegativeValueException e) {
            fail("Exception should not be thrown.");
        } catch (InvalidIndexException e) {
            // expected
        }

        try {
            testExercise.removeSet(testExercise.size());
            fail("InvalidIndexException should have been thrown.");
        } catch (InvalidIndexException e) {
            // expected
        }

        assertEquals(1, testExercise.size());
    }


    @Test
    void testRemoveSetUsingSetArgument() {
        try {
            testExercise.addSet(12, 135, "");
            Set set = testExercise.getSet(0);
            testExercise.removeSet(set);
            assertEquals(0, testExercise.getSets().size());
        } catch (NegativeValueException | InvalidIndexException e) {
            fail("Exception should not be thrown.");
        }
    }

    @Test
    void testIndexOf() {
        try {
            testExercise.addSet(5, 225, "RPE 9");
            Set testSet = testExercise.getSet(0);
            testExercise.addSet(10, 225, "");
            assertEquals(0, testExercise.indexOf(testSet));
        } catch (NegativeValueException | InvalidIndexException | ObjectDoesNotExistException e) {
            fail("Exception should not be thrown.");
        }
    }

    @Test
    void testIndexOfThrowsObjectDoesNotExistException() {
        try {
            testExercise.addSet(5, 225, "RPE 9");
            Set testSet = new Set(12, 135, "");
            assertEquals(0, testExercise.indexOf(testSet));
            fail("ObjectDoesNotExistException show have been thrown.");
        } catch (NegativeValueException e) {
            fail("NegativeValueException should not be thrown.");
        } catch (ObjectDoesNotExistException e) {
            // expected
        }
    }

    @Test
    void testManySetsSize() {
        try {
            testExercise.addSet(10, 135, "easy");
            testExercise.addSet(10, 135, "");
            testExercise.addSet(12, 95, "AMRAP");
            assertEquals(3, testExercise.size());
        } catch (NegativeValueException e) {
            fail("Exception should not be thrown.");
        }
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

    @Test
    void testGetSet() {
        try {
            testExercise.addSet(5, 225, "RPE 9");
            Set testSet = testExercise.getSet(0);
            assertEquals(5, testSet.getReps());
            assertEquals(225, testSet.getWeight());
            assertEquals("RPE 9", testSet.getComment());
        } catch (NegativeValueException | InvalidIndexException e) {
            fail("Exception should not be thrown.");
        }
    }

    @Test
    void testGetSetThrowInvalidIndexException() {
        try {
            testExercise.addSet(5, 225, "RPE 9");
            Set testSet = testExercise.getSet(-1);
            fail("InvalidIndexException should be thrown.");
        } catch (InvalidIndexException e) {
            // expected
        } catch (NegativeValueException e) {
            fail("Exception should not be thrown");
        }

        try {
            testExercise.addSet(5, 225, "RPE 9");
            Set testSet = testExercise.getSet(testExercise.size());
            fail("InvalidIndexException should be thrown.");
        } catch (InvalidIndexException e) {
            // expected
        } catch (NegativeValueException e) {
            fail("Exception should not be thrown");
        }
    }


}
