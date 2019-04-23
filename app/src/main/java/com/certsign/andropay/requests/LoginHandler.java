package com.certsign.andropay.requests;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.certsign.andropay.application.Runner;
import com.certsign.andropay.application.SettingsPage;
import com.certsign.andropay.bank.BankDashboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import communication.JsonUtils;
import communication.LoginResponse;

/**
 * Created by poposc on 4/17/2019.
 */

public class LoginHandler extends AsyncTask{

    private Context activity;
    private static String token;
    private static double balance;

    public LoginHandler(Context a){
        super();
        this.activity = a;
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
    }

    @Override
    protected LoginResponse doInBackground(Object[] params) {
        LoginResponse loginResponse = new LoginResponse();
        try{
            loginResponse = Requests.sendLoginRequest(params[0], params[1]);
        }catch (Exception e){
            e.printStackTrace();
        }
        return loginResponse;
    }


    @Override
    protected void onPostExecute(Object o) {
        LoginResponse response = (LoginResponse)o;
        token = response.getToken();
        balance = response.getBalance();

        if (response.getSuccessful() == true){

            Intent intent = new Intent(activity, BankDashboard.class);
            activity.startActivity(intent);
        }else if(response.getSuccessful() == false){
            Toast.makeText(activity, "Wrong Credentials",Toast.LENGTH_SHORT).show();
        }
    }

    public static String getToken() {
        return token;
    }

    public static double getBalance() {
        return balance;
    }

}
