package com.rentacar.rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class splash_screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Button button=findViewById(R.id.button_continue);

    }



        public void button_continue(View view){
            Intent intent = new Intent(splash_screen.this, MainActivity.class);
            startActivity(intent);





    }
}
