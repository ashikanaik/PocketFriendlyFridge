package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class FoodData extends AppCompatActivity {

    private String itemName, itemDescription;
    private int itemImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_data);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_food_data);

    }

    public FoodData(String itemName,String itemDescription, int itemImage)
    {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public int getItemImage() {
        return itemImage;
    }
}