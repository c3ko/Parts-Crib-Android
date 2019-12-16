package com.partscrib.partscribmanagementsystem;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.partscrib.partscribmanagementsystem.model.ExpandableListPartData;
import com.partscrib.partscribmanagementsystem.model.PartExpandableListAdapter;
import com.partscrib.partscribmanagementsystem.model.PartModel;
import com.partscrib.partscribmanagementsystem.model.PartRequestAdapter;
import com.partscrib.partscribmanagementsystem.model.RequestModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RequestDetailActivity extends AppCompatActivity {

    TextView requestPin, requestTime, timeLength;
    ListView partsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findAllView();

        RequestModel request = (RequestModel) getIntent().getSerializableExtra("requestExtra");

        requestPin.setText(request.getPinCode());
        requestTime.setText(request.getRequestTimeStamp());
        timeLength.setText(request.gettimeLength());

        PartRequestAdapter partRequestAdapter = new PartRequestAdapter(this, R.id.bulletin_listview, request.getParts());
        partsListView.setAdapter(partRequestAdapter);


    }

    public void findAllView(){
        partsListView = (ListView) findViewById(R.id.parts_listview);
        requestPin = (TextView) findViewById(R.id.pin_code);
        requestTime = (TextView) findViewById(R.id.request_time);
        timeLength = (TextView) findViewById(R.id.time_length);
    }


}
