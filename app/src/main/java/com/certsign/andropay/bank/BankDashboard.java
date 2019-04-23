package com.certsign.andropay.bank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.certsign.andropay.R;
import com.certsign.andropay.requests.LoginHandler;
import com.certsign.andropay.requests.TransactionHandler;

import java.util.ArrayList;

public class BankDashboard extends AppCompatActivity {

    private Button transactionsButton;
    private static TextView balanceTextView;
    private static EditText amountToSendEditText;
    private static double amountToSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_dashboard);

        transactionsButton = (Button) findViewById(R.id.newTransactionButton);
        balanceTextView = (TextView) findViewById(R.id.accountBalanceAmountTextView);
        balanceTextView.setText(String.valueOf(LoginHandler.getBalance()));
        amountToSendEditText = (EditText) findViewById(R.id.amountToSendEditText);


        transactionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    amountToSend =  Double.valueOf(amountToSendEditText.getText().toString());
                    TransactionHandler handler = new TransactionHandler(LoginHandler.getToken());
                    handler.execute(LoginHandler.getToken(), amountToSend);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
