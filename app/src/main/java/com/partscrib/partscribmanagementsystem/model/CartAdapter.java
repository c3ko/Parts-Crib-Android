package com.partscrib.partscribmanagementsystem.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.partscrib.partscribmanagementsystem.R;

import java.util.List;


public class CartAdapter extends ArrayAdapter {

    List<String> mDataItems;
    LayoutInflater mInflater;
    List<String> namesList;

    public CartAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        mDataItems = objects;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.cart_list_item, null);
           // convertView = mInflater.inflate(R.layout.cart_list_item, parent, false);

        }
        final TextView quantityTextView = (TextView) convertView.findViewById(R.id.quantity_text_view);
        Button quantityMinusButton = (Button) convertView.findViewById(R.id.quantity_minus_button);
        Button quantityPlusButton = (Button) convertView.findViewById(R.id.quantity_plus_button);

        quantityMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(quantityTextView.getText().toString());
                counter--;
                String counterString = counter + "";
                quantityTextView.setText(counterString);
                Log.d("MinusQuantity", "minus button pressed");
            }
        });

        quantityPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(quantityTextView.getText().toString());
                counter++;
                String counterString = counter + "";
                quantityTextView.setText(counterString);
                Log.d("PlusQuantity", "plus button pressed");
            }
        });

        TextView name = (TextView) convertView.findViewById(R.id.part_name);
        TextView quantity = convertView.findViewById(R.id.quantity_text_view);

        String item = mDataItems.get(position);

        // Must contain name in string return of checked items in new parts activity

        name.setText(item);
        quantity.setText("1");

        return convertView;
    }
}
