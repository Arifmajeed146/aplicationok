package com.rentacar.rentacar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class singup extends AppCompatActivity {


    EditText emailEt;
    EditText passEt;
    EditText nameEt;
    EditText contactEt;
    FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference reference;
    private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        init();



    }

    private void init() {
        nameEt = findViewById(R.id.nameEt);
        emailEt = findViewById(R.id.emailEt);
        passEt = findViewById(R.id.passEt);
        contactEt = findViewById(R.id.contactEt);
        auth = FirebaseAuth.getInstance();
        database= FirebaseDatabase.getInstance();
        reference=database.getReference("User");




        public void singup(View view) {

            String email = emailEt.getText().toString();
            String pass = passEt.getText().toString();
            String name = nameEt.getText().toString();
            String contact = contactEt.getText().toString();

            if (email.isEmpty()) {
                emailEt.setError("Email required");
            } else if (pass.isEmpty()) {
                passEt.setError("Password required");
            } else {

                singup(email, pass, name, contact);




    }
}

    private void signupUser(final String email, final String pass, final String name, final String contact) {

            auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        //String key=reference.push().getKey();
                        String key=auth.getCurrentUser().getUid();
                        user user=new user(name,email,pass,contact);
                        reference.child(key).setValue(user);


                        Intent intent = new Intent(MainActivity.this, home.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}