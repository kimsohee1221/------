package com.example.moapp_project.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moapp_project.R;

public abstract class BasicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public abstract void onRequestPermissionResult(int requestCode, String permissions[], int[] grantResults);
}
