package com.example.myapplication;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.Dataset.DaoUser;
import com.example.myapplication.Dataset.FakeDb;
import com.example.myapplication.Dataset.Series;
import com.example.myapplication.Dataset.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jaeger.library.StatusBarUtil;

public class BottomActivity extends AppCompatActivity {

    int id = 0;
    private User user;
    private DaoUser daoUser;
    private Series seriesUser;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        getWindow().setStatusBarColor(getResources().getColor(R.color.solid_deeper_blue));
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_blue_black));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);


        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
            }
        });

        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");
        daoUser = new DaoUser(this);
        user = daoUser.getUserById(id);
        seriesUser = new Series(0,0,0,0,0,0,0,0,0,0,0,0);

        // Borrar esto
        Toast.makeText(this, "Bienvenido: " + user.getFullName(), Toast.LENGTH_LONG).show();
    }

    public User getUser(){
        return user;
    }

    public DaoUser getDaoUser(){
        return daoUser;
    }
    public Series getSeriesUser() { return seriesUser; }
}
