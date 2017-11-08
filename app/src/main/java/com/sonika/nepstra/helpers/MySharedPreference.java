package com.sonika.nepstra.helpers;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class MySharedPreference {

    private SharedPreferences prefs;

    private Context context;

    public MySharedPreference(Context context){
        this.context = context;
        prefs = context.getSharedPreferences(Constants.SHARED_PREF, Context.MODE_PRIVATE);
    }

    public void addProductToTheCart(String product){
        SharedPreferences.Editor edits = prefs.edit();
        edits.putString(Constants.PRODUCT_ID, product);
        edits.apply();
    }

    public String retrieveProductFromCart(){
        return prefs.getString(Constants.PRODUCT_ID, "");
    }

    public void addProductCount(int productCount){
        SharedPreferences.Editor edits = prefs.edit();
        edits.putInt(Constants.PRODUCT_COUNT, productCount);

        edits.apply();
    }

    public int retrieveProductCount(){
        Log.e("shared", String.valueOf(prefs.getInt(Constants.PRODUCT_COUNT, 0)));
       return prefs.getInt
               (Constants.PRODUCT_COUNT, 0);

    }
}
