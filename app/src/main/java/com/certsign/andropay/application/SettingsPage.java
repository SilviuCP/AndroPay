package com.certsign.andropay.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.certsign.andropay.R;

public class SettingsPage extends AppCompatActivity {



    private static String port = "7788";
    private static String ip = "192.168.76.193";
    private EditText ipEditText;
    private EditText portEditText;
    private Button saveSettingsButton;


//    username = (EditText) findViewById(R.id.usernameTextField);
//    password = (EditText) findViewById(R.id.passwordTextField);
//    login = (Button) findViewById(R.id.loginButton);
//    settings = (Button) findViewById(R.id.settingsButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        saveSettingsButton = (Button) findViewById(R.id.saveSettingsButton);
        ipEditText = (EditText) findViewById(R.id.ipTextField);
        portEditText = (EditText) findViewById(R.id.portTextField);

        saveSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip = ipEditText.getText().toString();
                port = portEditText.getText().toString();
            }
        });
    }

    public static String getIp() {
        return ip;
    }

    public static String getPort() {
        return port;
    }



}
