package com.example.finalproject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.example.finalproject.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    static ViewPager2 viewPager2 ;

    static viewPagerAdapter pagerAdapter;
    ArrayList<String> list = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list.add("main page ");
        list.add("detail item ");

        TabLayout tabLayout = binding.TabLayout;
        viewPager2 = binding.viewPager;


        pagerAdapter = new viewPagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);



        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(list.get(position));
        }).attach();
ccc

    }

}