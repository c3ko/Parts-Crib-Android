package com.partscrib.partscribmanagementsystem;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.partscrib.partscribmanagementsystem.model.PartAdapter;
import com.partscrib.partscribmanagementsystem.model.PartModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PartsActivity extends AppCompatActivity {

    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private RecyclerView recyclerView;
    PartModel part;
    PartAdapter mAdapter;
    private TextView partID;
    private TextView partName;
    private TextView partCategory;
    private TextView inPartsKit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findAllViews();
        getDB();
        getAllParts();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    };

    private void processDataAdapter(){
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

/*
       TODO 3: Obtain a handle to the object,
               connect it to a layout manager,
               and attach an adapter for the data to be displayed.
*/


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        // Pass the data list to the adapter
        mAdapter = new PartAdapter(PartModel);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
    }
    private void findAllViews(){
        partID = findViewById(R.id.part_id);
        partName = findViewById(R.id.part_name);
        partCategory = findViewById(R.id.part_category);
        inPartsKit = findViewById(R.id.in_part_kit);
    }

    private void getDB(){
        db = FirebaseDatabase.getInstance();
        FirebaseAuth  mAuth = FirebaseAuth.getInstance();
        String path = "parts/";
        dbRef = db.getReference(path);
    }

    public void getAllParts(){
        dbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                PartModel p = dataSnapshot.getValue(PartModel.class);
                partName.setText("Part ID: " + p.getId());
                partName.setText("Part Name: " + p.getName());
                partName.setText("Part Category: " + p.getCategory());

                partName.setText("In Parts Kit: " + p.getInPartsKit());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                PartModel p = dataSnapshot.getValue(PartModel.class);
                partName.setText("Part ID: " + p.getId());
                partName.setText("Part Name: " + p.getName());
                partName.setText("Part Category: " + p.getCategory());

                partName.setText("In Parts Kit: " + p.getInPartsKit());
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

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<PartModel> arrayList = new ArrayList<PartModel>();
                if (dataSnapshot != null && dataSnapshot.getValue() != null){
                    for (DataSnapshot a: dataSnapshot.getChildren()){
                        PartModel newPart = new PartModel();
                        newPart.setId(a.getValue(PartModel.class).getId());
                        newPart.setName(a.getValue(PartModel.class).getName());
                        newPart.setCategory(a.getValue(PartModel.class).getCategory());
                        newPart.setInPartsKit(a.getValue(PartModel.class).getInPartsKit());

                        arrayList.add(newPart);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }






}


