package com.sonika.nepstra;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.sonika.nepstra.Navigations.ArtAndCraft;
import com.sonika.nepstra.Navigations.Jwellery;
import com.sonika.nepstra.Navigations.Kids;
import com.sonika.nepstra.Navigations.Mens;
import com.sonika.nepstra.Navigations.NewArrival;
import com.sonika.nepstra.Navigations.Sports;
import com.sonika.nepstra.Navigations.Womens;
import com.sonika.nepstra.Paypal.PaypalActivity;
import com.sonika.nepstra.adapters.OrderAdapter;
import com.sonika.nepstra.helpers.OrderHelper;
import com.sonika.nepstra.listener.ListViewListener;
import com.sonika.nepstra.pojo.OrderedProducts_pojo;

import java.util.ArrayList;
import java.util.List;

;

/**
 * Created by sonika on 9/22/2017.
 */

public class OrderedProducts extends AppCompatActivity implements ListViewListener,NavigationView.OnNavigationItemSelectedListener {
    //RecyclerView orders_recyclerView;
    ListView lv;
    OrderHelper dbhelper;
    OrderAdapter mOrderAdapter;
    List<OrderedProducts_pojo> orderedProductsList = new ArrayList<>();
    TextView totalAmount;
    Button checkout;
    SharedPreferences sm;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_for_add_to_cart_design);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.center_action_bar_text);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        dbhelper = new OrderHelper(this);
        lv = (ListView) findViewById(R.id.ordered_productlist);
        checkout = (Button) findViewById(R.id.btn_proceed_add_to_cart);
        checkout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(OrderedProducts.this, BillingDetails.class);
                startActivity(i);
            }
        });
        totalAmount = (TextView) findViewById(R.id.totalamount);
        getMyTotal();
        show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public void getMyTotal() {
        String result = dbhelper.GetTotal();
        totalAmount.setText(result);

        String text = (String) totalAmount.getText();

        sm = getSharedPreferences("USER_LOGIN", 0);
        SharedPreferences.Editor editor = sm.edit();
        editor.putString("total_amount",text);
        editor.apply();
        editor.commit();

    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_new_arrival) {
            Intent i = new Intent(this, NewArrival.class);
            startActivity(i);
        } else if (id == R.id.nav_mens) {
            Intent i = new Intent(this, Mens.class);
            startActivity(i);

        } else if (id == R.id.nav_womens)
        {
            Intent i = new Intent(this, Womens.class);
            startActivity(i);

        } else if (id == R.id.nav_contact) {

        } else if (id == R.id.nav_category) {

        } else if (id == R.id.nav_arts_and_craft) {

            Intent i = new Intent(this, ArtAndCraft.class);
            startActivity(i);

        }


        else if (id == R.id.nav_about_us) {
            Intent intentAboutUs = new Intent(this, LoginActivity.class);
            startActivity(intentAboutUs);

        }
        else if (id == R.id.nav_books) {

            Intent i = new Intent(this, Kids.class);
            startActivity(i);

        }
        else if (id == R.id.nav_jewellry) {
            Intent i = new Intent(this, Jwellery.class);
            startActivity(i);
        }
        else if (id == R.id.nav_sports) {
            Intent i = new Intent(this, Sports.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public void show() {
        orderedProductsList = dbhelper.getOrderMessage();

        for (int i = 0; i < orderedProductsList.size(); i++) {
            final OrderedProducts_pojo info = orderedProductsList.get(i);
            mOrderAdapter = new OrderAdapter(this, orderedProductsList, R.layout.ordered_productlist);
            mOrderAdapter.setListener(this);
            lv.setAdapter(mOrderAdapter);
            lv.deferNotifyDataSetChanged();
        }
    }



}
//        orders_recyclerView = (RecyclerView) findViewById(R.id.or);
//        //Toast.makeText(this, orderedProducts.getOrderedname(), Toast.LENGTH_SHORT).show();
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrderedProducts.this);
//        orders_recyclerView.setLayoutManager(linearLayoutManager);
//        orders_recyclerView.setHasFixedSize(true);
//        OrderedProductsAdapter orderAdapter = new OrderedProductsAdapter
//                (getApplicationContext(), orderedProductsList);
//        orders_recyclerView.setAdapter(orderAdapter);




      //  Toast.makeText(this, allProducts.getName(), Toast.LENGTH_SHORT).show();

//adding to cart

//        MySharedPreference mShared = new MySharedPreference(OrderedProducts_pojo.this);
//
//        GsonBuilder builder = new GsonBuilder();
//        Gson gson = builder.create();
//        AllProducts[] addCartProducts = gson.fromJson(mShared.retrieveProductFromCart(), AllProducts[].class);
//        List<AllProducts> productList = convertObjectArrayToListObject(addCartProducts);

//        OrderedProductsAdapter mAdapter = new OrderedProductsAdapter(getApplicationContext(), productList);
//        orders_recyclerView.setAdapter(mAdapter);
//    }
//
//    private List<AllProducts> convertObjectArrayToListObject(AllProducts[] allProducts){
//       // final AllProducts allProductsa = (AllProducts) getIntent().getSerializableExtra("hello");
//        //List<AllProducts> mProduct = new ArrayList<AllProducts>();
//        AllProducts mProduct =(AllProducts) getIntent().getSerializableExtra("hello");
//        allProductList.add(mProduct);
//        Collections.addAll(allProductList, allProducts);
//        return allProductList;
//   }
//}
