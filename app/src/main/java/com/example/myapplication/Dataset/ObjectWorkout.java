package com.example.myapplication.Dataset;

public class ObjectWorkout {
    int id;
    String muscle;
    WorkoutItem [] workoutItems;

    public ObjectWorkout(int id, String muscle, WorkoutItem[] workoutItems) {
        this.id = id;
        this.muscle = muscle;
        this.workoutItems = workoutItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public WorkoutItem[] getWorkoutItems() {
        return workoutItems;
    }

    public void setWorkoutItems(WorkoutItem[] workoutItems) {
        this.workoutItems = workoutItems;
    }
}
