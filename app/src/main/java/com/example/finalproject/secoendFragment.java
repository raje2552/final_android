package com.example.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.finalproject.databinding.FragmentSecoendBinding;

public class secoendFragment extends Fragment {

    private TextView textView;
    FragmentSecoendBinding binding ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSecoendBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    public void updateData(Movie movie) {
            binding.titleTad2.setText(movie.getTitle_name());
            binding.yearTad.setText(movie.getYear());
            Glide.with(getActivity().getApplicationContext())
                .load(movie.getUrlPhoto())
                .placeholder(R.drawable.ic_launcher_background)  // صورة مؤقتة
                .error(R.drawable.ic_launcher_foreground)        // في حالة خطأ
                .into(binding.imageView2);

    }
}
