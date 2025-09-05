package com.example.finalproject;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class viewPagerAdapter extends FragmentStateAdapter {


    public viewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    Fragment fragment1 = new mainFragment();
     Fragment fragment2 = new secoendFragment();
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0){
            return fragment1;
        }else if (position == 1){
            return fragment2;
        }
        else {
            return null;
        }
    }

    public void setFragment1(Fragment fragment1) {
        this.fragment1 = fragment1;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
