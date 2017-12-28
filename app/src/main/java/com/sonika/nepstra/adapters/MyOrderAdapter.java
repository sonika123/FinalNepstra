package com.sonika.nepstra.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sonika.nepstra.R;
import com.sonika.nepstra.pojo.Myorder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyOrder> {
    public Context context;
    private List<Myorder> myorderlist;


    public MyOrderAdapter(Context context, List<Myorder> myOrders) {
        this.context = context;
        this.myorderlist =myOrders;
    }

    @Override
    public MyOrder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.activity_my_order_adapter, parent, false);

        return new MyOrder(view);
    }

    @Override
    public void onBindViewHolder(MyOrder holder, int position) {

            holder.productName.setText(myorderlist.get(position).getLine_item_name());
            holder.productQuantity.setText(myorderlist.get(position).getLine_quantity() + "");
            String totalprice_item = String.valueOf(Integer.valueOf(myorderlist.get(position).getLine_quantity()) * (Integer.valueOf(myorderlist.get(position).getLine_price())));

            holder.productPrice.setText(totalprice_item+ "");

//            for (int g = 0; g < myorderlist.size(); g++)
//        {
//            holder.productName.setText(myorderlist.get(position).getLine_item_name());
//            holder.productQuantity.setText(myorderlist.get(position).getLine_quantity() + "");
//            holder.productPrice.setText(myorderlist.get(position).getLine_price() + "");
//        }

    }
    @Override
    public int getItemCount() {
        return myorderlist.size();
    }

    public class MyOrder extends RecyclerView.ViewHolder {

        public TextView productName, productQuantity, productPrice;

        public MyOrder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.txt_name_myorders);
            productQuantity =  itemView.findViewById(R.id.txt_quantity_myorders);
            productPrice = itemView.findViewById(R.id.txt_price_myorders);
        }
    }
}