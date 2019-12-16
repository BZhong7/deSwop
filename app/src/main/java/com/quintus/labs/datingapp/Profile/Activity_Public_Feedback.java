package com.quintus.labs.datingapp.Profile;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.quintus.labs.datingapp.Fragment_Your_Feedback;
import com.quintus.labs.datingapp.Fragment_Others_Feedback;
import com.quintus.labs.datingapp.R;
import com.quintus.labs.datingapp.Utils.FeedbackPagerAdapter;

public class Activity_Public_Feedback extends AppCompatActivity
        implements Fragment_Others_Feedback.OnFragmentInteractionListener,
                   Fragment_Your_Feedback.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_feedback);

        ViewPager viewPager = findViewById(R.id.publicpager);
        FeedbackPagerAdapter pagerAdapter = new FeedbackPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.publictabs);
        tabLayout.setupWithViewPager(viewPager, true);

    }

    public void onFragmentInteraction(Uri uri) {

    }
}
