package com.sonika.nepstra.Paypal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sonika.nepstra.R;

public class CashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash);
        Toast.makeText(this, "hello cash activity", Toast.LENGTH_SHORT).show();
    }
}
