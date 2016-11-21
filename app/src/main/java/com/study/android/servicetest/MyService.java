package com.study.android.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/11/21.
 */

public class MyService extends Service {
    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder {

        public void startDownload() {
            Log.d("MyService","startDownload executed");
        }

        public int getProgress() {
            Log.d("MyService","getProgress executed");
            return 0;
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        Log.d("MyService","onCreate executed");
        super.onCreate();
        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivities(this,0, new Intent[]{notificationIntent},0);

        Notification notification = new Notification.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("This is title")
                .setContentText("This is content")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.th)
                .setWhen(System.currentTimeMillis())
                .build();
        startForeground(1,notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                stopSelf();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("MyService","OnDestroy executed");
        super.onDestroy();
    }
}
