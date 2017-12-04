package com.sonika.nepstra.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sonika.nepstra.R;
import com.sonika.nepstra.pojo.MyData;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Prakriti on 9/1/2017.
 */

public class CategoryAdapter extends BaseAdapter {

    private Context context;
    private List<MyData> my_data;
    int resource;

    public CategoryAdapter(Context context, List<MyData> my_data, int resource) {
        this.context = context;
        this.my_data = my_data;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return my_data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View row = convertView;
        ViewHolderCat holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);
            holder = new ViewHolderCat();

            holder.cat_name = row.findViewById(R.id.cat_name);
            holder.cat_img_product = row.findViewById(R.id.cat_image);

            row.setTag(holder);
        } else {
            holder = (ViewHolderCat) row.getTag();
        }


        holder.cat_name.setText(my_data.get(position).getName());
        Picasso.with(context).load(my_data.get(position).getSrc()).into(holder.cat_img_product);
        return row;

    }
    static class ViewHolderCat {
        TextView cat_name;
        ImageView cat_img_product;
    }
}



//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list,parent,false);
//        return new ViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, final int position) {
//
//        MyData productObject = my_data.get(position);
//
//        holder.name1.setText(productObject.getName());
//
//        Picasso.with(context).load(productObject.getSrc()).into(holder.imageview1);
////        holder.itemView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                MyData intentprod = my_data.get(position);
////                Intent intent = new Intent(context, categories_item.class);
////                intent.putExtra("hello", intentprod);
////                context.startActivity(intent);
////            }
////        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//
//
//        return my_data.size();
//
//    }
//
//
//
//    public static class ViewHolder extends RecyclerView.ViewHolder{
//        TextView name1;
//        ImageView imageview1;
//
//
//        public ViewHolder(View itemV) {
//            super(itemV);
//             name1 = itemV.findViewById(R.id.cat_name);
//
//            imageview1 =  itemV.findViewById(R.id.cat_image);
//
//        }
//    }}

  /*  public static int getResourceId(Context context, String pVariableName, String pResourcename, String pPackageName) throws RuntimeException {
        try {
            return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            throw new RuntimeException("Error getting Resource ID.", e);
        }
    }


}*/
