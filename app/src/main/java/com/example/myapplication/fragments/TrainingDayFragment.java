package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Adapter.MuscleAdapter;
import com.example.myapplication.BottomActivity;
import com.example.myapplication.Dataset.DaoUser;
import com.example.myapplication.Dataset.User;
import com.example.myapplication.Model.CardModel;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Random;

public class TrainingDayFragment extends Fragment {

    TextView trainingDayName;
    RecyclerView recyclerView;
    MuscleAdapter muscleAdapter;

    User user;
    DaoUser daoUser;

    final String BICEPS = "Bíceps", TRICEPS = "Tríceps", DELT_FRONTAL = "Deltoide frontal", DELT_LAT_POST = "Deltoides lateral y posterior",
            PECTORALES = "Pectorales", ESPALDA = "Espalda", TRAPECIO = "Trapecio", CUADRICEPS = "Cuadriceps", ISQUIOSURALES = "Isquiosurales",
            GLUTEOS = "Glúteos", PANTORRILLAS = "Pantorrillas", ABDOMEN = "Abdomen";

    public TrainingDayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obteniendo al usuario
        BottomActivity bottomActivity = (BottomActivity) getActivity();
        user = bottomActivity.getUser();
        daoUser = bottomActivity.getDaoUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_training_day, container, false);

        // Declaración de componentes
        trainingDayName = rootView.findViewById(R.id.training_dayName);

        // Extraigo los parámetros que recibo desde el adapter
        Bundle arguments = getArguments();
        String dayName = arguments.getString("dayName");
        int dayPosition = arguments.getInt("dayPosition");

        // Empiezo a asignar data
        recyclerView = rootView.findViewById(R.id.training_day_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Dependiendo del número de días de entrenamiento, se elige el getMyList
        switch (user.getTrainingDays()) {
            case 3: muscleAdapter = new MuscleAdapter(getActivity(), getMyList3Days()); break;
            case 4: muscleAdapter = new MuscleAdapter(getActivity(), getMyList4Days(dayPosition)); break;
            case 5: muscleAdapter = new MuscleAdapter(getActivity(), getMyList5Days(dayPosition)); break;
            case 6: muscleAdapter = new MuscleAdapter(getActivity(), getMyList6Days(dayPosition)); break;
        }
        recyclerView.setAdapter(muscleAdapter);

        trainingDayName.setText(dayName);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private ArrayList<CardModel> getMyList3Days() {
        ArrayList<CardModel> models = new ArrayList<>();

        CardModel m;

        m = new CardModel();
        m.setTitle(BICEPS);
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(TRICEPS);
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(DELT_FRONTAL);
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(DELT_LAT_POST);
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(PECTORALES);
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(ESPALDA);
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(TRAPECIO);
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(CUADRICEPS);
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(ISQUIOSURALES);
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(GLUTEOS);
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(PANTORRILLAS);
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(ABDOMEN);
        m.setColor(getColor());
        models.add(m);

        return models;
    }

    private ArrayList<CardModel> getMyList4Days(int dayPosition) {
        ArrayList<CardModel> models = new ArrayList<>();

        CardModel m;

        if (dayPosition == 0 || dayPosition == 2) {
            m = new CardModel();
            m.setTitle(PECTORALES);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(ESPALDA);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(BICEPS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(TRICEPS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(DELT_FRONTAL);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(TRAPECIO);
            m.setColor(getColor());
            models.add(m);
        } else if (dayPosition == 1 || dayPosition == 3) {
            m = new CardModel();
            m.setTitle(CUADRICEPS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(ISQUIOSURALES);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(DELT_LAT_POST);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(PANTORRILLAS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(GLUTEOS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(ABDOMEN);
            m.setColor(getColor());
            models.add(m);
        }

        return models;
    }

    private ArrayList<CardModel> getMyList5Days(int dayPosition) {
        ArrayList<CardModel> models = new ArrayList<>();

        CardModel m;

        if(dayPosition == 0){
            m = new CardModel();
            m.setTitle(PECTORALES);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(TRICEPS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(DELT_FRONTAL);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(ABDOMEN);
            m.setColor(getColor());
            models.add(m);
        } else if (dayPosition == 1){
            m = new CardModel();
            m.setTitle(ESPALDA);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(BICEPS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(TRAPECIO);
            m.setColor(getColor());
            models.add(m);
        } else if (dayPosition == 2 || dayPosition == 4){
            m = new CardModel();
            m.setTitle(CUADRICEPS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(ISQUIOSURALES);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(DELT_LAT_POST);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(PANTORRILLAS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(GLUTEOS);
            m.setColor(getColor());
            models.add(m);

            if( dayPosition == 4) {
                m = new CardModel();
                m.setTitle(ABDOMEN);
                m.setColor(getColor());
                models.add(m);
            }
        } else if (dayPosition == 3){
            m = new CardModel();
            m.setTitle(PECTORALES);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(ESPALDA);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(BICEPS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(TRICEPS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(DELT_FRONTAL);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(TRAPECIO);
            m.setColor(getColor());
            models.add(m);
        }

        return models;
    }

    private ArrayList<CardModel> getMyList6Days(int dayPosition) {
        ArrayList<CardModel> models = new ArrayList<>();

        CardModel m;

        if(dayPosition == 0 || dayPosition == 3){
            m = new CardModel();
            m.setTitle(PECTORALES);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(TRICEPS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(DELT_FRONTAL);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(ABDOMEN);
            m.setColor(getColor());
            models.add(m);
        } else if(dayPosition == 1 || dayPosition == 4){
            m = new CardModel();
            m.setTitle(ESPALDA);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(BICEPS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(TRAPECIO);
            m.setColor(getColor());
            models.add(m);
        } else if(dayPosition == 2 || dayPosition == 5){
            m = new CardModel();
            m.setTitle(CUADRICEPS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(ISQUIOSURALES);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(DELT_LAT_POST);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(PANTORRILLAS);
            m.setColor(getColor());
            models.add(m);

            m = new CardModel();
            m.setTitle(GLUTEOS);
            m.setColor(getColor());
            models.add(m);
        }

        return models;
    }

    public int getColor() {
        int color = 0;
        Random rn = new Random();
        int selection = rn.nextInt(6 - 1) + 1;
        switch (selection) {
            case 1: color = R.color.transparent_blue; break;
            case 2: color = R.color.transparent_green; break;
            case 3: color = R.color.transparent_magenta; break;
            case 4: color = R.color.transparent_red; break;
            case 5: color = R.color.transparent_violet; break;
        }
        return color;
    }
}