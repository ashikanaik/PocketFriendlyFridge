package com.example.miniproject;

//import android.content.Intent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginTabFragment extends Fragment {

    EditText email;
    EditText password;
    TextView forgotPass;
    Button login;
    float v=0;
    String username;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    private FirebaseAuth mAuth;
    private ProgressDialog mLoadingBar;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container,false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        forgotPass = root.findViewById(R.id.forgot_pass);
        login = root.findViewById(R.id.login);


        email.setTranslationX(800);
        password.setTranslationX(800);
        forgotPass.setTranslationX(800);
        login.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        forgotPass.setAlpha(v);
        login.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgotPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        mAuth = FirebaseAuth.getInstance();

        mLoadingBar = new ProgressDialog(getContext());

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                rootNode = FirebaseDatabase.getInstance();
//                reference = rootNode.getReference("users");
//                reference.child(mAuth.getUid()).setValue("");
               checkCredentials();
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),ForgotPassword.class);
                startActivity(intent);
            }
        });

        return root;
    }

    private void checkCredentials(){
        String emailId = email.getText().toString();
        String pass = password.getText().toString();

        if(emailId.isEmpty() || !emailId.contains("@")) {
            email.setError("Please enter valid email");
        } else if(pass.isEmpty() || pass.length() < 8) {
            password.setError("Please enter password of minimum 8 characters");
        } else {
            mLoadingBar.setTitle("Login");
            mLoadingBar.setMessage("Please wait, checking ur credentials");
            mLoadingBar.setCanceledOnTouchOutside(false);
            mLoadingBar.show();

            mAuth.signInWithEmailAndPassword(emailId,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getContext(), "Login is successful", Toast.LENGTH_SHORT).show();
                        mLoadingBar.dismiss();
                        Intent intent = new Intent(getContext(), HomeScreen.class);
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
