package com.example.myapplication.Dataset;

import android.opengl.GLU;

public class Series {
    int biceps;
    int triceps;
    int deltFront;
    int deltLatPost;
    int pectorales;
    int espalda;
    int trapecio;
    int cuadriceps;
    int isquiosurales;
    int gluteos;
    int pantorrillas;
    int abdomen;

    final String BICEPS = "Bíceps", TRICEPS = "Tríceps", DELT_FRONTAL = "Deltoide frontal", DELT_LAT_POST = "Deltoides lateral y posterior",
            PECTORALES = "Pectorales", ESPALDA = "Espalda", TRAPECIO = "Trapecio", CUADRICEPS = "Cuadriceps", ISQUIOSURALES = "Isquiosurales",
            GLUTEOS = "Glúteos", PANTORRILLAS = "Pantorrillas", ABDOMEN = "Abdomen";


    public Series(int biceps, int triceps, int deltFront, int deltLatPost, int pectorales, int espalda, int trapecio, int cuadriceps, int isquiosurales, int gluteos, int pantorrillas, int abdomen) {
        this.biceps = biceps;
        this.triceps = triceps;
        this.deltFront = deltFront;
        this.deltLatPost = deltLatPost;
        this.pectorales = pectorales;
        this.espalda = espalda;
        this.trapecio = trapecio;
        this.cuadriceps = cuadriceps;
        this.isquiosurales = isquiosurales;
        this.gluteos = gluteos;
        this.pantorrillas = pantorrillas;
        this.abdomen = abdomen;
    }

    public Series() {

    }

    public int getSeriesPro(String muscle){
        switch (muscle) {
            case BICEPS: return biceps;
            case TRICEPS: return triceps;
            case DELT_FRONTAL: return deltFront;
            case DELT_LAT_POST: return deltLatPost;
            case PECTORALES: return pectorales;
            case ESPALDA: return espalda;
            case TRAPECIO: return trapecio;
            case CUADRICEPS: return cuadriceps;
            case ISQUIOSURALES: return isquiosurales;
            case GLUTEOS: return gluteos;
            case PANTORRILLAS: return pantorrillas;
            case ABDOMEN: return abdomen;
            default: return 0;
        }
    }

    public void setSeriesPro(String muscle, int series){
        switch (muscle) {
            case BICEPS: this.biceps = series;
            case TRICEPS: this.triceps = series;
            case DELT_FRONTAL: this.deltFront = series;
            case DELT_LAT_POST: this.deltLatPost = series;
            case PECTORALES: this.pectorales = series;
            case ESPALDA: this.espalda = series;
            case TRAPECIO: this.trapecio = series;
            case CUADRICEPS: this.cuadriceps = series;
            case ISQUIOSURALES: this.isquiosurales = series;
            case GLUTEOS: this.gluteos = series;
            case PANTORRILLAS: this.pantorrillas = series;
            case ABDOMEN: this.abdomen = series;
        }
    }

    public int getBiceps() {
        return biceps;
    }

    public void setBiceps(int biceps) {
        this.biceps = biceps;
    }

    public int getTriceps() {
        return triceps;
    }

    public void setTriceps(int triceps) {
        this.triceps = triceps;
    }

    public int getDeltFront() {
        return deltFront;
    }

    public void setDeltFront(int deltFront) {
        this.deltFront = deltFront;
    }

    public int getDeltLatPost() {
        return deltLatPost;
    }

    public void setDeltLatPost(int deltLatPost) {
        this.deltLatPost = deltLatPost;
    }

    public int getPectorales() {
        return pectorales;
    }

    public void setPectorales(int pectorales) {
        this.pectorales = pectorales;
    }

    public int getEspalda() {
        return espalda;
    }

    public void setEspalda(int espalda) {
        this.espalda = espalda;
    }

    public int getTrapecio() {
        return trapecio;
    }

    public void setTrapecio(int trapecio) {
        this.trapecio = trapecio;
    }

    public int getCuadriceps() {
        return cuadriceps;
    }

    public void setCuadriceps(int cuadriceps) {
        this.cuadriceps = cuadriceps;
    }

    public int getIsquiosurales() {
        return isquiosurales;
    }

    public void setIsquiosurales(int isquiosurales) {
        this.isquiosurales = isquiosurales;
    }

    public int getGluteos() {
        return gluteos;
    }

    public void setGluteos(int gluteos) {
        this.gluteos = gluteos;
    }

    public int getPantorrillas() {
        return pantorrillas;
    }

    public void setPantorrillas(int pantorrillas) {
        this.pantorrillas = pantorrillas;
    }

    public int getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(int abdomen) {
        this.abdomen = abdomen;
    }
}
