package com.example.finalproject;

import static com.example.finalproject.mainFragment.moviesList;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.finalproject.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements mainFragment.OnDataPass {

    ActivityMainBinding binding;
    public static ViewPager2 viewPager2 ;
    public static viewPagerAdapter pagerAdapter;
    public static int  count = 0;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list.add("main page");
        list.add("detail item");

        TabLayout tabLayout = binding.TabLayout;
        viewPager2 = binding.viewPager;

        pagerAdapter = new viewPagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(list.get(position));
        }).attach();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 1){
                    if (count == 0){
                        onDataPass(moviesList.get(0));
                    }
                    count++;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onDataPass(Movie data) {
        secoendFragment fragment2 = (secoendFragment) pagerAdapter.getFragment2();
            fragment2.updateData(data);
            viewPager2.setCurrentItem(1, true);
    }
}
