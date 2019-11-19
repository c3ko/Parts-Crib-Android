package com.partscrib.partscribmanagementsystem;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.partscrib.partscribmanagementsystem.model.PartModel;
import com.partscrib.partscribmanagementsystem.model.RequestModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.List;

public class NewRequestActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    EditText datePickerText;
    EditText timePickerText;
    EditText timeLength;

    float hours_required;
    RequestModel requestData;

    List<PartModel> requestedParts;

    private void findAllViews(){
        datePickerText = (EditText) findViewById(R.id.datePicker);
        timePickerText = (EditText) findViewById(R.id.timePicker);
        timeLength = (EditText) findViewById(R.id.timeLength);

        datePickerText.setOnClickListener(this);
        timePickerText.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findAllViews();
    }

    @Override
    public void onClick(View v){
        if (v == datePickerText){
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                            datePickerText.setText(month + "/" + day + "/" + year);
                        }
                    }, 2019, 12, 31);
            datePickerDialog.show();
        }

        else if (v == timePickerText){
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            timePickerText.setText(hourOfDay + ":" + minute);
                        }
                    }, 0, 0, false);
            timePickerDialog.show();
        }
    }

    private void retrieveAllCurrentRequests(){
        // Get all requests for current user
        database = FirebaseDatabase.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        String path = "users/";
    }



}
