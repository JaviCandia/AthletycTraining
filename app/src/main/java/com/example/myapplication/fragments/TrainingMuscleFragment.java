package com.example.myapplication.fragments;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.BottomActivity;
import com.example.myapplication.Dataset.DaoUser;
import com.example.myapplication.Dataset.FakeDBWorkout;
import com.example.myapplication.Dataset.ObjectWorkout;
import com.example.myapplication.Dataset.Series;
import com.example.myapplication.Dataset.User;
import com.example.myapplication.R;

import java.util.ArrayList;

public class TrainingMuscleFragment extends Fragment {

    TextView muscleName;

    final String BICEPS = "Bíceps", TRICEPS = "Tríceps", DELT_FRONTAL = "Deltoide frontal", DELT_LAT_POST = "Deltoides lateral y posterior",
            PECTORALES = "Pectorales", ESPALDA = "Espalda", TRAPECIO = "Trapecio", CUADRICEPS = "Cuadriceps", ISQUIOSURALES = "Isquiosurales",
            GLUTEOS = "Glúteos", PANTORRILLAS = "Pantorrillas", ABDOMEN = "Abdomen";

    final int SER_BICEPS = 10, SER_TRICEPS = 8, SER_DELT_FRONT = 8, SER_DELT_LAT_POST = 10, SER_PECTORALES = 12, SER_ESPALDA = 12,
            SER_TRAPECIO = 8, SER_CUADRICEPS = 10, SER_ISQUIO = 8, SER_GLUTEOS = 6, SER_PANTORRILLAS = 12, SER_ABDOMEN = 6;

    String receivedMuscle;
    int muscleIndex;

    User user;
    DaoUser daoUser;
    Series seriesUser;

    public TrainingMuscleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obteniendo al usuario
        BottomActivity bottomActivity = (BottomActivity) getActivity();
        user = bottomActivity.getUser();
        daoUser = bottomActivity.getDaoUser();
        seriesUser = bottomActivity.getSeriesUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_training_muscle, container, false);

        // Declaración
        muscleName = rootView.findViewById(R.id.muscle_name);

        // Extraigo los parámetros que recibo desde el adapter
        Bundle arguments = getArguments();
        receivedMuscle = arguments.getString("muscle");

        // Para filtrar los datos por músculo
        float series = 0;
        if (receivedMuscle.equals(BICEPS)) {
            muscleIndex = 0;
            series = SER_BICEPS;
        }
        else if (receivedMuscle.equals(TRICEPS)) {
            muscleIndex = 1;
            series = SER_TRICEPS;
        }
        else if (receivedMuscle.equals(DELT_FRONTAL)){
            muscleIndex = 2;
            series = SER_DELT_FRONT;
        }
        else if (receivedMuscle.equals(DELT_LAT_POST)) {
            muscleIndex = 3;
            series = SER_DELT_LAT_POST;
        }

        // Coloco el título del músculo
        muscleName.setText(receivedMuscle);

        TableLayout list = (TableLayout)rootView.findViewById(R.id.table);
        list.setStretchAllColumns(true);
        String [] array = {"Ejercicio", "Series", "Reps", "Peso"};
        TableRow row;
        TextView textView = null;
        EditText editText;

        Spinner test;

        // HEADERS de la tabla
        row = new TableRow(getActivity().getBaseContext());
        for (int j = 0; j<4; j++){
            textView = new TextView(getActivity().getBaseContext());
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setPadding(15, 15, 15, 15);
            textView.setText(array[j]);
            textView.setTextColor(Color.WHITE);
            Typeface typeface = ResourcesCompat.getFont(getActivity(), R.font.opensans_regular);
            textView.setTypeface(typeface);
            textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            row.addView(textView);
        }
        list.addView(row);

        // ------------------------------------------------------ OPERACIONES LOCAS ------------------------------------------------------
        // Obtengo los ejercicios
        ArrayList<ObjectWorkout> arrayList = (ArrayList<ObjectWorkout>) FakeDBWorkout.getWorkouts();

        // Sumando las series con el puntaje y redondeando por si el puntaje tiene decimal 0.5
        series += user.getInitialScore() + 9;

        if(series % 2 == 0.5F || series %2 == 1.5F)
            series += 0.5F;

        // Separando cuántas series al día hará dependiendo de los días de entrenamiento
        int seriesAlDia;
        if(user.getTrainingDays() == 3) {
            if(series % 3 == 1)
                series -= 1;
            else if (series %3 == 2)
                series +=1;

            seriesAlDia = (int) (series / 3);
        }
        else {
            if(series % 2 != 0)
                series += 1;

            seriesAlDia = (int) series / 2;
        }

        Toast.makeText(getActivity(), "Totales: " +series + " - Al día: "+seriesAlDia, Toast.LENGTH_SHORT).show();

        // ---------------------------------- SI ALGO QUIERES MODIFICAR QUE SEA AQUÍ PLOX ------------------------------------------------
        // CUERPO de la tabla
        int i = 0;
        int restador = arrayList.get(muscleIndex).getWorkoutItems().length-1;
        // Filas
        while (restador >= 0){
            row = new TableRow(getActivity().getBaseContext());
            // Columnas
            for (int j = 0; j<3; j++){
                // Declaración del textview y sus propiedades
                textView = new TextView(getActivity().getBaseContext());
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setPadding(15, 15, 15, 30);
                textView.setTextColor(Color.WHITE);
                Typeface typeface = ResourcesCompat.getFont(getActivity(), R.font.opensans_regular);
                textView.setTypeface(typeface);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
                textView.setSingleLine(false);

                test = new Spinner(getActivity().getBaseContext());
                // Info por posición de columna
                if(j == 0) {
                    textView.setText(arrayList.get(muscleIndex).getWorkoutItems()[i].getExercise());
                    textView.setId(j);
                }
                else if (j == 1) {
                    if(seriesAlDia >= 5)
                        textView.setText("" + 5);
                    else
                        textView.setText(""+seriesAlDia);
                }
                else if(j == 2)
                    textView.setText(arrayList.get(muscleIndex).getWorkoutItems()[i].getReps());
                // Agrego la info a cada fila
                row.addView(textView);
            }
            // Declaración del cuadro de texto y sus propiedades
            editText = new EditText(getActivity().getBaseContext());
            editText.setGravity(Gravity.CENTER_VERTICAL);
            //editText.setText(50 + "lb");
            editText.setText(textView.getText());
            editText.setTextColor(Color.WHITE);
            editText.getBackground().mutate().setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);
            // Lo agrego a la fila
            row.addView(editText);

            //Agrego la fila a las existentes
            list.addView(row);

            // Condición para saber cuántos ejercicios quedan
            if(seriesAlDia > 5)
                seriesAlDia -= 5;
            else
                seriesAlDia -= seriesAlDia;
            i++;
            restador --;
        }

        return rootView;
    }
}
