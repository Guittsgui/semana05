package com.example.weekendfive.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.weekendfive.R;

public class MainActivity extends AppCompatActivity {


    Button initialButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialButton = findViewById(R.id.initialButton);

        initialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent( getApplicationContext() , menuActivity.class);
                startActivity(intent);

            }
        });

    }
}