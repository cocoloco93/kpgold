package com.example.kpgoldtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePageActivity extends AppCompatActivity {
    //Initialize variable
    TextView tvUsername;
    Button btinput;
    Button btoutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //Assign variable
        tvUsername = findViewById(R.id.tv_username);
        btinput = findViewById(R.id.bt_input);
        btoutput = findViewById(R.id.bt_output);

        btinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputActivity();
            }
        });


    }
    public void InputActivity(){
        Intent intent = new Intent(HomePageActivity.this, InputActivity.class);
        startActivity(intent);
    }

}