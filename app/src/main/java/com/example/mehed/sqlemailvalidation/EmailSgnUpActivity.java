package com.example.mehed.sqlemailvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmailSgnUpActivity extends AppCompatActivity {

    private EditText username, email, password, name;
     Button btnSignUp;

    DataBaseHelper dataBaseHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sgn_up);
        username = findViewById(R.id.UsernameBT);
        email = findViewById(R.id.EmailBT);
        password = findViewById(R.id.PasswordBT);
        name = findViewById(R.id.NameBT);

        btnSignUp = findViewById(R.id.SignupBT);

        dataBaseHelper = new DataBaseHelper(this);

    }

    public void Save(View view) {
        String user = username.getText().toString();
        String emailAdd = email.getText().toString();
        String pass = password.getText().toString();
        String myName = name.getText().toString();

        PersonDetails personDetails = new PersonDetails(myName, emailAdd,user, pass);

        long rowid = dataBaseHelper.insertData(personDetails);
        if (rowid > 0) {
            Toast.makeText(this, "DATA is Inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "DATA is Not Inserted", Toast.LENGTH_SHORT).show();

        }

    }
}
