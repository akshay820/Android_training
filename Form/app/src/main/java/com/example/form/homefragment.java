package com.example.form;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class homefragment extends Fragment implements View.OnClickListener{
    TextView textname2,textemail2,textmobile2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_homefragment, container, false);
    }

    @Override
    public void onClick(View view) {

    }
}