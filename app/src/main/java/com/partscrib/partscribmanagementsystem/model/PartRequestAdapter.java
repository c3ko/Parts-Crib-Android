package com.partscrib.partscribmanagementsystem.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.partscrib.partscribmanagementsystem.R;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Map;

public class PartRequestAdapter extends RecyclerView.Adapter<PartRequestAdapter.PartRequestViewHolder> {

    private Map<String, PartRequestModel> mPartRequests;

    public TextView textview;

    public PartRequestAdapter(Map<String,PartRequestModel> partRequests){
        this.mPartRequests = partRequests;
    }

    @NonNull
    @Override
    public PartRequestAdapter.PartRequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.request_list_item, parent, false);
        return new PartRequestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PartRequestAdapter.PartRequestViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PartRequestViewHolder extends RecyclerView.ViewHolder implements View

            .OnClickListener {
        public TextView pinCode;
        public TextView timeRemaining;
        public TextView numItems;
        public TextView PartRequestStatus;

        public PartRequestViewHolder(View itemView){
            super(itemView);
            timeRemaining = (TextView) itemView.findViewById(R.id.request_due_time);
            numItems = (TextView) itemView.findViewById(R.id.request_num_items);
            PartRequestStatus= (TextView) itemView.findViewById(R.id.request_status);

        }

        @Override
        public void onClick(View view) {

        }
    }

}