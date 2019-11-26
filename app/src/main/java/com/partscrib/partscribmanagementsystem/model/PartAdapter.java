package com.partscrib.partscribmanagementsystem.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.partscrib.partscribmanagementsystem.R;

import java.util.List;


public class PartAdapter extends RecyclerView.Adapter<PartAdapter.PartViewHolder> {


    private List<PartModel> partsList;

    public PartAdapter(List<PartModel> partsList){
        this.partsList = partsList;
    }

    @NonNull
    @Override
    public PartAdapter.PartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.parts_list_item, parent, false);

        return new PartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PartAdapter.PartViewHolder holder, int position) {
        PartModel partData = this.partsList.get(position);
        holder.partName.setText(partData.getName());
        holder.partID.setText(partData.getId());
        holder.inPartsKit.setText(partData.getInPartsKit());
        holder.partCategory.setText(partData.getCategory());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public List<PartModel> getData() {
        return this.partsList;
    }

    public class PartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView partID, partName, partCategory, inPartsKit;

        public PartViewHolder(@NonNull View itemView) {
            super(itemView);
            partID = (TextView) itemView.findViewById(R.id.part_id);
            partCategory = (TextView) itemView.findViewById(R.id.part_category);
            partName = (TextView) itemView.findViewById(R.id.part_name);
            inPartsKit = (TextView) itemView.findViewById(R.id.in_part_kit);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
