package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity implements View.OnClickListener {
//            ArrayList<String> al=new ArrayList<>();
            Button btnskip;
            TextView txtemail2,txtname2;
            String stremail,strname;
            SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "name";
    public static final String Email = "email";
    public static final String Phone = "phone";
    public static final String Pass = "pass";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        setContentView(R.layout.activity_profile);
        txtemail2=findViewById(R.id.txtemail2);
        txtname2=findViewById(R.id.txtname2);
        btnskip=findViewById(R.id.btnskip);
        btnskip.setOnClickListener(this);


        stremail= sharedPreferences.getString("email",stremail);
        strname= sharedPreferences.getString("name",strname);

//        stremail=getIntent().getStringExtra("Keyemail");
//        strname=getIntent().getStringExtra("Keyname");

        txtemail2.setText(stremail);
        txtname2.setText(strname);
//        txtemail2.setText(strname);

    }

    @Override
    public void onClick(View view) {
        Intent i= new Intent(Profile.this,splash_screen.class);
        startActivity(i);
    }
}