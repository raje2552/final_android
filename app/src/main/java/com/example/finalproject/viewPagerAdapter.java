package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class viewPagerAdapter extends FragmentStateAdapter {

    private mainFragment fragment1 = new mainFragment();
    private secoendFragment fragment2 = new secoendFragment();

    public viewPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return fragment1;
            case 1:
                return fragment2;
            default:
                return fragment1;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public secoendFragment getFragment2() {
        return fragment2;
    }
}
