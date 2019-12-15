package com.partscrib.partscribmanagementsystem;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.partscrib.partscribmanagementsystem.model.BulletinAdapter;
import com.partscrib.partscribmanagementsystem.model.BulletinModel;
import com.partscrib.partscribmanagementsystem.model.ExpandableListPartData;
import com.partscrib.partscribmanagementsystem.model.PartAdapter;
import com.partscrib.partscribmanagementsystem.model.PartExpandableListAdapter;
import com.partscrib.partscribmanagementsystem.model.PartModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.partscrib.partscribmanagementsystem.PartCategory.CATEGORY_MESSAGE;

public class PartsActivity extends AppCompatActivity {

    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    ExpandableListView expandableListView;
    PartExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    Button quantityPlusButton, quantityMinusButton;

    final List<PartModel> partList = new ArrayList<>();


    private TextView partNameText;
    private TextView partCountText;
    private String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findAllViews();
        db = FirebaseDatabase.getInstance();

        String path = "parts/";
        dbRef = db.getReference(path);

        category = getIntent().getStringExtra(CATEGORY_MESSAGE);

        expandableListView = (ExpandableListView) findViewById(R.id.partsExpandableListView);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                Log.d("ExpandableOnCLick", "Clicked on item");
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });


        getAllParts();


    };


    public void sendPartsInfoBack(){
        Intent returnRequest = new Intent();



        ArrayList<String> namesList = new ArrayList<String>(expandableListAdapter.getSelectedItemNames());
        returnRequest.putStringArrayListExtra("partsRequestList", namesList);
        setResult(NewRequestActivity.RESULT_OK, returnRequest);
        Log.d("Back Pressed", "Picked parts and returning to NewRequest Activity");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
            switch(item.getItemId()){
                case android.R.id.home:
                    sendPartsInfoBack();
                    finish();
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }

    }

    @Override
    public void onBackPressed(){
        sendPartsInfoBack();
        finish();
    }


    private void findAllViews() {
        partNameText = findViewById(R.id.part_name);

    };




    public void getAllParts(){


        dbRef.addChildEventListener(new ChildEventListener() {


            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                PartModel newPart = dataSnapshot.getValue(PartModel.class);
                partList.add(newPart);
                expandableListDetail = ExpandableListPartData.getData(partList);
                expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
                expandableListAdapter = new PartExpandableListAdapter(PartsActivity.this, expandableListTitle, expandableListDetail);
                expandableListView.setAdapter(expandableListAdapter);


            }



            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


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


