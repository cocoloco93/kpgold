package com.example.kpgoldtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    CheckBox ckbcycp, ckbtaxip, ckbmediump, ckbsuvp, ckblvehiclep;
    CheckBox ckbcycn, ckbtaxin, ckbmediumn, ckbsuvn, ckblvehiclen;
    EditText txttotalcostbox;
    Button bt_upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input1);

        ckbcycp = findViewById(R.id.ckbcycp);
        ckbtaxip = findViewById(R.id.ckbtaxip);
        ckbcycp = findViewById(R.id.ckbmediump);
        ckbtaxip = findViewById(R.id.ckbsuvp);
        ckbcycp = findViewById(R.id.ckblvehiclep);
        ckbtaxip = findViewById(R.id.ckbcycp);
        ckbcycp = findViewById(R.id.ckbtaxin);
        ckbtaxip = findViewById(R.id.ckbmediumn);
        ckbcycp = findViewById(R.id.ckbsuvn);
        ckbtaxip = findViewById(R.id.ckblvehiclen);
        txttotalcostbox = findViewById(R.id.txttotalcostbox);
        bt_upload = findViewById(R.id.bt_upload);
    }
}
