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

public class PartRequestAdapter extends ArrayAdapter {
    List<PartRequestModel> mDataItems;
    LayoutInflater mInflater;

    public PartRequestAdapter(@NonNull Context context, int resource,  @NonNull List objects){
        super(context, resource, objects);
        mDataItems = objects;
        mInflater = LayoutInflater.from(context);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.part_list_item, parent, false);

        }


        TextView partNameText = (TextView) convertView.findViewById(R.id.part_name);
        TextView partQuantityText = (TextView) convertView.findViewById(R.id.part_quantity);

        PartRequestModel item = mDataItems.get(position);


        partNameText.setText(item.getName());
        partQuantityText.setText(item.getQuantity());


        return convertView;
    }
}
