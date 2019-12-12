package com.quintus.labs.datingapp.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.quintus.labs.datingapp.Login.RegisterBasicInfo;
import com.quintus.labs.datingapp.Login.RegisterUserInfo;
import com.quintus.labs.datingapp.Main.MainActivity;
import com.quintus.labs.datingapp.R;
import com.quintus.labs.datingapp.Utils.GPS;

public class EditProfileActivity extends AppCompatActivity {

    private TextView cUsername, cPassword, cEmail, cPhone;
    private String username, password, email, phone;
    private Button btnSaveChanges;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        mContext = EditProfileActivity.this;
        //Log.d(TAG, "onCreate: started");

        initWidgets();
        init();
    }

    private void initWidgets() {
        cUsername = findViewById(R.id.edit_username);
        cPassword = findViewById(R.id.edit_password);
        cEmail = findViewById(R.id.edit_email);
        cPhone = findViewById(R.id.edit_phone);
        btnSaveChanges = findViewById(R.id.btnSaveChanges);
    }

    private void init() {
        btnSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EditProfileActivity.this, Profile_Activity.class);
                startActivity(intent);
            }
        });
    }
}
