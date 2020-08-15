package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.Adapter.DayAdapter;
import com.example.myapplication.BottomActivity;
import com.example.myapplication.Dataset.DaoUser;
import com.example.myapplication.Dataset.User;
import com.example.myapplication.Model.CardModel;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Random;


public class TrainingFragment extends Fragment {

    RecyclerView recyclerView;
    DayAdapter dayAdapter;

    User user;
    DaoUser daoUser;

    public TrainingFragment() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_training, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Si viene vacío el puntaje inicial, dirigir a las preguntas iniciales
        if (user.getInitialScore() == 0)
            Navigation.findNavController(view).navigate(R.id.action_trainingFragment_to_trainingQuestionsFragment);
        else
            dayAdapter = new DayAdapter(getActivity(), getMyList());

        // Configurando el recycler para mostrar los días a entrenar
        recyclerView = view.findViewById(R.id.trainingRecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(dayAdapter);

    }

    private ArrayList<CardModel> getMyList() {
        ArrayList<CardModel> models = new ArrayList<>();

        CardModel m;

        for (int i = 0; i < user.getTrainingDays(); i++) {
            m = new CardModel();
            m.setTitle("Día " + (i + 1));
            m.setColor(getColor());
            models.add(m);
        }

        return models;
    }

    public int getColor() {
        int color = 0;
        Random rn = new Random();
        int selection = rn.nextInt(3 - 1) + 1;
        switch (selection) {
            case 1:
                color = R.color.transparent_blue;
                break;
            case 2:
                color = R.color.transparent_grey;
                break;
        }
        return color;
    }
}
