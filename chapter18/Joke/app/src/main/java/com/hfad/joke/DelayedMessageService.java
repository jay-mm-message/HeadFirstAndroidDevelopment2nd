package com.hfad.joke;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class DelayedMessageService extends IntentService {

    public static final String EXTRA_MESSAGE = "message";
    public static final int NOTIFICATION_ID = 5453;

    public String TAG = "DelayedMessageService:";

    public DelayedMessageService() {
        super("DelayedMessageService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d(TAG, "onHandleIntent");
        synchronized (this) {
            try {
                wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String text = intent.getStringExtra(EXTRA_MESSAGE);
        Log.d(TAG, "The message: " + text);
        showText(text);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
    }

    private void showText(final String text) {

        if (Build.VERSION.SDK_INT >= 32) {
            //TODO
            Log.d(TAG, "Build.VERSION.SDK_INT " + Build.VERSION.SDK_INT);
        } else {
            Log.d(TAG, "Build.VERSION.SDK_INT " + Build.VERSION.SDK_INT);
            //Create a notification builder
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setSmallIcon(android.R.drawable.sym_def_app_icon)
                    .setContentTitle(getString(R.string.question))
                    .setContentText(text)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setVibrate(new long[] {0, 1000})
                    .setAutoCancel(true);

            //Create an action
            Intent actionIntent = new Intent(this, MainActivity.class);
            @SuppressLint("UnspecifiedImmutableFlag") PendingIntent actionPendingIntent = PendingIntent.getActivity(
                    this,
                    0,
                    actionIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(actionPendingIntent);

            //Issue the notification
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
    }
}
