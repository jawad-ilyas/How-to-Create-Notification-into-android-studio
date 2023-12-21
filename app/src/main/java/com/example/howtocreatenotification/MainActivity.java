package com.example.howtocreatenotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private static final  String CHANNEL_ID = "CHANNEL ID";
    private static final  int NOTIFICATION_ID = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Notification notification;
        // 4- need to change png into Bitmap

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),
                R.drawable.icon , null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;

        Bitmap largeIcon = bitmapDrawable.getBitmap();

        // 1- step is to create the object of the notification manager
        // 2- Also need to Type Past because return Type is hte NotificationManage
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        // 3- create Notification  object

        // 5- add version condition
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
             notification = new Notification.Builder(this).
                    setLargeIcon(largeIcon).
                    setSmallIcon(R.drawable.logo).
                    setContentText("Expo Tech Solution ").
                    setSubText("You Are Hire As Web Developer").
                    setChannelId(CHANNEL_ID).build();

            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "Notification Channel",
                    NotificationManager.IMPORTANCE_HIGH));

        }
        else
        {
             notification = new Notification.Builder(this).
                    setLargeIcon(largeIcon).
                    setSmallIcon(R.drawable.logo).
                    setContentText("Expo Tech Solution ").
                    setSubText("You Are Hire As Web Developer")
                    .build();
        }

        notificationManager.notify(NOTIFICATION_ID, notification);

    }
}