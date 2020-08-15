package com.example.myapplication.Dataset;

public class WorkoutItem {
    String exercise;
    int series;
    String reps;

    public WorkoutItem(String exercise, int series, String reps) {
        this.exercise = exercise;
        this.series = series;
        this.reps = reps;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }
}
