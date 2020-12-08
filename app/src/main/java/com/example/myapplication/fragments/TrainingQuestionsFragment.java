package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.BottomActivity;
import com.example.myapplication.Dataset.DaoUser;
import com.example.myapplication.Dataset.User;
import com.example.myapplication.R;


public class TrainingQuestionsFragment extends Fragment {

    Button initialButton, button3Days, button4Days, button5Days, button6Days;

    private User user;
    private DaoUser daoUser;

    public TrainingQuestionsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootview = inflater.inflate(R.layout.fragment_training_questions, container, false);

        // Obteniendo al usuario
        BottomActivity bottomActivity = (BottomActivity) getActivity();
        user = bottomActivity.getUser();
        daoUser = bottomActivity.getDaoUser();

        initialButton = rootview.findViewById(R.id.button_initial_score);
        // CÓDIGO PARA BORRAR ------------ ----------------- --------------- -------------- -------------------------- -----
        button3Days = rootview.findViewById(R.id.button_3Days);
        button4Days = rootview.findViewById(R.id.button_4Days);
        button5Days = rootview.findViewById(R.id.button_5Days);
        button6Days = rootview.findViewById(R.id.button_6Days);

        button3Days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setTrainingDays(3);
                //daoUser.updateUser(user);
            }
        });
        button4Days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setTrainingDays(4);
                //daoUser.updateUser(user);
            }
        });
        button5Days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setTrainingDays(5);
                //daoUser.updateUser(user);
            }
        });
        button6Days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setTrainingDays(6);
                //daoUser.updateUser(user);
            }
        });
        // CÓDIGO PARA BORRAR ------------ ----------------- --------------- -------------- -------------------------- -----

        initialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setInitialScore(3);
                user.setMonitoringScore(3);
                daoUser.updateUser(user);
                Toast.makeText(getActivity(), "Puntaje insertado!", Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return rootview;
    }
}
