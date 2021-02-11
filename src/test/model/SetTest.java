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
        assertEquals("weight: 135, reps: 0, comment: touch and go", testSet.getSetInfo());
        testSet.setWeight(0);
        assertEquals("weight: 0, reps: 0, comment: touch and go", testSet.getSetInfo());
        testSet.setReps(10);
        assertEquals("weight: 0, reps: 10, comment: touch and go", testSet.getSetInfo());
    }

    @Test
    void testGetSetInfoEmpty() {
        testSet.setReps(0);
        testSet.setComment("");
        testSet.setWeight(0);
        assertEquals(" weight: 0, reps: 0", testSet.getSetInfo());
    }

    @Test
    void testGetSetRepsWeightComment() {
        assertEquals("weight: 135, reps: 10, comment: touch and go", testSet.getSetInfo());
    }

    @Test
    void testGetSetInfoNoComment(){
        testSet.setComment("");
        assertEquals("weight: 135, reps: 10", testSet.getSetInfo());
    }



}
