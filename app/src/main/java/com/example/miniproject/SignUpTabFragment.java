package com.example.miniproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpTabFragment extends Fragment {

    EditText email;
    EditText fname ;
    EditText pwd;
    EditText confirmPass;
    Button signUpButton;
    private FirebaseAuth mAuth;
    private ProgressDialog mLoadingBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.sign_up_tab_fragment, container,false);



        fname = root.findViewById(R.id.first_name);
        email = root.findViewById(R.id.email);
        pwd = root.findViewById(R.id.password);
        signUpButton = root.findViewById(R.id.sign_up);
        confirmPass = root.findViewById(R.id.confirm_password);

        mAuth = FirebaseAuth.getInstance();

        mLoadingBar = new ProgressDialog(getContext());

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("thread", "onClick: Entered" );
                checkCredentials();
            }
        });
        return root;
    }
    private void checkCredentials() {
        String firstname = fname.getText().toString();
        String emailId = email.getText().toString();
        String password = pwd.getText().toString();
        String confirmPassword = confirmPass.getText().toString();

        if (firstname.isEmpty()) {
            fname.setError("Please enter your name");
        } else if (emailId.isEmpty() || !emailId.contains("@")) {
            email.setError("Please enter valid email");
        } else if(password.isEmpty() || password.length() < 8) {
            pwd.setError("Please password of minimum 8 characters");
        } else if (confirmPassword.isEmpty() || !confirmPassword.equals(password)) {
            confirmPass.setError("Please check the password and enter again");
        } else {
            mLoadingBar.setTitle("Registration");
            mLoadingBar.setMessage("Please wait, checking ur credentials");
            mLoadingBar.setCanceledOnTouchOutside(false);
            mLoadingBar.show();

            mAuth.createUserWithEmailAndPassword(emailId, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getContext(), "Sign Up is successful", Toast.LENGTH_SHORT).show();
                        mLoadingBar.dismiss();
                        Intent intent = new Intent(getContext(), Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    } else {
                        mLoadingBar.dismiss();
                        Toast.makeText(getContext(), task.getException().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

}

