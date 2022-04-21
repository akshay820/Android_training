package com.example.mydatabase;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewholder extends RecyclerView.ViewHolder
{
    TextView ename;
    TextView eemail;
    View view;

    public viewholder(View itemView) {
        super(itemView);
        ename=itemView.findViewById(R.id.ename);
        eemail=itemView.findViewById(R.id.eemail);
        view =itemView;
    }
}
