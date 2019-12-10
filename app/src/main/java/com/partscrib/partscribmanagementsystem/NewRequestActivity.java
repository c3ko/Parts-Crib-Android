package com.partscrib.partscribmanagementsystem;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.partscrib.partscribmanagementsystem.model.PartModel;
import com.partscrib.partscribmanagementsystem.model.PartRequestModel;
import com.partscrib.partscribmanagementsystem.model.RequestModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewRequestActivity extends AppCompatActivity implements View.OnClickListener{

    static final int PICK_PART_REQUEST = 1;

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    Timestamp requestTimeStamp, neededTimeStamp;

    EditText datePickerText;
    EditText timePickerText;
    EditText timeLength;
    FloatingActionButton submitRequestButton;
    Button addNewPart;

    int year, month, day, hour, minute;

    RequestModel requestData;

    List<PartRequestModel> requestedParts;



    private void findAllViews(){
        datePickerText = (EditText) findViewById(R.id.datePicker);
        timePickerText = (EditText) findViewById(R.id.timePicker);
        timeLength = (EditText) findViewById(R.id.timeLength);
 //       submitButton = (Button) findViewById(R.id.submit_new_request_button);

        datePickerText.setOnClickListener(this);
        timePickerText.setOnClickListener(this);
        addNewPart = findViewById(R.id.add_new_part_button);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findAllViews();

        addNewPart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent partIntent = new Intent(NewRequestActivity.this, PartsActivity.class);
                startActivityForResult(partIntent, PICK_PART_REQUEST);
            }
        });

        submitRequestButton = findViewById(R.id.submit_new_request_button);
        submitRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float hours_required = Float.parseFloat(timeLength.getText().toString());
                String givenDateString = String.format("%d %d %d %d:%d", year, month, day, hour, minute);
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY MM dd HH:mm");
                try {
                    Date mDate = sdf.parse(givenDateString);
                    neededTimeStamp = new Timestamp(mDate.getTime());
                    requestTimeStamp = new Timestamp(System.currentTimeMillis());


                } catch (ParseException e){
                    e.printStackTrace();
                }




                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public void onClick(View v){
        if (v == datePickerText){
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                            datePickerText.setText(month + "/" + day + "/" + year);
                            NewRequestActivity.this.year = year;
                            NewRequestActivity.this.month = month;
                            NewRequestActivity.this.day = day;

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
                            NewRequestActivity.this.hour = hourOfDay;
                            NewRequestActivity.this.minute = minute;
                        }
                    }, 0, 0, false);
            timePickerDialog.show();
        }


    }





}
