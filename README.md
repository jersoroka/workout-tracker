# Workout Journal

## About the Application

This application will be used to document workouts.

The application allows the user to describe a workout by:
- Date
- Name
- Exercises performed
 
 Additionally, the user will be able to describe the exercises done during the workout by:
 - Name 
 - Sets 
 - Repetitions 
 - Weight
 - Other personal notes about an exercise
 
## Who is the application for?

The application is for weightlifters that want to systematically document their workouts. 
By consistently logging their workouts, the user will be able to track their progress and have data to reflect on their own progress and fitness goals.

## Motivation

I enjoy exercising and there are many advantages to tracking progress, especially when it comes to identifying weak point and keeping yourself motivated. 
I want to make a project that aligns with my interests and is something useful.

## User Stories

- As a user, I want to be able to add a workout to my workout journal
- As a user, I want to be able to delete a workout from my workout journal
- As a user, I want to be able to modify the name, date, and exercises in a workout from my workout journal
- As a user, I want to be able to add an exercise to a workout in my workout journal
- As a user, I want to be able to delete an exercise from a workout in my workout journal
- As a user, I want to be able to modify the name and sets of exercise in a workout in my workout journal
- As a user, I want to be able to add a set to an exercise in a workout in my workout journal
- As a user, I want to be able to delete a set of an exercise in a workout in my workout journal
- As a user, I want to be able to modify the weight, reps, and comment of a set in an exercise in a workout in my workout journal
- As a user, I want to be able to save my workouts to a file
- As a user, I want to be able to load my workouts from a file

## Phase 4: Task 2

I refactored the Exercise class to be robust. The methods within this class that needed to be changed were:
- Exercise(String name)
- addSet(int reps, int weight, String comment)
- removeSet(int index)
- indexOf(Set set)
- getSet(int index)

Tests for the refactored methods are found in the ExerciseTest class.