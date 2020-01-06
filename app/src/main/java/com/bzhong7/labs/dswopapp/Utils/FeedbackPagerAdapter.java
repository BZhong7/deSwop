package com.bzhong7.labs.dswopapp.Utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bzhong7.labs.dswopapp.Fragment_Your_Feedback;
import com.bzhong7.labs.dswopapp.Fragment_Others_Feedback;

public class FeedbackPagerAdapter extends FragmentStatePagerAdapter {

    public FeedbackPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new Fragment_Others_Feedback();
            case 1: return new Fragment_Your_Feedback();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "Feedback from others";
            case 1: return "Your feedback";
            default: return null;
        }
    }
}
