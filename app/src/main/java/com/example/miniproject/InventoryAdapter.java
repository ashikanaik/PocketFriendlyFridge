package com.example.miniproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.InventoryViewHolder> {

    Context context;
    ArrayList<Item> list;

    public InventoryAdapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new InventoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryAdapter.InventoryViewHolder holder, int position) {
        Item itemObj = list.get(position);
        holder.name.setText(itemObj.name);
        holder.amount.setText(itemObj.amount);
        holder.expiry.setText(itemObj.expiry);
        holder.unit.setText(itemObj.unit);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class InventoryViewHolder extends RecyclerView.ViewHolder{

        TextView name,amount,expiry,unit;


        public InventoryViewHolder(@NonNull  View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvItemName);
            amount = itemView.findViewById(R.id.tvItemAmount);
            expiry = itemView.findViewById(R.id.tvItemDate);
            unit = itemView.findViewById(R.id.tvItemUnit);
        }
    }
}
