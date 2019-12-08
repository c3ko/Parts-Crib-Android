package com.partscrib.partscribmanagementsystem.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.partscrib.partscribmanagementsystem.R;

import java.util.List;

public class BulletinAdapter extends ArrayAdapter {


    List<BulletinModel> mDataItems;
    LayoutInflater mInflater;

    public BulletinAdapter(@NonNull Context context, int resource,  @NonNull List objects){
        super(context, resource, objects);
        mDataItems = objects;
        mInflater = LayoutInflater.from(context);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.bulletin_list_item, parent, false);

        }


        TextView title = (TextView) convertView.findViewById(R.id.bulletin_title);
        TextView date = (TextView) convertView.findViewById(R.id.bulletin_date);
        TextView message = (TextView) convertView.findViewById(R.id.bulletin_message);

        BulletinModel item = mDataItems.get(position);

        title.setText(item.getTitle());
        date.setText(item.getDate());
        message.setText(item.getMessage());

        return convertView;
    }
}

