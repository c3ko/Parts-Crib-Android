package com.partscrib.partscribmanagementsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.davidmiguel.numberkeyboard.NumberKeyboard;
import com.davidmiguel.numberkeyboard.NumberKeyboardListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.partscrib.partscribmanagementsystem.model.ExpandableListPartData;
import com.partscrib.partscribmanagementsystem.model.PartExpandableListAdapter;
import com.partscrib.partscribmanagementsystem.model.PartModel;

import android.os.Bundle;
import android.service.autofill.UserData;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.partscrib.partscribmanagementsystem.Login.USER_NAME_MESSAGE;

public class KeypinActivity extends AppCompatActivity {

    NumberKeyboard numberKeyboard;
    TextView textView;
    String keypin = "";

    private FirebaseDatabase db;
    private DatabaseReference dbRef, myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keypin);

        numberKeyboard = (NumberKeyboard) findViewById(R.id.numberKeyboard);
        textView = (TextView) findViewById(R.id.keypin_text);
        numberKeyboard.showRightAuxButton();

        db = FirebaseDatabase.getInstance();
        String user = getIntent().getStringExtra(USER_NAME_MESSAGE);

        String path = "userdata/" + user + "/currentPinEntry";


        dbRef = db.getReference(path);

        getCurrentPin();
        numberKeyboard.setListener(new NumberKeyboardListener() {
            @Override
            public void onNumberClicked(int number) {
                if (keypin.length() < 6){
                    setCurrentPin(number);
                    textView.setText(keypin);
                }
                else {

                }

            }

            @Override
            public void onLeftAuxButtonClicked() {

            }

            @Override
            public void onRightAuxButtonClicked() {

            }
        });

    }


    public void setCurrentPin(int number){
        keypin = keypin + number;
        // Submit pin to firebase


        dbRef.setValue(keypin);


    }
    public void getCurrentPin(){


        dbRef.addChildEventListener(new ChildEventListener() {


            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                keypin = dataSnapshot.getValue(String.class);
                textView.setText(keypin);

            }



            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                keypin = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });


    }
}
