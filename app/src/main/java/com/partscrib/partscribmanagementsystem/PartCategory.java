package com.partscrib.partscribmanagementsystem;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PartCategory extends AppCompatActivity {
    public static final String CATEGORY_MESSAGE = "com.partscrib.partscribmanagementsystem.CATEGORY";

    private ListView categoryListView;

    private String[] categoryData = new String [] {"Resistor", "Capacitor", "Diode", "Power Cable"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        categoryListView = (ListView) findViewById(R.id.parts_category_listview);


        categoryListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categoryData));

        categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int i, long l) {
                String categoryClicked = (String) adapter.getItemAtPosition(i);
                Intent intent = new Intent(view.getContext(), PartsActivity.class);
                intent.putExtra(CATEGORY_MESSAGE, categoryClicked);
                Log.d("Category Clicked", categoryClicked);
                startActivity(intent);
            }
        });

    }

}
