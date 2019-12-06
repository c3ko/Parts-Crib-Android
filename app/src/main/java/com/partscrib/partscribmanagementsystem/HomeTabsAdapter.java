package com.partscrib.partscribmanagementsystem;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.partscrib.partscribmanagementsystem.ui.main.AccountFragment;
import com.partscrib.partscribmanagementsystem.ui.main.HelpFragment;
import com.partscrib.partscribmanagementsystem.ui.main.NewsFragment;
import com.partscrib.partscribmanagementsystem.ui.main.RequestsFragment;

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
                NewsFragment parts = new NewsFragment();
                return parts;
            case 1:
                RequestsFragment requests = new RequestsFragment();
                return requests;
            case 2:
                AccountFragment accounts = new AccountFragment();
                return accounts;
            case 3:
                HelpFragment help = new HelpFragment();
                return help;
            default:
                return new NewsFragment();
        }
    }
}
