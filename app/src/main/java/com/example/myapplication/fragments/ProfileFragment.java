package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.BottomActivity;
import com.example.myapplication.Dataset.DaoUser;
import com.example.myapplication.Dataset.User;
import com.example.myapplication.R;

import java.util.Calendar;

public class ProfileFragment extends Fragment {

    TextView textId, textName, textEmail, textPassword, textGenre, textCountry, textDate, textAge,
            textObjective, textInitialScore, textMonitoringScore, textTrainingDays;
    Button buttonObjective;

    private User user;
    private DaoUser daoUser;

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
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        textId = rootView.findViewById(R.id.profile_id);
        textName = rootView.findViewById(R.id.profile_name);
        textEmail = rootView.findViewById(R.id.profile_email);
        textPassword = rootView.findViewById(R.id.profile_password);
        textGenre = rootView.findViewById(R.id.profile_genre);
        textCountry = rootView.findViewById(R.id.profile_country);
        textDate = rootView.findViewById(R.id.profile_date);
        textAge = rootView.findViewById(R.id.profile_age);
        textObjective = rootView.findViewById(R.id.profile_objective);
        textInitialScore = rootView.findViewById(R.id.profile_initial);
        textMonitoringScore = rootView.findViewById(R.id.profile_monitoring);
        textTrainingDays = rootView.findViewById(R.id.profile_training_days);
        buttonObjective = rootView.findViewById(R.id.button_objective);

        textId.setText("Id: "+user.getId());
        textName.setText("Nombre: "+user.getFullName());
        textEmail.setText("Email: "+user.getEmail());
        textPassword.setText("Contraseña: "+user.getPassword());
        textGenre.setText("Género: " + user.getGenre());
        textCountry.setText("País: " + user.getCountry());
        textDate.setText("Nacimiento: "+user.getDay()+"/"+user.getMonth()+"/"+user.getYear());
        textAge.setText("Edad: " + getAge(user.getYear(), user.getMonth(), user.getDay()));
        textInitialScore.setText("Puntaje inicial: "+user.getInitialScore());
        textMonitoringScore.setText("Puntaje monitoreo: "+user.getMonitoringScore());
        textTrainingDays.setText("Días de entrenamiento: "+user.getTrainingDays());

        // CÓDIGO PARA BORRAR ------------ ----------------- --------------- -------------- -------------------------- -----
        // Aquí verifico el dato que me interesa, si no hay nada enseño otra cosa, un FRAGMENT por ejemplo
        if(user.getObjective().isEmpty())
            textObjective.setText("Sin Objetivo");
        else {
            textObjective.setText("Objetivo: " + user.getObjective());
            buttonObjective.setVisibility(View.INVISIBLE);
        }

        // aquí asigno el dato que falta, el cual era el objetivo
        buttonObjective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setObjective("Subir kilos");
                daoUser.updateUser(user);
                textObjective.setText("Objetivo: " + user.getObjective());
                buttonObjective.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "¡Objetivo insertado!", Toast.LENGTH_SHORT).show();
            }
        });
        // CÓDIGO PARA BORRAR ------------ ----------------- --------------- -------------- -------------------------- -----

        return rootView;
    }

    private String getAge(int year, int month, int day){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month-1, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }
}
