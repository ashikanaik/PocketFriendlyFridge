package com.example.miniproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<FoodViewHolder>{

    private Context mcontext;
    private List<FoodData> foodDataList;

    public MyAdapter(Context mcontext, List<FoodData> foodDataList) {
        this.mcontext = mcontext;
        this.foodDataList = foodDataList;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_item, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.imageView.setImageResource(foodDataList.get(position).getItemImage());
        holder.mTitle.setText(foodDataList.get(position).getItemName());
        holder.mDescription.setText(foodDataList.get(position).getItemDescription());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, DetailedRecipe.class);
                intent.putExtra("Image",foodDataList.get(holder.getAdapterPosition()).getItemImage());
                intent.putExtra("Description",foodDataList.get(holder.getAdapterPosition()).getItemDescription());
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodDataList.size();
    }
}

class FoodViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView mTitle, mDescription;
    CardView mCardView;

    public FoodViewHolder(View itemView){
        super(itemView);

        imageView = itemView.findViewById(R.id.image1);
        mTitle = itemView.findViewById(R.id.image1Title);
        mDescription = itemView.findViewById(R.id.image1Description);
        mCardView = itemView.findViewById(R.id.myCardView);
    }
}
