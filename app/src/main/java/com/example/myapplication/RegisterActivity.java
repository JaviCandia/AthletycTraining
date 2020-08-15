package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Dataset.DaoUser;
import com.example.myapplication.Dataset.User;
import com.google.android.material.textfield.TextInputLayout;
import com.jaeger.library.StatusBarUtil;

import java.util.Calendar;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView reg_back;
    TextInputLayout nameField, emailField, passwordField, confirmField,  dateField;
    Spinner genreSpinner, countrySpinner, objectiveSpinner;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    Button signInButton, datePicker;
    DaoUser daoUser;

    int birth_day, birth_month, birth_year;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Para que el fondo se vea a pantalla completa
        getSupportActionBar().hide();
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(R.drawable.gradient_blue_black));
        StatusBarUtil.setTransparent(this);

        // Declaración de elementos
        reg_back = findViewById(R.id.reg_back);

        nameField = findViewById(R.id.reg_nameField);
        emailField = findViewById(R.id.reg_emailField);
        passwordField = findViewById(R.id.reg_passwordField);
        confirmField = findViewById(R.id.reg_confirmField);
        dateField = findViewById(R.id.reg_dateField);

        signInButton = findViewById(R.id.signInButton);
        datePicker = findViewById(R.id.date_picker_button);

        genreSpinner = (Spinner) findViewById(R.id.genre_spinner);
        countrySpinner = (Spinner) findViewById(R.id.country_spinner);
        objectiveSpinner = (Spinner) findViewById(R.id.objective_spinner);

        daoUser = new DaoUser(this);

        // Propiedades de spinner
        genreSpinner.setPopupBackgroundResource(R.color.colorDarkerGray);
        countrySpinner.setPopupBackgroundResource(R.color.colorDarkerGray);
        objectiveSpinner.setPopupBackgroundResource(R.color.colorDarkerGray);
        objectiveSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> genreAdapter = ArrayAdapter.createFromResource(this, R.array.genre_array, R.layout.spinner_item);
        genreAdapter.setDropDownViewResource(R.layout.spinner_item);
        genreSpinner.setAdapter(genreAdapter);

        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(this, R.array.country_array, R.layout.spinner_item);
        countryAdapter.setDropDownViewResource(R.layout.spinner_item);
        countrySpinner.setAdapter(countryAdapter);

        ArrayAdapter<CharSequence> objectiveAdapter = ArrayAdapter.createFromResource(this, R.array.objective_array, R.layout.spinner_item);
        objectiveAdapter.setDropDownViewResource(R.layout.spinner_item);
        objectiveSpinner.setAdapter(objectiveAdapter);

        // Propiedades para el botón de regresar
        reg_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Propiedades para la fecha
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        RegisterActivity.this,
                        android.R.style.Theme_Material_Light_Dialog_MinWidth,
                        dateSetListener,
                        year, month, day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                datePickerDialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month++;
                birth_day = dayOfMonth;
                birth_month = month;
                birth_year = year;
                dateField.getEditText().setText(dayOfMonth+"/"+month+"/"+year);
            }
        };

        // Se realiza el registro
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getEditText().getText().toString();
                String email = emailField.getEditText().getText().toString();
                String password = passwordField.getEditText().getText().toString();
                String confirm = confirmField.getEditText().getText().toString();
                String genre = genreSpinner.getSelectedItem().toString();
                String country = countrySpinner.getSelectedItem().toString();
                //String objective = objectiveSpinner.getSelectedItem().toString();
                String date = dateField.getEditText().getText().toString();

                if ( !validateMultiText(name, nameField, "Merlyn Romero Zamora") | !validateEmail(email) |
                     !validatePassword(password, passwordField) | !validateConfirm(password, confirm, confirmField) |
                     !validateDate(date, dateField, "03/03/1996")) {
                    return;
                } else {
                    User user = new User();
                    user.setFullName(name);
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setConfirmPassword(confirm);
                    user.setGenre(genre);
                    user.setCountry(country);
                    user.setObjective("");
                    user.setDay(birth_day);
                    user.setMonth(birth_month);
                    user.setYear(birth_year);
                    user.setInitialScore(0);
                    user.setMonitoringScore(0);
                    user.setTrainingDays(0);

                    if (daoUser.insertUser(user)) {
                        signInButton.setEnabled(false);
                        Toast.makeText(RegisterActivity.this, "Registro existoso", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                        Toast.makeText( RegisterActivity.this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    // Validaciones
    private boolean validateMultiText(String text, TextInputLayout field, String example) {
        boolean regex = Pattern.matches("^[a-zA-Zá-úÁ-Ú ]+$", text);

        if (text.isEmpty()) {
            field.setError("Campo vacío");
            return false;
        } else if (!regex) {
            field.setError(example);
            return false;
        } else {
            field.setError(null);
            field.setErrorEnabled(false);
            return true;
        }
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

    private boolean validatePassword(String text, TextInputLayout field) {
        if (text.isEmpty()) {
            field.setError("Campo vacío");
            return false;
        } else if (text.length()<5) {
            field.setError("Min. 5 caracteres");
            return false;
        } else {
            field.setError(null);
            field.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateConfirm(String pass, String confirm, TextInputLayout field) {
        if (confirm.isEmpty()) {
            field.setError("Campo vacío");
            return false;
        } else if (confirm.length()<5) {
            field.setError("Min. 5 caracteres");
            return false;
        } else if(!confirm.equals(pass)){
            field.setError("La contraseña no coincide");
            return false;
        } else {
            field.setError(null);
            field.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateDate(String text, TextInputLayout field, String example) {
        boolean regex = Pattern.matches("^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$", text);

        if (text.isEmpty()) {
            field.setError("Campo vacío");
            return false;
        } else if (!regex) {
            field.setError(example);
            return false;
        } else {
            //field.setError(null);
            field.setErrorEnabled(false);
            return true;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
