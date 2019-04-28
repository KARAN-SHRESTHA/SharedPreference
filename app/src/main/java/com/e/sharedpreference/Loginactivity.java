package com.e.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginactivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btn, btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btn = findViewById(R.id.btn);
        btnCreate = findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Loginactivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();

            }
        });

    }

    private void checkUser()
    {
        SharedPreferences sharedpreferences = getSharedPreferences("User", MODE_PRIVATE);

        String username = sharedpreferences.getString("username", "");
        String password = sharedpreferences.getString("password", "");

        if(username.equals(etUsername.getText().toString()) && password.equals(etPassword.getText().toString()))
        {
            Toast.makeText(this, "Logged In", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Invalid Username & Password", Toast.LENGTH_SHORT).show();
        }

    }


}
