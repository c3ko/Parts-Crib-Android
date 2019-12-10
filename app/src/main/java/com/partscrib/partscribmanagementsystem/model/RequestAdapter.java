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

public class RequestAdapter extends ArrayAdapter {


    List<RequestModel> mDataItems;
    LayoutInflater mInflater;

    public RequestAdapter(@NonNull Context context, int resource,  @NonNull List objects){
        super(context, resource, objects);
        mDataItems = objects;
        mInflater = LayoutInflater.from(context);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.request_list_item, parent, false);

        }


        TextView requestTimeText = (TextView) convertView.findViewById(R.id.request_due_time);
        TextView statusText = (TextView) convertView.findViewById(R.id.request_status);
        TextView pinText = (TextView) convertView.findViewById(R.id.request_pin);

        RequestModel item = mDataItems.get(position);

        requestTimeText.setText(item.getRequestTimeStamp());
        statusText.setText(item.getRequestStatus());
        pinText.setText(item.getPinCode());

        return convertView;
    }
}

