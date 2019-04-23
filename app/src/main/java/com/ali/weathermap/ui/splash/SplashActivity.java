package com.ali.weathermap.ui.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ali.weathermap.Navigator;
import com.ali.weathermap.R;
import com.ali.weathermap.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Navigator.navigate(SplashActivity.this, MainActivity.class, true);
    }
}
