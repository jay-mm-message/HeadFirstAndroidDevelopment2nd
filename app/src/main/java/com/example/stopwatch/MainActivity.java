package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    final String TAG="MainActivity";
    private int seconds = 0;
    private boolean running = false;

    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view);

        //..
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);

        timeView.setText(time);
        if (running) {
            ++seconds;
        }
        //..
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStart(View view) {
        Log.d(TAG, "onClickStart: ");
        running = true;
    }

    public void onClickStop(View view) {
        Log.d(TAG, "onClickStop: ");
        running = false;
    }

    public void onClickReset(View view) {
        Log.d(TAG, "onClickReset: ");
        running = false;
        seconds = 0;
    }
}