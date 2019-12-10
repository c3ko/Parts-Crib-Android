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

public class PartAdapter  extends ArrayAdapter<PartModel> {

    List<PartModel> mDataItems;
    LayoutInflater mInflater;

    public PartAdapter(@NonNull Context context, int resource, @NonNull List<PartModel> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.part_list_item, parent, false);

        }


        TextView name = (TextView) convertView.findViewById(R.id.part_name);
        TextView quantity = (TextView) convertView.findViewById(R.id.part_quantity);

        PartModel item = mDataItems.get(position);


        name.setText(item.getName());
        quantity.setText(item.getCategory());

        return convertView;
    }
}
