package com.quintus.labs.datingapp.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.quintus.labs.datingapp.R;

public class Activity_Select_Feedback extends AppCompatActivity {

    private Button pubReview, priReview;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_feedback);

        pubReview = findViewById(R.id.see_public_feedback);
        pubReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Select_Feedback.this, Activity_Public_Feedback.class);
                startActivity(intent);
            }
        });

        priReview = findViewById(R.id.see_private_feedback);
        priReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Select_Feedback.this, Activity_Private_Feedback.class);
                startActivity(intent);
            }
        });
    }
}
