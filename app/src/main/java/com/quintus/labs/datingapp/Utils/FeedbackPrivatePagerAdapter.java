package com.quintus.labs.datingapp.Utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.quintus.labs.datingapp.Fragment_Private_Others;
import com.quintus.labs.datingapp.Fragment_Private_Yours;

public class FeedbackPrivatePagerAdapter extends FragmentStatePagerAdapter {

    public FeedbackPrivatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new Fragment_Private_Others();
            case 1: return new Fragment_Private_Yours();
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
