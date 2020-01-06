package com.bzhong7.labs.dswopapp.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bzhong7.labs.dswopapp.R;
import com.bzhong7.labs.dswopapp.Utils.User;

public class VerifyCode extends AppCompatActivity {
    String code, phone, email;

    private EditText mCode;

    User user;

    private Button codeContinueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);

        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("classUser");
        phone = intent.getStringExtra("phone");
        email = intent.getStringExtra("email");

        mCode = findViewById(R.id.input_verifycode);

        codeContinueButton = findViewById(R.id.codeContinueButton);

        codeContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = mCode.getText().toString();

                if(!(code.equals(""))) {
                    Intent intent = new Intent(VerifyCode.this, RegisterUserInfo.class);
                    intent.putExtra("phone", phone);
                    intent.putExtra("email", email);
                    intent.putExtra("classUser", user);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Code is invalid, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
