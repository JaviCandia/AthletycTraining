package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Dataset.DaoUser;
import com.example.myapplication.Dataset.FakeDb;
import com.example.myapplication.Dataset.User;
import com.google.android.material.textfield.TextInputLayout;
import com.jaeger.library.StatusBarUtil;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextInputLayout emailField, passwordField;
    TextView loginText, recoverText;
    Button signInButton;
    DaoUser daoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Para que el fondo se vea a pantalla completa
        getSupportActionBar().hide();
        StatusBarUtil.setTransparent(this);

        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        signInButton = findViewById(R.id.loginButton);
        loginText = findViewById(R.id.loginText);
        recoverText = findViewById(R.id.recoverText);

        daoUser = new DaoUser(this);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getEditText().getText().toString();
                String password = passwordField.getEditText().getText().toString();

                if (!validateEmail(email) | !validatePassword(password)) {
                    return;
                } else {
                    if (daoUser.login(email, password) == 1){
                        signInButton.setEnabled(false);
                        User user = daoUser.getUser(email, password);
                        Intent intent = new Intent(MainActivity.this, BottomActivity.class);
                        intent.putExtra("id", user.getId());
                        startActivity(intent);
                        finish();
                    }
                    else
                        Toast.makeText(MainActivity.this, "Correo o contraseña inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), RegisterActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        recoverText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Recuperar contraseña", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateEmail(String text) {
        boolean regex = Pattern.matches(String.valueOf(Patterns.EMAIL_ADDRESS), text);

        if (text.isEmpty()) {
            emailField.setError("Campo vacío");
            return false;
        } else if (!regex) {
            emailField.setError("Ej: Jorgito@hotmail.com");
            return false;
        } else {
            emailField.setError(null);
            emailField.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword(String text) {
        if (text.isEmpty()) {
            passwordField.setError("Campo vacío");
            return false;
        } else {
            passwordField.setError(null);
            passwordField.setErrorEnabled(false);
            return true;
        }
    }


    /*
    Dejo este código solamente como referencia
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                articleAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

     */
}
