package com.sonika.nepstra;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sonika.nepstra.Paypal.PaypalActivity;

import java.util.HashMap;
import java.util.Map;

public class LoginVolley extends AppCompatActivity {
    EditText username, password;
    String sname, spassword;
    Button btnRegister, login;
    ProgressDialog mprogressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_volley);
        username = (EditText) findViewById(R.id.lbl_username_login);
        password = (EditText) findViewById(R.id.lbl_password_login);
        login = (Button) findViewById(R.id.btn_login_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sname = username.getText().toString();
                spassword = password.getText().toString();

                if (sname.length() <= 0 || spassword.length() <= 0) {
                    Toast.makeText(LoginVolley.this, "Please, fill all the fields! ", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("Tag", "signupPrakriti");
                    mprogressDialog= new ProgressDialog(LoginVolley.this);
                    mprogressDialog.setMessage("Loading...");
                    mprogressDialog.show();

                    RequestQueue queue = Volley.newRequestQueue(LoginVolley.this);



                    StringRequest sr = new StringRequest(Request.Method.POST, "http://nepstra.com/api/android/verifyuser.php?"+
                            "user="+sname +
                            "pass="+spassword,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Intent i = new Intent(LoginVolley.this, MainActivity.class);
                                    startActivity(i);
                                    mprogressDialog.hide();

                                    Log.e("HttpClient", "success! response: " + response.toString());
                                }},
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.e("HttpClient", "error: " + error.toString());
                                    mprogressDialog.hide();
                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("user", sname);
                            params.put("pass", spassword);
                            return params;
                        }

                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("Content-Type", "application/x-www-form-urlencoded");
                            return params;
                        }
                    };
                    sr.setRetryPolicy(new RetryPolicy() {
                        @Override
                        public int getCurrentTimeout() {
                            return 50000;
                        }

                        @Override
                        public int getCurrentRetryCount() {
                            return 50000;
                        }

                        @Override
                        public void retry(VolleyError error) throws VolleyError {

                        }
                    });
                    queue.add(sr);


                }}});}}

