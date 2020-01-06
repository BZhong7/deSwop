package com.bzhong7.labs.dswopapp.Profile;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.bzhong7.labs.dswopapp.Fragment_Private_Others;
import com.bzhong7.labs.dswopapp.Fragment_Private_Yours;
import com.bzhong7.labs.dswopapp.R;
import com.bzhong7.labs.dswopapp.Utils.FeedbackPrivatePagerAdapter;

public class Activity_Private_Feedback extends AppCompatActivity
        implements Fragment_Private_Others.OnFragmentInteractionListener,
                   Fragment_Private_Yours.OnFragmentInteractionListener {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_feedback);

        ViewPager viewPager = findViewById(R.id.privatepager);
        FeedbackPrivatePagerAdapter pagerAdapter = new FeedbackPrivatePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.privatetabs);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    public void onFragmentInteraction(Uri uri) {

    }
}
