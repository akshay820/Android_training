package com.example.map;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button btnalarm;
    EditText edttime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edttime=findViewById(R.id.edttime);
        btnalarm=findViewById(R.id.btnalarm);
        btnalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAlarm();
            }
        });
    }
    public void startAlarm(){

        int i=0;
        if(!edttime.getText().toString().equalsIgnoreCase("")){
            i = Integer.parseInt(edttime.getText().toString());
        }


        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 12, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set in " + i + " seconds",Toast.LENGTH_LONG).show();
    }
}