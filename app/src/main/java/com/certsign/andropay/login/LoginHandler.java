package com.certsign.andropay.login;


import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by poposc on 4/17/2019.
 */

public class LoginHandler extends AsyncTask{

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Object[] params) {
        StringBuffer contentStringBuffer = new StringBuffer();
        try {
            String loginRequestURL = "http://192.168.76.193:7788/login?username=" + params[0] + "&password=" + params[1];
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
                in.close();
                con.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return contentStringBuffer.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return contentStringBuffer.toString();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
