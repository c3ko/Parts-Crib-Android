package com.partscrib.partscribmanagementsystem;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.partscrib.partscribmanagementsystem.ui.main.PartsFragment;

public class HomeTabsAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 4;

    int mNumOfTabs;
    public HomeTabsAdapter(FragmentManager fm){
        super(fm);

    }
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                PartsFragment parts = new PartsFragment();
                return parts;

            default:
                return null;
        }
    }
}
