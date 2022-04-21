package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
        Button first,second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first=findViewById(R.id.first);
        second=findViewById(R.id.second);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Path Sucessfull added", Toast.LENGTH_SHORT).show();

            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            private File u;
            private String[] storagePaths;
            @Override
            public void onClick(View view) {
                storagePaths = storage.getStorageDirectories(this);

                for (String path : storagePaths) {
                    u = new File(path);
                    Method.load_Directory_Files(u);
                }

                Intent i=new Intent(MainActivity.this,recycle.class);
                startActivity(i);

            }
        });

    }
}