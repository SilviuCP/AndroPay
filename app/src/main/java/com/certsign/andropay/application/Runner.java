package com.certsign.andropay.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.certsign.andropay.R;
import com.certsign.andropay.requests.LoginHandler;


public class Runner extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private Button settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runner);

        username = (EditText) findViewById(R.id.usernameTextField);
        password = (EditText) findViewById(R.id.passwordTextField);
        login = (Button) findViewById(R.id.loginButton);
        settings = (Button) findViewById(R.id.settingsButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    LoginHandler handler = new LoginHandler(v.getContext());
                    handler.execute(username.getText().toString(), password.getText().toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Runner.this, SettingsPage.class));
            }
        });

    }


}
