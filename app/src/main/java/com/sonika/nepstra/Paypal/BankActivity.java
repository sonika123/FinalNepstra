package com.sonika.nepstra.Paypal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sonika.nepstra.R;

public class BankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        Toast.makeText(this, "hello bank activity", Toast.LENGTH_SHORT).show();
    }
}
