package com.example.recycle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder>
{
        private mylistdata[] listdata;


        public adapter(mylistdata[] listdata)
        {
            this.listdata = listdata;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.raw, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;



        }

        @Override
        public void onBindViewHolder(ViewHolder holder,int position)
        {

            final mylistdata myListData = listdata[position];
            holder.textView.setText(listdata[position].getDescription());
            holder.imageView.setImageResource(listdata[position].getImgId());
            holder.btndetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
        @Override
        public int getItemCount() {
            return listdata.length;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder
        {
            public ImageView imageView;
            public  Button btndetails;
            public TextView textView;
            public RelativeLayout relativeLayout;
            public ViewHolder(View itemView)
            {
                super(itemView);
                this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
                this.textView = (TextView) itemView.findViewById(R.id.textView);
                relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
            }
        }


}

