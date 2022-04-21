package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> al=new ArrayList<>();
    String email, password;
    Button btnsubmit;
    EditText txtemail,txtpass,txtname,txtphone;
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "name";
    public static final String Email = "email";
    public static final String Phone = "phone";
    public static final String Pass = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsubmit=findViewById(R.id.btnsubmit);
        txtemail=findViewById(R.id.txtemail);
        txtpass=findViewById(R.id.txtpass);
        txtname=findViewById(R.id.txtname);
        txtphone=findViewById(R.id.txtphone);
        btnsubmit.setOnClickListener(this);


        }

    @Override
    public void onClick(View view) {
        
           if (CheckValidation(txtemail.getText().toString(),txtpass.getText().toString(),txtname.getText().toString(),txtphone.getText().toString()))
                    {
                    String email = txtemail.getText().toString();
                    String pass = txtpass.getText().toString();
                    Intent i = new Intent(MainActivity.this, Profile.class);
                    i.putExtra("Keyemail", email);
                    i.putExtra("Keypass", pass);


                    SharedPreferences sharedPreferences = getSharedPreferences("MyPref",MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    myEdit.putString("name", txtname.getText().toString());
                    myEdit.putString("email",txtemail.getText().toString());
                    myEdit.putString("pass",txtpass.getText().toString());
                    myEdit.putString("phone",txtphone.getText().toString());
                    myEdit.apply();
                    startActivity(i);
                    }
                else
                    {
                        return;
                    }

    }
    public static boolean isValidName(CharSequence target)
    {
        return (!TextUtils.isEmpty(target) );
    }
    public static boolean isValidMobileNo(String str)
    {
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = ptrn.matcher(str);
        return (match.find() && match.group().equals(str));
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }


    public boolean CheckValidation(String email, String password,String name,String phone )
    {
        if (name.matches(""))
            {
            txtname.setError("Enter name");
            return  false;
            }
        else if (phone.matches(""))
            {
            txtphone.setError("Enter Phone Number");
            return  false;
            }
        else if(email.matches(""))
            {
            txtemail.setError("Enter Email...");
            return false;
            }
        else if(!isValidEmail(email))
            {
            txtemail.setError("Enter Email Address Properly...");
            return false;
            }
        else if (password.matches(""))
            {
            txtpass.setError("Enter Password...");
            return false;
            }
        else  if(!isValidPassword(password))
            {
            txtpass.setError("Enter Password Properly...");
            return false;
            }
        else
            {
                return  true;
            }
    }
}
