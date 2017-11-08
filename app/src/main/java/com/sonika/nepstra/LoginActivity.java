package com.sonika.nepstra;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by sonika on 10/11/2017.
 */

public class LoginActivity extends AppCompatActivity {

    public boolean click=true;
    Button btnRegister;
    BottomBar bottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        BottomBarTab dummy = bottomBar.getTabWithId(R.id.tab_dummy);
        dummy.setVisibility(View.GONE);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_dummy:
                        break;

                    case R.id.tab_home:
                        Intent intentHome=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intentHome);


                        break;


                    case R.id.tab_products:
                        //    Intent iiproducts = new Intent(LoginActivity.this,CategoriesActivity.class);
                        //  startActivity(iiproducts);



                        break;
                    case R.id.tab_order:
                        Intent intentOrder = new Intent(LoginActivity.this, OrderedProducts.class);
                        startActivity(intentOrder);

                        break;
                    case R.id.tab_account:
                        Toast.makeText(LoginActivity.this, "Account", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;

                }
            }
        });


        btnRegister=(Button)findViewById(R.id.btn_register_login);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}

