package com.example.finalproject;

import android.app.Activity;
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
    private static ArrayList<Movie> data;
    private Activity context;
    private lisenerClick listener;

    public movies_Adapter(Activity context , ArrayList<Movie> data , lisenerClick listener){
        this.listener = listener;
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public movies_Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.card_view_item , parent , false);
        return new viewHolder(v , listener);
    }

    @Override
    public void onBindViewHolder(@NonNull movies_Adapter.viewHolder holder, int position) {
        Movie movie = data.get(position);
        holder.Title.setText(movie.getTitle_name());

        Glide.with(holder.itemView.getContext())
                .load(movie.getUrlPhoto())
                .placeholder(R.drawable.ic_launcher_background)  // صورة مؤقتة
                .error(R.drawable.ic_launcher_foreground)        // في حالة خطأ
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        private TextView Title ;
        private ImageView poster ;
        private CardView cardView;

        public viewHolder(@NonNull View itemView ,  lisenerClick listener) {
            super(itemView);
            Title = itemView.findViewById(R.id.title);
            poster = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.card_view);

            cardView.setOnClickListener(v -> {
                if (listener != null) {
                    int pos = getAdapterPosition();
                    if (pos != -1) {
                        System.out.println("thr ff (dfgd445t)d" + data.get(pos));
                        listener.onItemClick(data.get(pos));
                    }else {
                        listener.onItemClick(data.get(0));
                    }
                }
            });
        }
    }
}
