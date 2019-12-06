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

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestViewHolder> {

    private List<RequestModel> mRequests;

    public TextView textview;

    public RequestAdapter(List<RequestModel> requests){
        this.mRequests = requests;
    }

    @NonNull
    @Override
    public RequestAdapter.RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.request_list_item, parent, false);
        return new RequestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestAdapter.RequestViewHolder holder, int position) {
        RequestModel request = mRequests.get(position);
        holder.pinCode.setText(request.getPinCode());
        holder.timeRemaining.setText(request.getRequestTimeStamp());
        holder.numItems.setText(request.getNumItems());
        holder.requestStatus.setText(request.getRequestStatus());


    }

    @Override
    public int getItemCount() {
        return mRequests.size();
    }


    public class RequestViewHolder extends RecyclerView.ViewHolder implements View

            .OnClickListener {
        public TextView pinCode;
        public TextView timeRemaining;
        public TextView numItems;
        public TextView requestStatus;

        public RequestViewHolder(View itemView){
            super(itemView);
            timeRemaining = (TextView) itemView.findViewById(R.id.request_due_time);
            numItems = (TextView) itemView.findViewById(R.id.request_num_items);
            requestStatus= (TextView) itemView.findViewById(R.id.request_status);

        }

        @Override
        public void onClick(View view) {

        }
    }

}