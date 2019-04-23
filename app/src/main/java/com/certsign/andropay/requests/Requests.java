package com.certsign.andropay.requests;

import com.certsign.andropay.application.SettingsPage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import communication.JsonUtils;
import communication.LoginResponse;
import communication.TransactionResponse;

/**
 * Created by poposc on 4/22/2019.
 */

public class Requests {

    public static LoginResponse sendLoginRequest(Object username, Object password) throws IOException {
        LoginResponse response = new LoginResponse();
        StringBuffer contentStringBuffer = new StringBuffer();
        try {
            String loginRequestURL = "http://"+ SettingsPage.getIp() +":"+ SettingsPage.getPort() +"/login?username=" + username + "&password=" + password;
            URL url = new URL(loginRequestURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "text/plain");
            con.setConnectTimeout(6 * 1000);
            con.setReadTimeout(6 * 1000);

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    contentStringBuffer.append(inputLine);
                }
                response = JsonUtils.readJsonResponse(contentStringBuffer.toString(), LoginResponse.class);
                in.close();
                con.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public static TransactionResponse sendTransactionRequest(Object token, Object transferredAmount) throws IOException {
        TransactionResponse response = new TransactionResponse();
        StringBuffer contentStringBuffer = new StringBuffer();
        try {
            String loginRequestURL = "http://"+ SettingsPage.getIp() +":"+ SettingsPage.getPort() +"/transaction?token=" + token + "&transferredAmount=" + transferredAmount;
            URL url = new URL(loginRequestURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "text/plain");
            con.setConnectTimeout(6 * 1000);
            con.setReadTimeout(6 * 1000);

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    contentStringBuffer.append(inputLine);
                }
                response = JsonUtils.readJsonResponse(contentStringBuffer.toString(), TransactionResponse.class);
                in.close();
                con.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }



}
