package com.example.mydatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class adapter extends RecyclerView.Adapter<viewholder>
{
    ArrayList<usermodal> list;
    Context context;

    public adapter(ArrayList<usermodal> list,Context context)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public viewholder
    onCreateViewHolder(ViewGroup parent,int viewType)
    {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the layout
        View photoView = inflater.inflate(R.layout.raw, parent, false);

        viewholder viewHolder = new viewholder(photoView);
        return viewHolder;
    }

    @Override
    public void
    onBindViewHolder(final viewholder viewHolder,final int position)
    {
//        final index = viewHolder.getAdapterPosition();
        viewHolder.ename.setText(list.get(position).getName());
        viewHolder.eemail.setText(list.get(position).getEmail());
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

