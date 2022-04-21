package com.example.recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        mylistdata[] myListData = new mylistdata[] {
                new mylistdata("Email", android.R.drawable.ic_dialog_email),
                new mylistdata("Info", android.R.drawable.ic_dialog_info),
                new mylistdata("Delete", android.R.drawable.ic_delete),
                new mylistdata("Dialer", android.R.drawable.ic_dialog_dialer),
                new mylistdata("Alert", android.R.drawable.ic_dialog_alert),
                new mylistdata("Map", android.R.drawable.ic_dialog_map),
                new mylistdata("Speak", android.R.drawable.ic_btn_speak_now),
                new mylistdata("Email", android.R.drawable.ic_dialog_email),
                new mylistdata("Info", android.R.drawable.ic_dialog_info),
                new mylistdata("Delete", android.R.drawable.ic_delete),
                new mylistdata("Dialer", android.R.drawable.ic_dialog_dialer),
                new mylistdata("Alert", android.R.drawable.ic_dialog_alert),
                new mylistdata("Map", android.R.drawable.ic_dialog_map),
                new mylistdata("Speak", android.R.drawable.ic_btn_speak_now),

        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter adapter = new adapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}

