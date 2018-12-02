package com.example.mehed.sqlemailvalidation;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Username, Password;
    Button Signin, Signup;


    private DataBaseHelper dataBaseHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = findViewById(R.id.btUsername);
        Password = findViewById(R.id.btPassword);

        Signin = findViewById(R.id.SignBT);
        Signup = findViewById(R.id.btSignUp);

        Signin.setOnClickListener(this);
        Signup.setOnClickListener(this);

        dataBaseHelper = new DataBaseHelper(this);
    }

    @Override
    public void onClick(View v) {
        String username = Username.getText().toString();
        String password = Password.getText().toString();

        if (v.getId() == R.id.SignBT) {
            boolean result = dataBaseHelper.FINDPASS(username, password);

            if (result) {
                Intent intent = new Intent(this, WellcomeActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "etUsername Or etPassword is not correct", Toast.LENGTH_SHORT).show();
            }


        } else if (v.getId() == R.id.btSignUp) {
            Intent intent = new Intent(MainActivity.this, EmailSgnUpActivity.class);
            startActivity(intent);

        }
    }

}
