package com.example.myapplication.BaiTapTuan6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class GiayInfoAdapter extends BaseAdapter implements Adapter {
    @NonNull
    private ArrayList<GiayInfo> arrayListInfo ;
    private Context context;

    @Override
    public int getCount() {
        return arrayListInfo.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected static class ViewHolder {
        ImageView search_image_holder = null;
        TextView styleid_holder = null;
        TextView brands_filter_facet_holder = null;
        TextView price_holder = null;
        TextView product_additional_info_holder = null;
    }

    public GiayInfoAdapter(Context context, ArrayList<GiayInfo> arrayListInfo){
        this.arrayListInfo = arrayListInfo;
        this.context = context;
    }

    @SuppressLint("WrongViewCast")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        final View view;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.t6_item_view, parent, false);
            viewHolder.search_image_holder = convertView.findViewById(R.id.t6Image);
            viewHolder.styleid_holder = convertView.findViewById(R.id.t6Id);
            viewHolder.brands_filter_facet_holder = convertView.findViewById(R.id.t6Brand);
            viewHolder.price_holder = convertView.findViewById(R.id.t6Price);
            viewHolder.product_additional_info_holder = convertView.findViewById(R.id.t6Info);
            view = convertView;
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
            view  =convertView;
        }
        GiayInfo giayInfo1 = arrayListInfo.get(position);
        if(giayInfo1 != null){
            Picasso.get().load(giayInfo1.getSearch_image()).placeholder(R.drawable.ic_launcher_background).into(viewHolder.search_image_holder);
        }
        viewHolder.styleid_holder.setText(giayInfo1.styleid);
        viewHolder.brands_filter_facet_holder.setText(giayInfo1.brands_filter_facet);
        viewHolder.price_holder.setText(giayInfo1.price);
        viewHolder.product_additional_info_holder.setText(giayInfo1.product_additional_info);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GiayInfo product = arrayListInfo.get(position);
                Intent intent = new Intent(context, T7DetailGiayInfo.class);
                intent.putExtra("PRODUCT",product);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);
            }
        });
        return convertView;
    }




}
