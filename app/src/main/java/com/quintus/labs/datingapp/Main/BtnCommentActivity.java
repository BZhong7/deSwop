package com.quintus.labs.datingapp.Main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.quintus.labs.datingapp.R;
import com.quintus.labs.datingapp.Utils.TopNavigationViewHelper;

public class BtnCommentActivity extends AppCompatActivity {
    private static final String TAG = "BtnCommentActivity";
    private static final int ACTIVITY_NUM = 1;
    private Context mContext = BtnCommentActivity.this;
    private ImageView comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_comment);

        setupTopNavigationView();
        comment = findViewById(R.id.comment);

        Intent intent = getIntent();
        String profileUrl = intent.getStringExtra("url");

        switch (profileUrl) {
            case "defaultFemale":
                Glide.with(mContext).load(R.drawable.default_woman).into(comment);
                break;
            case "defaultMale":
                Glide.with(mContext).load(R.drawable.default_man).into(comment);
                break;
            default:
                Glide.with(mContext).load(profileUrl).into(comment);
                break;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                Intent mainIntent = new Intent(BtnCommentActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        }).start();
    }


    private void setupTopNavigationView() {
        Log.d(TAG, "setupTopNavigationView: setting up TopNavigationView");
        BottomNavigationViewEx tvEx = findViewById(R.id.topNavViewBar);
        TopNavigationViewHelper.setupTopNavigationView(tvEx);
        TopNavigationViewHelper.enableNavigation(mContext, tvEx);
        Menu menu = tvEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
