package com.example.kotevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.view.WindowManager;
//Renzo Cuadros Salazar
//Sergio Gamero Calle
//Gricel Ramos Ramos
public class splash_activity extends AppCompatActivity {

    private final int DURACION_SPLASH = 1500;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_activity);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(splash_activity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}
