package com.example.finalproject;

import static com.example.finalproject.MainActivity.viewPager2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class movies_Adapter extends RecyclerView.Adapter<movies_Adapter.viewHolder> {
    private ArrayList<Movie> data;
    private Activity context;

    public movies_Adapter(Activity context , ArrayList<Movie> data){
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public movies_Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.card_view_item , parent , false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull movies_Adapter.viewHolder holder, int position) {
        holder.Title.setText(data.get(position).getTitle_name());
        Glide.with(holder.itemView.getContext())
                .load(data.get(position).getUrlPhoto())
                .placeholder(R.drawable.ic_launcher_background)  //  photo temporary
                .error(R.drawable.ic_launcher_foreground)      // in case error
                .into(holder.poster);


        holder.cardView.setOnClickListener(v -> {
            viewPager2.setCurrentItem(1,false);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        private TextView Title ;
        private ImageView poster ;
        private CardView cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.title);
            poster = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
