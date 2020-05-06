package com.example.kotevent;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_ingreso);
    }
    public void onClick(View view){
        startActivity(new Intent("com.example.SignupActivity"));
    }
    public void onClickMain(View view){
        startActivity(new Intent("com.example.MainActivity"));
    }
}
