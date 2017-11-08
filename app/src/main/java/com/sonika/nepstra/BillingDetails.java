package com.sonika.nepstra;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sonika.nepstra.Paypal.PaypalActivity;

public class BillingDetails extends AppCompatActivity {
    EditText fname,lname, cname, country,street, streetaddress, town,state, phoneno, postcode, email;
    Button btnplaceorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing_details);
        fname = (EditText) findViewById(R.id.lbl_first_name);
        lname = (EditText) findViewById(R.id.lbl_last_name);
        cname = (EditText) findViewById(R.id.lbl_company_name);
        country = (EditText) findViewById(R.id.lbl_country);
        street = (EditText) findViewById(R.id.lbl_house_no);
        streetaddress = (EditText) findViewById(R.id.lbl_apartment_suite);
        town = (EditText) findViewById(R.id.lbl_town_city);
        state = (EditText) findViewById(R.id.lbl_state_zone);
        phoneno = (EditText) findViewById(R.id.lbl_phone);
        postcode = (EditText) findViewById(R.id.lbl_post_code_zip);
        email = (EditText) findViewById(R.id.lbl_email_address);
        btnplaceorder = (Button) findViewById(R.id.btn_place_order);
        btnplaceorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname =fname.getText().toString();
                String slname =lname.getText().toString();
                String scname =cname.getText().toString();
                String scountry =country.getText().toString();
                String sstreet =street.getText().toString();
                String sstreetaddress =streetaddress.getText().toString();
                String stown =town.getText().toString();
                String sstate =state.getText().toString();
                String sphone =phoneno.getText().toString();
                String spostcode =postcode.getText().toString();
                String semail =email.getText().toString();



                if    (sname.length()<=0 || slname.length()<=0 || scname.length()<=0 || scountry.length()<=0 ||sstreet.length()<=0 ||sstreetaddress.length()<=0
                        || stown.length()<=0 || sstate.length()<=0 || sphone.length()<=0 || spostcode.length()<=0 || semail.length()<=0)
                {
                    Toast.makeText(BillingDetails.this, "Please, fill all the fields! ", Toast.LENGTH_SHORT).show();
                }

                else if (!isValidContact(sphone)){
                    phoneno.setError("Please enter your valid number");
                }

                else{
                    Intent i = new Intent(BillingDetails.this, PaypalActivity.class);
                    startActivity(i);

                }
                SharedPreferences sm = getSharedPreferences("USER_LOGIN", 0);
                SharedPreferences.Editor editor = sm.edit();
                editor.putString("name",sname);
                editor.apply();
                editor.commit();SharedPreferences sm1 = getSharedPreferences("USER_LOGIN", 0);
                SharedPreferences.Editor editor1 = sm1.edit();
                editor1.putString("country",scountry);
                editor.apply();
                editor.commit();SharedPreferences sm2 = getSharedPreferences("USER_LOGIN", 0);
                SharedPreferences.Editor editor2 = sm2.edit();
                editor2.putString("phone",sphone);
                editor.apply();
                editor.commit();SharedPreferences sm3 = getSharedPreferences("USER_LOGIN", 0);
                SharedPreferences.Editor editor3 = sm3.edit();
                editor3.putString("email",semail);
                editor.apply();
                editor.commit();


            }
        });



    }

        private boolean isValidContact(String ssphone) {
            if (ssphone != null && ssphone.length() == 10){
                return true;
            }
            return false;
        }
    }

