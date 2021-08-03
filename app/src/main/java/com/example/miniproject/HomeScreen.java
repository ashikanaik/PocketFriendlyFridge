package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class HomeScreen extends AppCompatActivity {

    ImageButton inventoryBtn, recipeBtn;
    TextView logoutBtn;
    FirebaseAuth mAuth;
    private SignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        inventoryBtn = findViewById(R.id.inventorybtn);
        recipeBtn = findViewById(R.id.recipebtn);
        logoutBtn = findViewById(R.id.logOutBtn);
        mAuth = FirebaseAuth.getInstance();

        inventoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, Inventory.class);
                startActivity(intent);
            }
        });

        recipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, Recipes.class);
                startActivity(intent);
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAuth.getCurrentUser()!=null) {
                    mAuth.signOut();
                    Intent intent = new Intent(HomeScreen.this, Login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else
                if(mGoogleSignInClient!=null){
                    Toast.makeText(HomeScreen.this, "Google", Toast.LENGTH_SHORT).show();
                logoutFromGoogle();}
                else {
                logoutFromFacebook();}
            }
        });



    }

    private void logoutFromGoogle() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // [START_EXCLUDE]
                        Intent intent = new Intent(HomeScreen.this, Login.class);
                        startActivity(intent);
                        // [END_EXCLUDE]
                    }
                });
    }

    public void logoutFromFacebook(){
        LoginManager.getInstance().logOut();

        Intent intent = new Intent(HomeScreen.this, Login.class);
        startActivity(intent);

        finish();
    }

}