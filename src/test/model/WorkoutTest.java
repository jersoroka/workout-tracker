package model;

import model.exceptions.NegativeValueException;
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
        try {
            testWorkout.getExercise(0).addSet(10, 225, "");
        } catch (NegativeValueException e) {
            fail("NegativeValueException should not be thrown.");
        }

        testWorkout.addExercise("Deadlifts");
        testWorkout.removeExercise(0);
        assertEquals("Deadlifts: no sets completed",
                testWorkout.getExercise(0).getExerciseInfo());
    }

    @Test
    void testIndexOf() {
        Exercise testExercise1 = testWorkout.getExercise(0);
        assertEquals(0, testWorkout.indexOf(testExercise1));

        Exercise testExercise2 = testWorkout.getExercise(1);
        assertEquals(1, testWorkout.indexOf(testExercise2));
    }


    @Test
    void testSize() {
        assertEquals(2, testWorkout.size());
    }

    @Test
    void testSetDateValid() {
        Date testDate = new Date(2020, 11, 30);
        assertTrue(testWorkout.setDate(testDate));
        assertEquals(11, testWorkout.getDate().getMonth());
        assertEquals(30, testWorkout.getDate().getDay());
        assertEquals(2020, testWorkout.getDate().getYear());
    }

    @Test
    void testSetDateInvalid() {
        Date testDate = new Date(2020, 11, 32);
        assertFalse(testWorkout.setDate(testDate));
        assertEquals(2, testWorkout.getDate().getMonth());
        assertEquals(5, testWorkout.getDate().getDay());
        assertEquals(2021, testWorkout.getDate().getYear());
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
    void testSetName() {
        testWorkout.setName("changed name");
        assertEquals("changed name", testWorkout.getName());
    }

    @Test
    void testGetExercises() {
        assertEquals(2, testWorkout.getExercises().size());
    }

}