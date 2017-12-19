package com.sonika.nepstra.adapters;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sonika.nepstra.R;
import com.sonika.nepstra.helpers.OrderHelper;
import com.sonika.nepstra.listener.CountListener;
import com.sonika.nepstra.listener.ListViewListener;
import com.sonika.nepstra.pojo.OrderedProducts_pojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 5/9/2017.
 */

public class OrderAdapter extends BaseAdapter implements CountListener  {
    Context context;
    List<OrderedProducts_pojo> cartlist = new ArrayList<OrderedProducts_pojo>();
    int resource;
    OrderHelper dbHelper;
    private ListViewListener mListener;
    private CountListener mcountListener;


    public OrderAdapter(Context context, List<OrderedProducts_pojo> objects, int resource) {
        this.context = context;
        this.cartlist = objects;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return cartlist.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount(int a) {

        int position = a;
        final OrderedProducts_pojo orderInfo = cartlist.get(position);
        dbHelper = new OrderHelper(context);

        ContentValues contentValues = new ContentValues();
        ArrayList<OrderedProducts_pojo> cartItems = dbHelper.getOrderMessage();
        for (int i = position; i < cartlist.size(); i++)
        {
        for(OrderedProducts_pojo cartItem: cartItems){
            if(cartItem.getOrderedcat_id().equals(orderInfo.getOrderedcat_id())) {

                if (cartItem.getCount() > 1) {

                    contentValues.put("count", cartItem.count - 1);
                    dbHelper.updateCount(orderInfo.getOrderedcat_id(), contentValues);
                    int count = cartItem.getCount() - 1;

                    mListener.getMyTotal();
                    notifyDataSetChanged();
                    return count;
                }

                else {
                    dbHelper.delete(cartlist.get(position).getOrderid()
                            .toString(), null, null);
                    Toast.makeText(context, "removed", Toast.LENGTH_SHORT).show();
                    mListener.getMyTotal();
                    cartlist.remove(position);
                    notifyDataSetChanged();
                }
            }
        }
            contentValues.put("count", 1);

        }
        return getCount()-1;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.name = row.findViewById(R.id.txt_name_add_to_cart);
            holder.price = row.findViewById(R.id.txt_price_add_to_cart);
            holder.img_product = row.findViewById(R.id.img_add_to_cart);
            holder.qty = row.findViewById(R.id.ordered_productlist_id);
            holder.btnRemove = row.findViewById(R.id.btn_add_to_cart_remove);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        final OrderedProducts_pojo orderInfo = cartlist.get(position);
        dbHelper = new OrderHelper(context);
        final ViewHolder finalHolder = holder;
        finalHolder.name.setText("Name : " + orderInfo.getOrderedname());
        final String itemTotalPrice = String.valueOf(Integer.valueOf(orderInfo.getCount()) * (Integer.valueOf(orderInfo.getOrderedprice())));
        finalHolder.price.setText(itemTotalPrice);
        Picasso.with(context).load(orderInfo.getOrderedimage()).into(finalHolder.img_product);



       // finalHolder.qty.setText(orderInfo.getCount() + " ");

        holder.btnRemove.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view)
                {
                    if (orderInfo.getCount() > 1) {
                        int a = position;
                        int cv = getItemCount(a);

                        String sonika = cv + "";
                        Toast.makeText(context, sonika, Toast.LENGTH_SHORT).show();
                        //ViewHolder viewHolder = (ViewHolder) finalRow.getTag();
                        finalHolder.qty.setText(sonika);
                        



                    }

                    else {
                            dbHelper.delete(cartlist.get(position).getOrderid()
                                    .toString(), null, null);
                            Toast.makeText(context, "removed", Toast.LENGTH_SHORT).show();
                            mListener.getMyTotal();
                            cartlist.remove(position);
                            notifyDataSetChanged();
                        }
                    notifyDataSetChanged();
                    }



            });


        int sum = 0;
        for (int i = 0; i < cartlist.size(); i++)
        {
            sum = Integer.parseInt(holder.price.getText().toString());
        }
        Log.e("sum", String.valueOf(sum));
        return row;

//        Log.e("price", String.valueOf(holder.price.getText()));
//        OrderHelper dbhelper = new OrderHelper(context);
//        ContentValues cv =  new ContentValues();
//        cv.put("price", holder.orderid.getText().toString());
//        dbhelper.insertOrderInfo(cv);
    }

//    }
    public void setListener(ListViewListener listener) {
        mListener = listener;
    }

    public void setCountListener(CountListener countListener){
        mcountListener = countListener;
    }


    static class ViewHolder {
        TextView name, price, qty, catid;
        Button btnRemove;
        ImageView img_product;
    }
}