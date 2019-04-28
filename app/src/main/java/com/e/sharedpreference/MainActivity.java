package com.e.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword, etCPassword;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etCPassword = findViewById(R.id.etCPassword);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signUp();

            }
        });


    }

    private void signUp(){

        SharedPreferences sharedpreferences = getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedpreferences.edit();

        editor.putString("username", etUsername.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();

        Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show();


    }

}
