package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedRecipe extends AppCompatActivity {

    TextView foodDescription;
    ImageView foodImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_recipe);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detailed_recipe);

        foodDescription = findViewById(R.id.textDescription);
        foodImage = findViewById(R.id.image2);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            foodDescription.setText(bundle.getString("Description"));
            foodImage.setImageResource(bundle.getInt("Image"));
        }


    }
}