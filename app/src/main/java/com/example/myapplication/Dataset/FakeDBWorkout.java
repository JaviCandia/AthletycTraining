package com.example.myapplication.Dataset;

import java.util.ArrayList;
import java.util.List;

public class FakeDBWorkout {

    static List<ObjectWorkout> workoutList = new ArrayList<ObjectWorkout>();

    static String BICEPS = "Bíceps", TRICEPS = "Tríceps", DELT_FRONTAL = "Deltoide frontal", DELT_LAT_POST = "Deltoides lateral y posterior",
            PECTORALES = "Pectorales", ESPALDA = "Espalda", TRAPECIO = "Trapecio", CUADRICEPS = "Cuadriceps", ISQUIOSURALES = "Isquiosurales",
            GLUTEOS = "Glúteos", PANTORRILLAS = "Pantorrillas", ABDOMEN = "Abdomen";

    static int SER_BICEPS = 10, SER_TRICEPS = 8, SER_DELT_FRONT = 8, SER_DELT_LAT_POST = 10, SER_PECTORALES = 12, SER_ESPALDA = 12,
            SER_TRAPECIO = 8, SER_CUADRICEPS = 10, SER_ISQUIO = 8, SER_GLUTEOS = 6, SER_PANTORRILLAS = 12, SER_ABDOMEN = 6;

    public static List getWorkouts() {

        // 1 BICEPS
        WorkoutItem[] bicepsItems = new WorkoutItem[9];
        bicepsItems[0] = new WorkoutItem("Curl de biceps\ncon supinación", SER_BICEPS, "8 a 10");
        bicepsItems[1] = new WorkoutItem("Curl de bíceps\nconcentrado con\napoyo en muslo", SER_BICEPS, "8 a 10");
        bicepsItems[2] = new WorkoutItem("Curl de bíceps\nalterno tipo\nmartillo", SER_BICEPS, "6 a 8");
        bicepsItems[3] = new WorkoutItem("Curl de bíceps\ncon polea", SER_BICEPS, "10 a 12");
        bicepsItems[4] = new WorkoutItem("Brazos en cruz\ncon polea alta", SER_BICEPS, "15 a 20");
        bicepsItems[5] = new WorkoutItem("Curl de bíceps\ncon barra", SER_BICEPS, "6 a 8");
        bicepsItems[6] = new WorkoutItem("Bíceps en el banco\nscott con barra", SER_BICEPS, "8 a 10");
        bicepsItems[7] = new WorkoutItem("Curl de bíceps\nen el banco scott\ncon mancuerna", SER_BICEPS, "10 a 12");
        bicepsItems[8] = new WorkoutItem("Curl de biceps\ncon barra y agarre\nen pronación", SER_BICEPS, "8 a 10");
        workoutList.add(new ObjectWorkout(0, BICEPS, bicepsItems));

        // 2 TRICEPS
        WorkoutItem[] tricepsItems = new WorkoutItem[11];
        tricepsItems[0] = new WorkoutItem("Extensiones de triceps en polea alta con cuerda", SER_TRICEPS, "15 a 20");
        tricepsItems[1] = new WorkoutItem("Extensiones de triceps en polea alta, agarre en pronación", SER_TRICEPS, "10 a 12");
        tricepsItems[2] = new WorkoutItem("Extensiones de triceps en polea alta, agarre invertido o en supinacion", SER_TRICEPS, "12 a 15");
        tricepsItems[3] = new WorkoutItem("Extension alternada de los codos en polea alta, manos en supinacion", SER_TRICEPS, "12 a 15");
        tricepsItems[4] = new WorkoutItem("Press frances en banco plano", SER_TRICEPS, "6 a 8");
        tricepsItems[5] = new WorkoutItem("Press frances en banco plano con mancuernas", SER_TRICEPS, "8 a 10");
        tricepsItems[6] = new WorkoutItem("Copa con mancuerna a 1 mano", SER_TRICEPS, "8 a 10");
        tricepsItems[7] = new WorkoutItem("Copa con mancuerna con 2 manos", SER_TRICEPS, "6 a 8");
        tricepsItems[8] = new WorkoutItem("Copa, sentado con barra", SER_TRICEPS, "8 a 10");
        tricepsItems[9] = new WorkoutItem("Extension alternada de los codos con mancuerna, tronco inclinado hacia adelante", SER_TRICEPS, "10 a 12");
        tricepsItems[10] = new WorkoutItem("Dippings entre 2 bancos ", SER_TRICEPS, "8 a 10");
        workoutList.add(new ObjectWorkout(1, TRICEPS, tricepsItems));

        // 3 DELTOIDE FRONTAL
        WorkoutItem[] deltoide_frontal = new WorkoutItem[7];
        deltoide_frontal[0] = new WorkoutItem("Press frontal con barra", SER_DELT_FRONT, "6 a 8");
        deltoide_frontal[1] = new WorkoutItem("Press sentado con mancuernas", SER_DELT_FRONT, "6 a 8");
        deltoide_frontal[2] = new WorkoutItem("Press frontal con rotacion de la muñeca", SER_DELT_FRONT, "8 a 10");
        deltoide_frontal[3] = new WorkoutItem("Elevaciones frontales con mancuerna", SER_DELT_FRONT, "10 a 12");
        deltoide_frontal[4] = new WorkoutItem("Elevaciones frontales con barra", SER_DELT_FRONT, "10 a 12");
        deltoide_frontal[5] = new WorkoutItem("Elevaciones frontales con polea baja", SER_DELT_FRONT, "12 a 15");
        deltoide_frontal[6] = new WorkoutItem("Elevaciones frontales con disco", SER_DELT_FRONT, "15 a 20");
        workoutList.add(new ObjectWorkout(2, DELT_FRONTAL, deltoide_frontal));

        WorkoutItem[] delt_lateral_post = new WorkoutItem[10];
        delt_lateral_post[0] = new WorkoutItem("Remo al menton con barra z", SER_DELT_LAT_POST, "6 a 8");
        delt_lateral_post[1] = new WorkoutItem("Remo al menton con barra plana", SER_DELT_LAT_POST, "6 a 8");
        delt_lateral_post[2] = new WorkoutItem("Remo al menton con polea baja", SER_DELT_LAT_POST, "8 a 10");
        delt_lateral_post[3] = new WorkoutItem("Elevaciones laterales con mancuernas", SER_DELT_LAT_POST, "10 a 12");
        delt_lateral_post[4] = new WorkoutItem("Elevaciones laterales, tronco inclinado hacia delante", SER_DELT_LAT_POST, "10 a 12");
        delt_lateral_post[5] = new WorkoutItem("Elevaciones laterales, acostado de lado", SER_DELT_LAT_POST, "12 a 15");
        delt_lateral_post[6] = new WorkoutItem("Elevaciones laterales con polea baja", SER_DELT_LAT_POST, "15 a 20");
        delt_lateral_post[7] = new WorkoutItem("Flyes agachado con mancuerna", SER_DELT_LAT_POST, "10 a 12");
        delt_lateral_post[8] = new WorkoutItem("Flyes agachado con poleas", SER_DELT_LAT_POST, "15 a 20");
        delt_lateral_post[9] = new WorkoutItem("Peck deck invertido", SER_DELT_LAT_POST, "10 a 12");
        workoutList.add(new ObjectWorkout(3, DELT_LAT_POST, delt_lateral_post));

        return workoutList;
    }
}
