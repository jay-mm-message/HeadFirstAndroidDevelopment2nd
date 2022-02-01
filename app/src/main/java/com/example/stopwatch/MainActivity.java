package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final String TAG="MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStart(View view) {
        Log.d(TAG, "onClickStart: ");
    }

    public void onClickStop(View view) {
        Log.d(TAG, "onClickStop: ");
    }

    public void onClickReset(View view) {
        Log.d(TAG, "onClickReset: ");
    }
}