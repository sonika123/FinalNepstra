package com.sonika.nepstra;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sonika.nepstra.adapters.MyOrdersAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyOrders extends AppCompatActivity {
    ListView listView_myorders;
    MyOrdersAdapter myOrdersAdapter;
    TextView myorders_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myorders_list);
        myorders_tv = (TextView) findViewById(R.id.tv_myorders);
        SharedPreferences sp = getSharedPreferences("LOGINPREF", MODE_PRIVATE);
        String semail = sp.getString("email", "");
        Log.e("ullu", semail);

        RequestQueue queue = Volley.newRequestQueue(MyOrders.this);

        StringRequest sr = new StringRequest(Request.Method.POST,
                "https://nepstra.com/api/android/verifyuser.php?email="+semail,
                //  https://nepstra.com/api/android/verifyuser.php/?email=send_correct_user&pass=send_correct_password
                //  http://nepstra.com/api/android/verifyuser.php?email=email&pass=password
                // https://nepstra.com/api/android/verifyuser.php/?user=send_correct_user&pass=send_correct_password
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("response", response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Log.e("simi", "monkey");
                            String status = jsonObject.getString("status");
//                                        String message = jsonObject.getString("message");
////                                      Integer data = jsonObject.getInt(String.valueOf(1)); //yo k gareko?? data =
                            Log.e("status",status);

//                            if(status.equals("success")){
//                                Intent i = new Intent(MyOrders.this, MainActivity.class);
//                                startActivity(i);
//                                }
//
//                            else if (status.equals("error")) {
//
//                                Toast.makeText(MyOrders.this, "Wrong email adddress", Toast.LENGTH_SHORT).show();
//                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                        //  msgResponse.setText(response.toString());

                        Log.e("HttpClientlogin", "success! response: " + response.toString());
                    }},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("HttpClientlogin", "error: " + error.toString());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
//                            params.put("email", semail);
//                            params.put("pass", spassword);
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


}}
