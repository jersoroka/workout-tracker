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

Note that the user stories involving sets were not implemented in the GUI but were implemented in the console program.

## Phase 4: Task 2

I refactored the Exercise class to be robust. The methods within this class that needed to be changed were:
- Exercise(String name)
- addSet(int reps, int weight, String comment)
- removeSet(int index)
- indexOf(Set set)
- getSet(int index)

Tests for the refactored methods are found in the ExerciseTest class.

## Phase 4: Task 3

If I had more time on the project, I would:
- Make the Date, Set, Workout, and WorkoutSet classes in model robust
- Make a GroupLayoutScreen super class for AddExercise, AddWorkout, and ViewWorkout and move initialization method into this class to reduce duplication
- Make a new Button subtype called ValidationButton which contains entry validation methods from AddExerciseSubmitButton, AddWorkoutSubmitButton, and EditNameAndDateSubmitButton to reduce duplication
- Remove console application (WorkoutLoggerApp and Main)
- Introduce an EditButton class that extends Button and is extended by deletefield and editfield package classes which includes a method that is used to refresh the cards to decrease code duplication.
- Refactor Button to not have a dependency on WorkoutSet as this can be accessed through GUI
- Make the navigation buttons a single class as they vary only in their label and what screen they bring the user

