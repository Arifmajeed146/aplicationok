package com.rentacar.rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class profile extends AppCompatActivity {


    TextView fnameTv;
    TextView lnameTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        fnameTv = findViewById(R.id.fisrtname);
        lnameTv = findViewById(R.id.lastname);

        setDetails();
    }

    private void setDetails() {
        Bundle abundle=getIntent().getExtras();
        String firstname=abundle.getString("email");
        String lasttname=abundle.getString("password");

        fnameTv.setText(firstname);
        lnameTv.setText(lasttname);
    }
}
