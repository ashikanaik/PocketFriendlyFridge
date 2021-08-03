package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    EditText email;
    Button submit,backToLogin;
    String str_email;
    FirebaseAuth mAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.FPemail);
        submit = findViewById(R.id.FPsubmit);
        backToLogin = findViewById(R.id.FPLogin);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setMessage("Wait for a few minutes...");
                progressDialog.show();
                validateData();
            }
        });

        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPassword.this,Login.class);
                startActivity(intent);
            }
        });
    }

    private void validateData() {
        str_email = email.getText().toString();
        if(str_email.isEmpty()){
            email.setError("Please enter the email");
        } else {
            forgetPass();
        }
    }

    private void forgetPass() {
        mAuth.sendPasswordResetEmail(str_email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(ForgotPassword.this, "Email has been sent. Please check your mail", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgotPassword.this,Login.class));
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(ForgotPassword.this, ""+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}