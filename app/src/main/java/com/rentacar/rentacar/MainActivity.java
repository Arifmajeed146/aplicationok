package com.rentacar.rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText emailEt;
    EditText passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        
        emailEt=findViewById(R.id.emailEt);
        passwordEt=findViewById(R.id.passwordEt);
    }

    private void getDetails() {


        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();

        if (email.isEmpty()) {
            emailEt.setError("Email Required");
        }
        else if (password.isEmpty()) {
            passwordEt.setError("Password Required");
        }
        else {
            Intent ProfileIntent = new Intent(MainActivity.this, profile.class);
            ProfileIntent.putExtra("email",email);
            ProfileIntent.putExtra("password",password);
            startActivity(ProfileIntent);
        }


    }


    private void init() {

        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
    }

    public void login(View view) {

        getDetails();

    }
}
