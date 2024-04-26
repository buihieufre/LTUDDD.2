package com.example.myapplication.BaiTapTuan4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication.R;

import java.util.ArrayList;

class PersonInfoAdapter extends BaseAdapter implements Adapter {
    @NonNull
    private ArrayList<PersonInfo> arrayListInfo ;
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
        TextView idHolder = null;
        TextView nameHolder = null;

        TextView emailHolder = null;
        TextView addressHolder = null;
        TextView genderHolder= null;
    }

    public PersonInfoAdapter(Context context, ArrayList<PersonInfo> arrayListInfo){
        this.arrayListInfo = arrayListInfo;
        this.context = context;
    }

    @SuppressLint("WrongViewCast")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonInfo personInfo = (PersonInfo) getItem(position);
        ViewHolder viewHolder;
        final View view;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.t4_item_view, parent, false);
            viewHolder.idHolder = convertView.findViewById(R.id.personId);
            viewHolder.nameHolder = convertView.findViewById(R.id.personName);
            viewHolder.emailHolder = convertView.findViewById(R.id.personEmail);
            viewHolder.addressHolder = convertView.findViewById(R.id.personAddress);
            viewHolder.genderHolder = convertView.findViewById(R.id.personGender);
            view = convertView;
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
            view  =convertView;
        }
        viewHolder.idHolder.setText(personInfo.id);
        viewHolder.nameHolder.setText(personInfo.name);
        viewHolder.emailHolder.setText(personInfo.email);
        viewHolder.addressHolder.setText(personInfo.address);
        viewHolder.genderHolder.setText(personInfo.gender);

        return convertView;
    }




}
