package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class myAdapter extends RecyclerView.Adapter<myAdapter.viewHolder> {
    Example examples;
    Context context;

    public myAdapter(Example examples, Context context) {
        this.examples = examples;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.tv_rl_name.setText(examples.getArticles().get(position).getSource().getName());
        holder.tv_rl_description.setText(examples.getArticles().get(position).getDescription());
        Glide
                .with(context)
                .load(examples.getArticles().get(position).getUrlToImage())
                .centerCrop()
                .into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return examples.getArticles().size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tv_rl_name,tv_rl_description;
        ImageView iv;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tv_rl_name = itemView.findViewById(R.id.tv_rl_name);
            tv_rl_description = itemView.findViewById(R.id.tv_rl_description);
            iv = itemView.findViewById(R.id.iv);


        }
    }
}
