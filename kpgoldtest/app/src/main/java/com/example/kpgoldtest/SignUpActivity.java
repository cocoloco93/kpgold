package com.example.kpgoldtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    EditText edemail;
    EditText edpassword;
    EditText edcompassword;
    Button btsignup;
    FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        edemail = (EditText) findViewById(R.id.ed_email);
        edpassword = (EditText) findViewById(R.id.ed_password);
        edcompassword = (EditText) findViewById(R.id.ed_com_password);
        btsignup = (Button) findViewById(R.id.bt_sign_up);
        btsignup.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String email = edemail.getText().toString();
                String password = edpassword.getText().toString();
                if (email.isEmpty()) {
                    email.setError("Please Enter Email id");
                    email.requestFocus();
                } else if (password.isEmpty()) {
                    password.setError("Please Enter your password");
                    password.requestFocus();
                } else if (email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please fill the requirement!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && password.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "SignUp Unsccessful ,please Try Again!", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(SignUpActivity.this, inputActivity2.class));
                            }
                        }

                    });
                } else {
                    Toast.makeText(SignUpActivity.this, "Password or Eamil is worng!", Toast.LENGTH_SHORT).show();


                }

            }
        });
    }
}