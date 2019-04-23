package com.certsign.andropay.requests;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.widget.Toast;

import com.certsign.andropay.bank.BankDashboard;
import com.certsign.andropay.transactions.Transactions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import communication.JsonUtils;
import communication.LoginResponse;
import communication.Response;
import communication.TransactionResponse;

/**
 * Created by poposc on 4/22/2019.
 */

public class TransactionHandler extends AsyncTask{

    private static String token;

    public TransactionHandler(String token){
        this.token = token;
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
    }

    @Override
    protected TransactionResponse doInBackground(Object[] params) {
        TransactionResponse transactionResponse = new TransactionResponse();
        try{
            transactionResponse = Requests.sendTransactionRequest(params[0], params[1]);
        }catch (Exception e){
            e.printStackTrace();
        }
        return transactionResponse;
    }

    @Override
    protected void onPostExecute(Object o) {
//        LoginResponse response = (LoginResponse)o;
//        if (response.getSuccessful() == true){
//            Intent intent = new Intent(activity, BankDashboard.class);
//            activity.startActivity(intent);
//        }else if(response.getSuccessful() == false){
//            Toast.makeText(activity, "Wrong Credentials",Toast.LENGTH_SHORT).show();
//        }
    }
}
