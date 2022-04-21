package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        RecyclerView recycle;
        Button back,home;
        adapter adapter;
        ArrayList<usermodal>al = new ArrayList<>();
        database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycle=findViewById(R.id.recycle);
        back=findViewById(R.id.back);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,home.class);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,register.class);
                startActivity(intent);
            }
        });

      db=new database(this);
      al=db.getAllContacts();
      adapter= new adapter(al,MainActivity.this);
      recycle.setAdapter(adapter);
      recycle.setLayoutManager(new LinearLayoutManager(MainActivity.this));



    }
}