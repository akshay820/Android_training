package com.example.form;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.form.Rating;
import com.example.form.Result;
import com.example.form.homefragment;

public class adapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public adapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                homefragment homeFragment = new homefragment();
                return homeFragment;
            case 1:
                Result resultFragment = new Result();
                return resultFragment;
            case 2:
                Rating ratingFragment = new Rating();
                return ratingFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
