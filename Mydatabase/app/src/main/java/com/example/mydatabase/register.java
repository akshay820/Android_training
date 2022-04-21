package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity {
        EditText name,email,pass;
        Button submit;
        database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        submit=findViewById(R.id.submit);
        db=new database(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.addContact(name.getText().toString(),email.getText().toString(),pass.getText().toString());
                Intent i= new Intent(register.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}