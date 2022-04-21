package com.example.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class viewholder extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context mcontaxt;
    viewholder(Context mcontaxt){
        this.mcontaxt = mcontaxt;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw,parent,false);
        return new FileLayoutHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((FileLayoutHolder)holder).text1.setText(Constant.allMedialist.get(position).getName());
        Uri uri =Uri.fromFile(Constant.allMedialist.get(position));
//        Glide.with(mcontaxt)
//                .load(uri).thumbnail(0.1f).into((FileLayoutHolder)holder).text1;


    }

    @Override
    public int getItemCount() {
        return 0;
    }
    class FileLayoutHolder extends RecyclerView.ViewHolder
    {
        TextView text1;
        Button btnplay;

        public FileLayoutHolder(@NonNull View itemView) {
            super(itemView);
            text1=itemView.findViewById(R.id.text1);
            btnplay=itemView.findViewById(R.id.btnplay);

        }
    }
}
