package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.lang.reflect.Method;

public class recycle extends AppCompatActivity {
        RecyclerView recycle;
        Button btnplay;
        viewholder viewholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recycle=findViewById(R.id.recycle);
        btnplay=findViewById(R.id.btnplay);
        recycle.setLayoutManager(new LinearLayoutManager(this));

        viewholder=new viewholder(this);
        recycle.setAdapter(viewholder);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}