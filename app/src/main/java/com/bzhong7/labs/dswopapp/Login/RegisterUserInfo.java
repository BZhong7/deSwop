package com.bzhong7.labs.dswopapp.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.bzhong7.labs.dswopapp.Main.MainActivity;
import com.bzhong7.labs.dswopapp.R;

public class RegisterUserInfo extends AppCompatActivity {

    private Context mContext;
    private String username, password, country, city, state, zipcode;
    private EditText mUsername, mPassword, mCountry, mCity, mState, mZipcode;
    private Button btnComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_userinfo);
        initWidgets();
        init();
    }

    private void init() {
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegisterUserInfo.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    /*private boolean checkInputs(String email, String phone) {
        Log.d(TAG, "checkInputs: checking inputs for null values.");
        if (email.equals("") && phone.equals("")) {
            Toast.makeText(mContext, "Email or Phone fields must be filled out.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Below code checks if the email id is valid or not.
        if (!email.equals("") && !email.matches(emailPattern)) {
            Toast.makeText(getApplicationContext(), "Invalid email address, enter valid email id and click on Continue", Toast.LENGTH_SHORT).show();
            return false;

        }


        return true;
    }*/

    private void initWidgets() {
        //Log.d(TAG, "initWidgets: initializing widgets");
        //mEmail = findViewById(R.id.input_email);
        //mPhone = findViewById(R.id.input_phone);
        mContext = RegisterUserInfo.this;
        mUsername = findViewById(R.id.input_username);
        mPassword = findViewById(R.id.input_password);
        mCountry = findViewById(R.id.input_country);
        mCity = findViewById(R.id.input_city);
        mState = findViewById(R.id.input_state);
        mZipcode = findViewById(R.id.edit_zipcode);
        btnComplete = findViewById(R.id.btnComplete);
    }
}
