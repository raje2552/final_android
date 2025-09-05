package com.example.finalproject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalproject.databinding.FragmentMainBinding;

import java.util.ArrayList;

public class mainFragment extends Fragment {

    public static ArrayList<Movie> moviesList = new ArrayList<>();
    public static ArrayList<Movie> seriesList = new ArrayList<>();
    public static ArrayList<Movie> ShortList = new ArrayList<>();
    FragmentMainBinding binding;

    public interface OnDataPass {
        void onDataPass(Movie data);
    }

    private OnDataPass dataPasser;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (isConnectionNetwork()) {
            new fetch_Data("war", getActivity()).execute();
            movies_Adapter adapter = new movies_Adapter(getActivity(), moviesList, title -> {
                if (dataPasser != null) {
                    dataPasser.onDataPass(title);
                }
            });

            binding.recycle.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.recycle.setAdapter(adapter);

        } else {
            Toast.makeText(getActivity(),
                    "please connect to network and try again",
                    Toast.LENGTH_LONG).show();
        }
    }

    private boolean isConnectionNetwork() {
        Context context = getActivity();
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = cm != null ? cm.getActiveNetworkInfo() : null;
            return ni != null && ni.isConnected();
        }
        return false;
    }
}
