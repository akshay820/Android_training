package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstPageOfClick extends AppCompatActivity {
    Button MainClick1, MainClick2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page_of_click);
        MainClick1 = findViewById(R.id.MainClick1);
        MainClick2 = findViewById(R.id.MainClick2);


        MainClick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Videos Added in Database",Toast.LENGTH_SHORT).show();
            }
        });

        MainClick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FirstPageOfClick.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}