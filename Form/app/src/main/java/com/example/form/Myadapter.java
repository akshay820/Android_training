//package com.example.form;
//
//import android.content.Context;
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//public class Myadapter extends FragmentPagerAdapter {
//    private Context mycontext;
//    int totaltabs;
//
//    public Myadapter (Context Context, FragmentManager fm,int totaltabs)
//    {
//        super(fm);
//        mycontext = Context;
//        this.totaltabs=totaltabs;
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position)
//        {
//            case 0:
//                homefragment homeFragment = new homefragment();
//                return homeFragment;
//            case 1:
//                Result resultFragment = new Result();
//                return resultFragment;
//            case 2:
//                Rating ratingFragment = new Rating();
//                return ratingFragment;
//            default:
//                return null;
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return totaltabs;
//    }
//}