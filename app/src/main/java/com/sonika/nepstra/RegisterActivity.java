package com.sonika.nepstra;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by sonika on 10/11/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    Spinner spinnerStates;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinnerStates = (Spinner) findViewById(R.id.spinner_states);
        adapter = ArrayAdapter.createFromResource(this, R.array.states_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStates.setAdapter(adapter);

        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        /*To hide first icon at runtime */
        BottomBarTab dummy = bottomBar.getTabWithId(R.id.tab_dummy);
        dummy.setVisibility(View.GONE);


        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {

                    case R.id.tab_dummy:
                        break;

                    case R.id.tab_home:
                        Intent intentHome = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intentHome);
                        break;


                    case R.id.tab_products:
                        //    Intent iiproducts = new Intent(LoginActivity.this,CategoriesActivity.class);
                        //  startActivity(iiproducts);


                        break;
                    case R.id.tab_order:
                        Intent intentOrder = new Intent(RegisterActivity.this, OrderedProducts.class);
                        startActivity(intentOrder);

                        break;
                    case R.id.tab_account:
                        Toast.makeText(RegisterActivity.this, "Account", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;

                }
            }
        });


    }
}
