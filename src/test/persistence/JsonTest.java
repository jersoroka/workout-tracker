package persistence;

import model.*;
import model.exceptions.NegativeValueException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkWorkout(String name, int year, int month, int day, int size, Workout workout) {
        assertEquals(name, workout.getName());
        assertEquals(size, workout.size());

        Date date = workout.getDate();
        assertEquals(year, date.getYear());
        assertEquals(month, date.getMonth());
        assertEquals(day, date.getDay());
    }

    protected void checkExercise(String name, int size, Exercise exercise) {
        assertEquals(name, exercise.getName());
        assertEquals(size, exercise.size());
    }

    protected void checkSet(int reps, int weight, String comment, Set set) {
        assertEquals(reps, set.getReps());
        assertEquals(weight, set.getWeight());
        assertEquals(comment, set.getComment());
    }

    protected WorkoutSet makeWorkoutSet() {
        WorkoutSet workoutSet = new WorkoutSet();

        try {
            workoutSet.addWorkout(2021,2,27,"legs");
            Workout legsWorkout = workoutSet.getWorkout(0);
            legsWorkout.addExercise("front squats");
            Exercise frontSquats = legsWorkout.getExercise(0);
            frontSquats.addSet(10, 135,"warmup");
            frontSquats.addSet(10,155,"");
            legsWorkout.addExercise("leg curls");
            Exercise legCurls = legsWorkout.getExercise(1);
            legCurls.addSet(20,45,"");

            workoutSet.addWorkout(2021,2,28,"back");
            Workout backWorkout = workoutSet.getWorkout(1);
            backWorkout.addExercise("rows");
            Exercise rows = backWorkout.getExercise(0);
            rows.addSet(10, 75,"fast reps");
            rows.addSet(12,85,"");
        } catch (NegativeValueException e) {
            System.out.println("NegativeValueException caught.");
        }
        return workoutSet;
    }
}
