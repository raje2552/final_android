package com.example.finalproject;
import static com.example.finalproject.MainActivity.pagerAdapter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.finalproject.databinding.FragmentMainBinding;
import java.util.ArrayList;


public class mainFragment extends Fragment {

    public static ArrayList<Movie> moviesList = new ArrayList<>();
    public static ArrayList<Movie> seriesList = new ArrayList<>();
    public static ArrayList<Movie> ShortList = new ArrayList<>();

    FragmentMainBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(isConnectionNetwork()) {
            new fetch_Data(binding.editText.getText().toString(),getActivity()).execute();

        }else {
            Toast.makeText(getActivity(),
                            "please connection with network and try again" ,
                            Toast.LENGTH_LONG)
                    .show();
        }

        binding.button.setOnClickListener(v -> {
            FragmentSearch F_s = new FragmentSearch();
            pagerAdapter.setFragment1(F_s);

        });

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
