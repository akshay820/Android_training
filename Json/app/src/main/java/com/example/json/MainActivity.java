package com.example.json;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    String url1 = "https://i.stack.imgur.com/7HfWF.png";
    String url2 = "https://qphs.fs.quoracdn.net/main-qimg-8e203d34a6a56345f86f1a92570557ba.webp";
    String url3 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
        SliderView sliderView = findViewById(R.id.slider);
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(1);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId())
            {
                case R.id.nav_account:
                    Intent intent = new Intent(MainActivity.this,homepage.class);
                    startActivity(intent);
                    break;
                case R.id.nav_settings:
                    Intent i = new Intent(MainActivity.this,Setting.class);
                    startActivity(i);
                    break;
                case R.id.nav_logout:
                    Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_Register:
                    Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                    break;

            }
                return false;
            }


        });

    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.nevigation_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        //Menu item clickable
//        if (id == R.id.nav_account) {
//
//            Intent intent = new Intent(this,homepage.class);
//            this.startActivity(intent);
//            return true;
//        }
//
//        if (id == R.id.nav_settings) {
//        Intent i = new Intent(MainActivity.this,Setting.class);
//        startActivity(i);
//            return true;
//        }
//
//        if (id == R.id.nav_logout) {
//            Toast.makeText(this, "Android Menu is Clicked", Toast.LENGTH_LONG).show();
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    return false;
    }
}