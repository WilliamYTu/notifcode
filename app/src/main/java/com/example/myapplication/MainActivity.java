package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button notifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notifyBtn = findViewById(R.id.notify_btn);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification", "Personal Usage and Savings", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        notifyBtn.setOnClickListener(new View.OnClickListener()    {
           @Override
           public void onClick(View v) {
               //notification code goes here

               NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My Notification");
               builder.setContentTitle("Your Predicted Savings this month");
               builder.setContentText("Click Here to see your predicted savings and personal usage this month");
               builder.setSmallIcon(R.drawable.ic_launcher_background);
               builder.setAutoCancel(true);

               NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
               managerCompat.notify(1,builder.build());
           }
        });
    }
}