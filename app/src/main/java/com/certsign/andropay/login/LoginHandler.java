package com.certsign.andropay.login;


import android.os.AsyncTask;

import com.certsign.andropay.application.Runner;
import com.certsign.andropay.bank.BankDashboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by poposc on 4/17/2019.
 */

public class LoginHandler{


    public static String sendCredentialsCheckRequest(String username, String password) throws IOException {
        String loginRequestURL = "http://localhost:7788/login?username=" + username + "&password=" + password;
        URL url = new URL(loginRequestURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "text/plain");
        con.setConnectTimeout(6 * 1000);
        con.setReadTimeout(6 * 1000);
        StringBuffer contentStringBuffer = new StringBuffer();


        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                contentStringBuffer.append(inputLine);
            }
            in.close();
            con.disconnect();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return contentStringBuffer.toString();
    }
}
