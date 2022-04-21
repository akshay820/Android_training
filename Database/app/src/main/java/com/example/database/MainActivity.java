package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername,edtMobile,edtMail,edtPass;
    Button btnLgn,btnSubmit;
    datahandler db;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new datahandler(this);
        edtUsername = findViewById(R.id.edtusername);
        edtMobile = findViewById(R.id.edtmobile);
        edtMail = findViewById(R.id.edtmail);
        edtPass = findViewById(R.id.edtpass);
        btnLgn = findViewById(R.id.btnlgn);
        btnSubmit = findViewById(R.id.btnsubmit);
        recyclerView=findViewById(R.id.recycleview);

        btnLgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login=new Intent(MainActivity.this,signin.class);
                startActivity(login);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if (checkValidation(edtUsername.getText().toString(), edtMobile.getText().toString(), edtMail.getText().toString(), edtPass.getText().toString()))
                    {
                        db.addContact(edtUsername.getText().toString(), edtMobile.getText().toString(), edtMail.getText().toString(), edtPass.getText().toString());
                        Intent intent = new Intent(MainActivity.this, details.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Please give Valid Input...!!", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
    public static boolean isValidphone(CharSequence target)
    {
        String  pattern = "(0/91)?[7-9][0-9]{9}";
        return false;
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


        public boolean checkValidation(String strname,String strmobile,String strmail,String strpass)
        {
            if(strname.matches(""))
            {
                edtUsername.setError("Enter Name...");
                return false;
            }else if (isValidphone(strmobile))
            {
                edtMobile.setError("Enter valid Mobile Number...");
                return false;
            }
            else if (strmobile.matches(""))
            {
                edtMobile.setError("Enter Mobile Number...");
                return false;
            }
            else if(strmail.matches(""))
            {
                edtMail.setError("Enter Value of Email");
                return false;
            }
            else if(!isValidEmail(strmail))
            {
                edtMail.setError("Enter valid Email");
                return false;
            }
            else if(!isValidPassword(strpass))
            {
                edtPass.setError("Enter valid password");
                return false;
            }
            else if(strpass.matches(""))
            {
                edtPass.setError("Enter Value of Password");
                return false;
            }
            else
            {
                return true;
            }
        }
    }
