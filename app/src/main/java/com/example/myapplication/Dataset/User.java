package com.example.myapplication.Dataset;

public class User {
    int id, day, month, year, trainingDays;
    String fullName, email, password, confirmPassword, genre, country, objective;
    float initialScore, monitoringScore;

    public User() {
    }

    public User(String fullName, String email, String password, String confirmPassword, String genre,
                String country, int day, int month, int year, String objective, float initialScore, float monitoringScore, int trainingDays) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.genre = genre;
        this.country = country;
        this.day = day;
        this.month = month;
        this.year = year;
        this.objective = objective;
        this.initialScore = initialScore;
        this.monitoringScore = monitoringScore;
        this.trainingDays = trainingDays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public float getInitialScore() {
        return initialScore;
    }

    public void setInitialScore(float initialScore) {
        this.initialScore = initialScore;
    }

    public float getMonitoringScore() {
        return monitoringScore;
    }

    public void setMonitoringScore(float monitoringScore) {
        this.monitoringScore = monitoringScore;
    }

    public int getTrainingDays() {
        return trainingDays;
    }

    public void setTrainingDays(int trainingDays) {
        this.trainingDays = trainingDays;
    }
}
