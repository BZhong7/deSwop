package com.bzhong7.labs.dswopapp.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bzhong7.labs.dswopapp.R;

public class Location_Activity extends AppCompatActivity {
    private TextView eCountry, eCity, eState, eZipcode;
    private String country, city, state, zipcode;
    private Button btnChangeLocation;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_location);
        mContext = Location_Activity.this;
        //Log.d(TAG, "onCreate: started");

        initWidgets();
        init();
    }

    private void initWidgets() {
        eCountry = findViewById(R.id.edit_country);
        eCity = findViewById(R.id.edit_city);
        eState = findViewById(R.id.edit_state);
        eZipcode = findViewById(R.id.edit_zipcode);
        btnChangeLocation = findViewById(R.id.btnChangeLocation);
    }

    private void init() {
        btnChangeLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Location_Activity.this, Profile_Activity.class);
                startActivity(intent);
            }
        });
    }
}
