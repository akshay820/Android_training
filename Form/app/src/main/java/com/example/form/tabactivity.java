package com.example.form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.res.Resources;
import android.os.Bundle;

import com.example.form.adapter;
import com.google.android.material.tabs.TabLayout;

public class tabactivity extends AppCompatActivity {
        TabLayout tabLayout;
        ViewPager viewPager;

        int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabactivity);

        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Result"));
        tabLayout.addTab(tabLayout.newTab().setText("Rating"));

        final adapter adapter = new adapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public Resources.Theme getTheme() {
        Resources.Theme theme = super.getTheme();
        if(id==0)
        {
            theme.applyStyle(R.style.Widget_AppCompat_ActionBar_Solid, true);
        }
        else {
            theme.applyStyle(R.style.Theme_AppCompat_DayNight_NoActionBar, true);
        }

        return theme;
    }

}
