package com.partscrib.partscribmanagementsystem;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.partscrib.partscribmanagementsystem.model.CartAdapter;
import com.partscrib.partscribmanagementsystem.model.PartModel;
import com.partscrib.partscribmanagementsystem.model.PartRequestModel;
import com.partscrib.partscribmanagementsystem.model.RequestModel;
import com.partscrib.partscribmanagementsystem.model.UserDataModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewRequestActivity extends AppCompatActivity implements View.OnClickListener{

    static final int PICK_PART_REQUEST = 1;

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    long requestTimeStamp, neededTimeStamp;
    String savedDate, savedTime, savedLength;
    EditText datePickerText;
    EditText timePickerText;
    EditText timeLength;
    TextView partCountText;

    FloatingActionButton submitRequestButton;
    Button addNewPart, quantityPlusButton, quantityMinusButton;

    int year, month, day, hour, minute;



    ListView cartListView;
    CartAdapter cartAdapter;

    private void findAllViews(){
        cartListView = (ListView) findViewById(R.id.cart_listview);
        datePickerText = (EditText) findViewById(R.id.datePicker);
        timePickerText = (EditText) findViewById(R.id.timePicker);
        timeLength = (EditText) findViewById(R.id.timeLength);
        partCountText = findViewById(R.id.quantity_text_view);

        quantityPlusButton = findViewById(R.id.quantity_plus_button);
        quantityMinusButton = findViewById(R.id.quantity_minus_button);
        submitRequestButton = findViewById(R.id.submit_new_request_button);


 //       submitButton = (Button) findViewById(R.id.submit_new_request_button);

        datePickerText.setOnClickListener(this);
        timePickerText.setOnClickListener(this);
        addNewPart = findViewById(R.id.add_new_part_button);

        if (savedDate  != null){
            datePickerText.setText(savedDate);
        }
        if (savedTime != null){
            timePickerText.setText(savedTime);
        }

        if (savedLength != null){
            timeLength.setText(savedLength);
        }

    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_PART_REQUEST){
            if (resultCode == RESULT_OK){

                List<String> partsRequestList= data.getStringArrayListExtra("partsRequestList");
                Log.d("pickPartResult", "There are " + partsRequestList.size() + " items in cart");
                cartAdapter = new CartAdapter(this, R.id.cart_listview, partsRequestList);

                cartListView.setAdapter(cartAdapter);
            }
        }
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



        submitRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float hours_required = Float.parseFloat(timeLength.getText().toString());
                String givenDateString = String.format("%d %d %d %d:%d", year, month, day, hour, minute);
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY MM dd HH:mm");
                try {
                    Date mDate = sdf.parse(givenDateString);
                    neededTimeStamp = new Timestamp(mDate.getTime()).getTime();
                    requestTimeStamp = new Timestamp(mDate.getTime()).getTime();




                } catch (ParseException e){
                    e.printStackTrace();
                }


                database = FirebaseDatabase.getInstance();
                final String user = getIntent().getStringExtra(Login.USER_NAME_MESSAGE);

                String path = "userdata/Eku12REjXNfMsOPmShnbTB68mmc2" + "/requests";

                String neededString = neededTimeStamp + "";
                String requestString = requestTimeStamp + "";
                PartRequestModel board = new PartRequestModel("Arduino", "1");
                PartRequestModel resistor = new PartRequestModel("100 Ohm Resistor", "2");

                List<PartRequestModel> parts = new ArrayList<>();
                parts.add(board);
                parts.add(resistor);
                RequestModel request = new RequestModel("14", "3", neededString, requestString, "Submitted", parts, "43215");

                myRef = database.getReference(path);
                myRef.push().setValue(request).addOnSuccessListener(new OnSuccessListener<Void>(){

                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("Request", "Added new request to : " + user);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("Request", "Writing to userdata failed");
                    }
                });

                finish();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("pickUpDate", datePickerText.getText().toString());
        savedInstanceState.putString("pickUpTime", timePickerText.getText().toString());
        savedInstanceState.putString("timeLength", timeLength.getText().toString());


    };

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        savedDate = savedInstanceState.getString("pickUpDate");
        savedTime = savedInstanceState.getString("pickUpTime");
        savedLength = savedInstanceState.getString("timeLength");

    };

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
