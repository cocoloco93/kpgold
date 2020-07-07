package com.example.kpgoldtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;


import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    EditText emid;
    EditText pwd;
    Button login;
    TextView txtSignup;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateLister;


    /*
    String passwordholder;
    String emailholder;
    String finalResult;
    String HttpURL = "https://kpgold.000webhostapp.com/Login/Logintest.php";
    Boolean CheckEditText;
    ProgressDialog progressDialog;
    HashMap<String, String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    public static final String useremail = "";

     */



     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emid = (EditText) findViewById(R.id.ed_email);
        pwd = (EditText) findViewById(R.id.ed_password);
        login = (Button) findViewById(R.id.bt_login);
        txtSignup = (TextView) findViewById(R.id.txtSignup);

        mAuthStateLister = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if( mFirebaseUser != null){
                    Toast.makeText(LoginActivity.this,"You are logged in",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this,inputActivity2.class);
                    startActivity(i);
                }
                else {Toast.makeText(LoginActivity.this,"Please Log in",Toast.LENGTH_SHORT).show();
            }

            }

            };
        login.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(LoginActivity.this, "Please fill the requirement!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && password.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "LogIn Error,Please Try Again!", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent signup = new Intent(LoginActivity.this, SignUpActivity.class);
                                startActivity(signup);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(LoginActivity.this, "Password or Eamil is worng!", Toast.LENGTH_SHORT).show();


                }

            }

        });

        }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateLister);
    }
}

/*

        txtSignup.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String email = emid.getText().toString();
                String password=pwd.getText().toString();
                if(email.isEmpty()){
                    emid.setError("Please Enter Email id");
                    emid.requestFocus();
                }

                else if (password.isEmpty()){
                    pwd.setError("Please Enter your password");
                    pwd.requestFocus();
                }

                else if (email.isEmpty() && password.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Please fill the requirement!", Toast.LENGTH_SHORT).show();
                }
                else if (!(email.isEmpty() && password.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                                    if (!task.isSuccessful()){
                                        Toast.makeText(LoginActivity.this,"Please fill the requirement!", Toast.LENGTH_SHORT).show();
                                    }

                                    }
                                    else
                                }

                                }
                            }
                    )
                }
            }

                /*
                Intent SignupIntent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(SignupIntent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CheckEditTextIsEmptyOrNot();


                if (CheckEditText) {

                    UserLoginFunction(emailholder, passwordholder);

                } else {

                    Toast.makeText(LoginActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }


            }


        });
    }


    public void CheckEditTextIsEmptyOrNot() {

        emailholder = email.getText().toString();
        passwordholder = password.getText().toString();

        if (TextUtils.isEmpty(emailholder) || TextUtils.isEmpty(passwordholder)) {
            CheckEditText = false;

        } else {

            CheckEditText = true;
        }
    }

    public void UserLoginFunction(final String email, final String password) {

        class UserLoginClass extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(LoginActivity.this, "Loading Data", null, true, true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                //String s = httpResponseMsg.trim();

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                //Log.d("UserLoginClass", httpResponseMsg);


                if ((emailholder.equalsIgnoreCase("ceo@gmail.com")) && passwordholder.equalsIgnoreCase("ceo")) {

                    //finish();

                    Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);

                    intent.putExtra(useremail, email);

                    startActivity(intent);

                } else if ((emailholder.equalsIgnoreCase("manager@gmail.com")) && passwordholder.equalsIgnoreCase("manager")){

                    Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);

                    intent.putExtra(useremail, email);

                    startActivity(intent);

                }else{
                    Toast.makeText(LoginActivity.this, httpResponseMsg, Toast.LENGTH_LONG).show();
                }

            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("email", params[0]);

                hashMap.put("password", params[1]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserLoginClass userLoginClass = new UserLoginClass();

        userLoginClass.execute(email, password);




}}



