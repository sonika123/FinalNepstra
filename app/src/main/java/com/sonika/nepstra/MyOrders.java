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

////import org.json.JSONException;
////import org.json.JSONObject;
////
////import java.util.HashMap;
////import java.util.List;
////import java.util.Map;
////
public class MyOrders extends AppCompatActivity {
    ////    ListView listView_myorders;
////    MyOrdersAdapter myOrdersAdapter;
    TextView myorders_tv;

    ////
////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        myorders_tv = (TextView) findViewById(R.id.tv_myorders);
    }
}
////        SharedPreferences sp = getSharedPreferences("LOGINPREF", MODE_PRIVATE);
////        String semail = sp.getString("email", "");
////        Log.e("ullu", semail);
////
////        RequestQueue queue = Volley.newRequestQueue(MyOrders.this);
////
////        StringRequest sr = new StringRequest(Request.Method.POST,
////                "https://nepstra.com/api/android/verifyuser.php?email="+semail,
////                //  https://nepstra.com/api/android/verifyuser.php/?email=send_correct_user&pass=send_correct_password
////                //  http://nepstra.com/api/android/verifyuser.php?email=email&pass=password
////                // https://nepstra.com/api/android/verifyuser.php/?user=send_correct_user&pass=send_correct_password
////                new Response.Listener<String>() {
////                    @Override
////                    public void onResponse(String response) {
////                        Log.e("response", response);
////                        try {
////                            JSONObject jsonObject = new JSONObject(response);
////                            Log.e("simi", "monkey");
////                            String status = jsonObject.getString("status");
//////                                        String message = jsonObject.getString("message");
////////                                      Integer data = jsonObject.getInt(String.valueOf(1)); //yo k gareko?? data =
////                            Log.e("status",status);
////
//////                            if(status.equals("success")){
//////                                Intent i = new Intent(MyOrders.this, MainActivity.class);
//////                                startActivity(i);
//////                                }
//////
//////                            else if (status.equals("error")) {
//////
//////                                Toast.makeText(MyOrders.this, "Wrong email adddress", Toast.LENGTH_SHORT).show();
//////                            }
////
////                        } catch (JSONException e) {
////                            e.printStackTrace();
////                        }
////
////
////
////                        //  msgResponse.setText(response.toString());
////
////                        Log.e("HttpClientlogin", "success! response: " + response.toString());
////                    }},
////                new Response.ErrorListener() {
////                    @Override
////                    public void onErrorResponse(VolleyError error) {
////                        Log.e("HttpClientlogin", "error: " + error.toString());
////                    }
////                }) {
////            @Override
////            protected Map<String, String> getParams() {
////                Map<String, String> params = new HashMap<String, String>();
//////                            params.put("email", semail);
//////                            params.put("pass", spassword);
////                return params;
////            }
////
////            @Override
////            public Map<String, String> getHeaders() throws AuthFailureError {
////                Map<String, String> params = new HashMap<String, String>();
////                params.put("Content-Type", "application/x-www-form-urlencoded");
////                return params;
////            }
////        };
////        sr.setRetryPolicy(new RetryPolicy() {
////            @Override
////            public int getCurrentTimeout() {
////                return 50000;
////            }
////
////            @Override
////            public int getCurrentRetryCount() {
////                return 50000;
////            }
////
////            @Override
////            public void retry(VolleyError error) throws VolleyError {
////
////            }
////        });
////        queue.add(sr);
////
////
////}}
//package com.sonika.nepstra;
//
//import android.app.ProgressDialog;
//import android.content.SharedPreferences;
//import android.os.AsyncTask;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.sonika.nepstra.adapters.MyOrderAdapter;
//import com.sonika.nepstra.parser.JsonParserA;
//import com.sonika.nepstra.pojo.Myorder;
//
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class MyOrders extends AppCompatActivity {
//
//    RecyclerView mRecyclerView;
//    List<Myorder>allmyorderlist = new ArrayList<Myorder>();
//    MyOrderAdapter myOrderAdpater = null;
//
//    int flag;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_orders);
//
//        new MyOrderAsyncTask().execute();
//   }
//
//    class MyOrderAsyncTask extends AsyncTask<String, String, String> {
//        SharedPreferences sp = getSharedPreferences("LOGINPREF", MODE_PRIVATE);
//        String ssemail = sp.getString("email", null);
//
//        ProgressDialog mprogressDialog;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            mprogressDialog = new ProgressDialog(MyOrders.this);
//            mprogressDialog.setMessage("Please wait");
//            mprogressDialog.setCancelable(false);
//            mprogressDialog.show();
//            mprogressDialog.dismiss();
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            HashMap<String, String> loginHashMap = new HashMap<>();
//            JsonParserA jsonParser = new JsonParserA();
//            Log.e("uemail", ssemail);
//            JSONObject jsonObject = jsonParser.performPostCI
//                    ("https://nepstra.com/api/android/customerorder.php?email=" +ssemail, loginHashMap);
//            try {
//                if (jsonObject == null) {
//                    flag = 1;
//                } else {
//
//                    if (jsonObject.getString("status").equals("success")) {
//
//                        JSONArray jsonArray = jsonObject.getJSONArray("data");
//
//
//                        for (int i = 0; i < jsonArray.length(); i++) {
//
//                            JSONObject dataObject = jsonArray.getJSONObject(i);
//
//                            Integer id = dataObject.getInt("id");
//                            Integer parent_id = dataObject.getInt("parent_id");
//                            String number = dataObject.getString("number");
//                            String order_key = dataObject.getString("order_key");
//                            String created_via = dataObject.getString("created_via");
//                            String version = dataObject.getString("version");
//                            String status = dataObject.getString("status");
//                            String currence = dataObject.getString("currency");
//
//                            String date_created = dataObject.getString("date_created");
//                            String date_created_gmt = dataObject.getString("date_created_gmt");
//                            String date_modified = dataObject.getString("date_modified");
//                            String date_modified_gmt = dataObject.getString("date_modified_gmt");
//                            String discount_total = dataObject.getString("discount_total");
//                            String discount_tax = dataObject.getString("discount_tax");
//                            String shipping_total = dataObject.getString("shipping_total");
//                            String shipping_tax = dataObject.getString("shipping_tax");
//                            String cart_tax = dataObject.getString("cart_tax");
//                            String total = dataObject.getString("total");
//                            String total_tax = dataObject.getString("total_tax");
//                            Boolean  prices_include_tax = dataObject.getBoolean("prices_include_tax");
//                            Integer customer_id = dataObject.getInt("customer_id");
//                            String customer_ip_address = dataObject.getString("customer_ip_address");
//                            String customer_user_agent = dataObject.getString("customer_user_agent");
//                            String customer_note = dataObject.getString("customer_note");
//
//
//                            JSONObject billing = dataObject.getJSONObject("billing");
//                            String billing_fname = billing.getString("first_name");
//                            String billing_last_name = billing.getString("last_name");
//                            String billing_company = billing.getString("company");
//                            String billing_address_1 = billing.getString("address_1");
//                            String billing_adddress_2 = billing.getString("address_2");
//                            String billing_city = billing.getString("city");
//                            String billing_state = billing.getString("state");
//                            String billing_postcode = billing.getString("postcode");
//                            String billing_country = billing.getString("country");
//                            String billing_email = billing.getString("email");
//                            String billing_phone = billing.getString("phone");
//
//
//
//                            JSONObject shipping = dataObject.getJSONObject("shipping");
//                            String shipping_fname = shipping.getString("first_name");
//                            String shipping_last_name = shipping.getString("last_name");
//                            String shipping_company = shipping.getString("company");
//                            String shippingbilling_address_1 = shipping.getString("address_1");
//                            String shipping_adddress_2 = shipping.getString("address_2");
//                            String shipping_city = shipping.getString("city");
//                            String shipping_state = shipping.getString("state");
//                            String shipping_postcode = shipping.getString("postcode");
//                            String shipping_country = shipping.getString("country");
//
//
//                            String payment_method = dataObject.getString("payment_method");
//                            String payment_method_title = dataObject.getString("payment_method_title");
//                            String transaction_id = dataObject.getString("transaction_id");
//
//
//
//                            Boolean date_paid = dataObject.isNull("date_paid");
//
//                            Boolean date_paid_gmt = dataObject.isNull("date_paid_gmt");
//                            Boolean date_completed = dataObject.isNull("date_completed");
//                            Boolean date_completed_gmt = dataObject.isNull("date_completed_gmt");
//
//                            String cart_hash = dataObject.getString("cart_hash");
//                            Log.e("pppp", "qqqq");
//
//
//
//                            JSONArray meta_data_array = dataObject.getJSONArray("meta_data");
//
//                            Integer meta_id = null;
//                            String meta_data_key = null;
//                            String meta_data_value = null;
//                            Integer meta_data_value_number= null;
//                            String meta_data_value_formatted_number = null;
//                            Boolean prefix = null;
//                            Boolean auffix = null;
//                            Boolean padding = null;
//                            String meta_data_value_document_type = null;
//                            Integer meta_data_value_order_id = null;
//                            for (int j = 0; j < meta_data_array.length(); j++) {
//                                JSONObject metaobject = meta_data_array.getJSONObject(j);
//                                Log.e("yesudid", "pada");
//                                meta_id = metaobject.getInt("id");
//                                Log.e("yesudid1", "pada");
//                                meta_data_key = metaobject.getString("key");
//                                Log.e("yesudid2", "pada");
//
//                                meta_data_value = metaobject.getString("value");
//                                Log.e("yesudid3", "pada");
//
////                                meta_data_value = meta_data_value1.getString("value");
////                                meta_data_value_number = meta_data_value1.getInt("number");
////                                meta_data_value_formatted_number  = meta_data_value1.getString("formatted_number");
////                                prefix = meta_data_value1.isNull("prefix");
////                                auffix  = meta_data_value1.isNull("suffix");
////                                meta_data_value_document_type   = meta_data_value1.getString("document_type");
////                                meta_data_value_order_id   = meta_data_value1.getInt("order_id");
////                                padding= meta_data_value1.isNull("padding");
//
//                               }
//
//
//
//
//                            JSONArray line_item_array = dataObject.getJSONArray("line_items");
//                            Integer line_id = null;
//                            String line_item_name = null;
//                            Integer line_product_id = null;
//                            Integer line_variation_id = null;
//                            Integer line_quantity = null;
//                            String line_item_tax_class = null;
//                            String line_item_subtotal = null;
//                            String line_item_subtotal_tax = null;
//                            String line_item_total = null;
//                            String line_item_total_tax = null;
//                            JSONArray line_item_taxes = null;
//                            JSONArray line_item_meta_data = null;
//                            String sku = null;
//                            Integer line_price = null;
//
//                            for (int j = 0; j < line_item_array.length(); j++) {
//                                line_id = line_item_array.getJSONObject(j).getInt("id");
//                                line_item_name = line_item_array.getJSONObject(j).getString("name");
//                                line_product_id = line_item_array.getJSONObject(j).getInt("product_id");
//                                line_variation_id = line_item_array.getJSONObject(j).getInt("variation_id");
//                                line_quantity = line_item_array.getJSONObject(j).getInt("quantity");
//                                line_item_tax_class = line_item_array.getJSONObject(j).getString("tax_class");
//                                line_item_subtotal = line_item_array.getJSONObject(j).getString("subtotal");
//                                line_item_subtotal_tax = line_item_array.getJSONObject(j).getString("subtotal_tax");
//                                line_item_total = line_item_array.getJSONObject(j).getString("total");
//                                line_item_total_tax = line_item_array.getJSONObject(j).getString("total_tax");
//                                line_item_taxes = line_item_array.getJSONObject(j).getJSONArray("taxes");
//                                line_item_meta_data = line_item_array.getJSONObject(j).getJSONArray("meta_data");
//                                sku = line_item_array.getJSONObject(j).getString("sku");
//                                line_price = line_item_array.getJSONObject(j).getInt("price");
//
//                                Log.e("catogory", "myorder1");
//                            }
//
//                            JSONArray tax_lines = dataObject.getJSONArray("tax_lines");
//
//                            JSONArray shipping_lines = dataObject.getJSONArray("shipping_lines");
//
//                            Integer shipping_lines_id = null;
//                            String shipping_method_title = null;
//                            String shipping_method_id = null;
//                            String shipping_line_total = null;
//                            String shipping_total_taxes = null;
//                            JSONArray tax_lines_taxes = null;
//                            JSONArray shipping_meta_data = null;
//                            Integer shipping_meta_data_id = null;
//                            String shipping_meta_data_key = null;
//                            String shipping_meta_data_value = null;
//                            for (int j = 0; j < shipping_lines.length(); j++) {
//                                JSONObject shipping_lines_object = shipping_lines.getJSONObject(j);
//                                shipping_lines_id = shipping_lines_object.getInt("id");
//                                shipping_method_title = shipping_lines_object.getString("method_title");
//                                shipping_method_id = shipping_lines_object.getString("method_id");
//                                shipping_line_total = shipping_lines_object.getString("total");
//                                shipping_total_taxes = shipping_lines_object.getString("total_tax");
//                                tax_lines_taxes = shipping_lines_object.getJSONArray("taxes");
//                                shipping_meta_data = shipping_lines_object.getJSONArray("meta_data");
//                                Log.e("catogory", "myorder2");
//                                for (int k = 0; k < shipping_meta_data.length(); k++) {
//                                    shipping_meta_data_id = shipping_meta_data.getJSONObject(k).getInt("id");
//                                    shipping_meta_data_key = shipping_meta_data.getJSONObject(k).getString("key");
//                                    shipping_meta_data_value = shipping_meta_data.getJSONObject(k).getString("value");
//                                    Log.e("catogory", "myorder2");
//
//                                }
//                            }
//
//                            JSONArray fee_lines = dataObject.getJSONArray("fee_lines");
//                            JSONArray coupon_lines = dataObject.getJSONArray("coupon_lines");
//                            JSONArray refunds = dataObject.getJSONArray("refunds");
//                            JSONObject _links = dataObject.getJSONObject("_links");
//
//                            JSONArray self_array = _links.getJSONArray("self");
//                            String links_self_href = null;
//                            for (int m = i; m < self_array.length(); m++) {
//                                links_self_href = self_array.getJSONObject(0).getString("href");
//                            }
//                            JSONArray collection_array = _links.getJSONArray("collection");
//                            String links_collection_href = null;
//                            for (int n = i; n < collection_array.length(); n++) {
//                                links_collection_href = collection_array.getJSONObject(0).getString("href");
//                            }
//                            JSONArray customer_array = _links.getJSONArray("collection");
//                            String links_customer_href = null;
//                            for (int n = i; n < customer_array.length(); n++) {
//                                links_customer_href = collection_array.getJSONObject(0).getString("href");
//                            }
//                            Myorder myorder =
//                                    new Myorder(line_item_taxes, line_item_meta_data, tax_lines, tax_lines_taxes,
//                                            fee_lines, coupon_lines, refunds, prices_include_tax, date_paid,date_paid_gmt, date_completed, date_completed_gmt, prefix,
//                                            auffix, padding,number,order_key,created_via, version,status,currence, date_created, date_created_gmt,
//                                            date_modified, date_modified_gmt,discount_total, discount_tax, shipping_tax,shipping_total,
//                                            cart_tax, total,total_tax,customer_ip_address, customer_user_agent, customer_note,
//                                            billing_fname, billing_last_name, billing_company, billing_address_1, billing_adddress_2, billing_city,
//                                            billing_state, billing_postcode, billing_country, billing_email, billing_phone, shipping_fname,
//                                            shipping_last_name, shipping_company, shippingbilling_address_1, shipping_adddress_2, shipping_city,
//                                            shipping_state, shipping_postcode,shipping_country, payment_method, payment_method_title,transaction_id,
//                                            cart_hash,
//                                            meta_data_key, meta_data_value,meta_data_value_formatted_number, meta_data_value_document_type, line_item_name, line_item_tax_class,
//                                            line_item_subtotal, line_item_subtotal_tax, line_item_total, line_item_total_tax, sku,
//                                            shipping_method_title,
//                                            shipping_method_id,
//                                            shipping_line_total, shipping_total_taxes, shipping_meta_data_key, shipping_meta_data_value, links_self_href,
//                                            links_collection_href,
//                                            links_customer_href,id,parent_id,customer_id,meta_id,
//                                            line_id,line_quantity, line_product_id, line_variation_id,
//                                            line_price,shipping_lines_id,shipping_meta_data_id, meta_data_value_number,meta_data_value_order_id);
//                            allmyorderlist.add(myorder);
//                            flag = 2;
//                        }
//
//                    }
//                    else {
//                        flag = 3;
//                    }
//                }
//            } catch (JSONException e) {
//
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            mprogressDialog.dismiss();
//            if (flag == 1) {
//                Toast.makeText(MyOrders.this, "Server/Network issue", Toast.LENGTH_SHORT).show();
//
//            } else if (flag == 2) {
//                Toast.makeText(MyOrders.this, "Success", Toast.LENGTH_SHORT).show();
//                mRecyclerView = (RecyclerView) findViewById(R.id.myorderrecycle);
//                GridLayoutManager mGrid = new GridLayoutManager(MyOrders.this, 1);
//                mRecyclerView.setLayoutManager(mGrid);
//                mRecyclerView.setHasFixedSize(true);
//                mRecyclerView.setNestedScrollingEnabled(false);
//
//                Log.e("myorder2312312", String.valueOf(allmyorderlist.size()));
//
//                myOrderAdpater = new MyOrderAdapter(MyOrders.this, allmyorderlist);
//                mRecyclerView.setAdapter(myOrderAdpater);
//
//
//            } else {
//                Toast.makeText(MyOrders.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//
//
//
//}