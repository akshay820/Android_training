package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.window.SplashScreen;

import java.util.ArrayList;

public class login extends AppCompatActivity implements View.OnClickListener{
//    ArrayList <String>a= new ArrayList();

    Button btnlgn;
    EditText edtemail,edtpass;
//    String em,ps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlgn=findViewById(R.id.btnlgn);
        edtemail=findViewById(R.id.edtemail);
        edtpass=findViewById(R.id.edtpass);


        btnlgn.setOnClickListener(this);

//        em=getIntent().getStringExtra("Keyemail");
//        ps=getIntent().getStringExtra("keypass");



    }

    @Override
    public void onClick(View view)
    {
        Intent i=new Intent(login.this, SplashScreen.class);
        startActivity(i);

    }
}