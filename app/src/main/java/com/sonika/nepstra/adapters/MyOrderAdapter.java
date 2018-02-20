package com.sonika.nepstra.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sonika.nepstra.Orders.MyDetailsOrder;

import com.sonika.nepstra.R;
import com.sonika.nepstra.pojo.Myorder;

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

        holder.ordernuber.setText(myorderlist.get(position).getId() + "");
        holder.date.setText(myorderlist.get(position).getDate_created() + "");
        holder.status.setText(myorderlist.get(position).getStatus());
        String totalprice_item = String.valueOf(Integer.valueOf(myorderlist.get(position).getLine_quantity()) * (Integer.valueOf(myorderlist.get(position).getLine_price())));
        holder.total.setText( "A$"+totalprice_item+ "");
        holder.actions.setText("View");

        holder.actions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MyDetailsOrder.class);
                context.startActivity(i);
            }
        });

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

//        public TextView productName, productQuantity, productPrice;
TextView ordernuber, date, status, total, actions;
        public MyOrder(View itemView) {
            super(itemView);
            ordernuber = itemView.findViewById(R.id.txt_myorderid);
            date =  itemView.findViewById(R.id.txt_mydate);
            status = itemView.findViewById(R.id.txt_mystatus);
            total = itemView.findViewById(R.id.txt_mytotal);
            actions = itemView.findViewById(R.id.txt_myaction);
        }
    }
}