package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
    private Set testSet;

    @BeforeEach
    void runBefore(){
        testSet = new Set(10, 135, "touch and go");
    }

    @Test
    void testGetSetInfoNoRepsNoWeight() {
        testSet.setReps(0);
        assertEquals(" weight: 135, reps: 0, comment: touch and go", testSet.getSetInfo());
        testSet.setWeight(0);
        assertEquals(" weight: 0, reps: 0, comment: touch and go", testSet.getSetInfo());
        testSet.setReps(10);
        assertEquals(" weight: 0, reps: 10, comment: touch and go", testSet.getSetInfo());
    }

    @Test
    void testGetSetInfoEmpty() {
        testSet.setReps(0);
        testSet.setComment("");
        testSet.setWeight(0);
        assertEquals(" weight: 0, reps: 0, comment: none", testSet.getSetInfo());
    }

    @Test
    void testGetSetRepsWeightComment() {
        assertEquals(" weight: 135, reps: 10, comment: touch and go", testSet.getSetInfo());
    }

    @Test
    void testGetSetInfoNoComment(){
        testSet.setComment("");
        assertEquals(" weight: 135, reps: 10, comment: none", testSet.getSetInfo());
    }

    @Test
    void testSetReps() {
        testSet.setReps(5);
        assertEquals(5, testSet.getReps());
    }

    @Test
    void testSetWeight() {
        testSet.setWeight(100);
        assertEquals(100, testSet.getWeight());
    }

    @Test
    void testSetComment() {
        testSet.setComment("test comment");
        assertEquals("test comment", testSet.getComment());
    }



}
