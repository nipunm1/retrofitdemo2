package com.example.retrofitdemo2.adapter;

import android.app.Activity;
import android.drm.DrmStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitdemo2.R;
import com.example.retrofitdemo2.model.MyGit;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
Activity context;
    List<MyGit> list;
    public MyRecyclerAdapter(Activity context, List<MyGit> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.custome_recyclerview, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyGit myGit =list.get(position);
        holder.textView.setText(myGit.getLogin());
        holder.textView2.setText(myGit.getId()+"");
        Glide.with(context).load(myGit.getAvatarUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView,textView2;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.name);
            textView2 = itemView.findViewById(R.id.id);
            imageView = itemView.findViewById(R.id.avtar);
        }
    }
}
