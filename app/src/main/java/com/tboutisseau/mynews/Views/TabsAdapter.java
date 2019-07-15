package com.tboutisseau.mynews.Views;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.tboutisseau.mynews.Controllers.Fragments.MostPopularFragment;
import com.tboutisseau.mynews.Controllers.Fragments.SportsFragment;
import com.tboutisseau.mynews.Controllers.Fragments.TopStoriesFragment;
import com.tboutisseau.mynews.R;

public class TabsAdapter extends FragmentPagerAdapter {

    private final int numberOfTabs = 3;

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 :
                return TopStoriesFragment.newInstance();
            case 1 :
                return MostPopularFragment.newInstance();
            case 2 :
                return SportsFragment.newInstance();
            default :
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0 :
                return "top stories";
            case 1 :
                return "most popular";
            case 2 :
                return "sports";
            default :
                return null;
        }
    }


}
