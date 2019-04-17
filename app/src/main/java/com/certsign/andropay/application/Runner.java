package com.certsign.andropay.application;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.certsign.andropay.R;
import com.certsign.andropay.bank.BankDashboard;
import com.certsign.andropay.login.LoginHandler;

public class Runner extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runner);

        username = (EditText)findViewById(R.id.usernameTextField);
        password = (EditText)findViewById(R.id.passwordTextField);
        login = (Button)findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //Stupid thing done just for testing, need to use AsyncTask on LoginHandler NOT to create thread on every button click;
                    new Thread(new Runnable() {
                    public void run() {
                        try{
                            LoginHandler.sendCredentialsCheckRequest(username.getText().toString(), password.getText().toString());
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
                        //LoginHandler.sendCredentialsCheckRequest(username.getText().toString(), password.getText().toString());

                        Intent intent = new Intent(Runner.this, BankDashboard.class);
                        startActivity(intent);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

}
