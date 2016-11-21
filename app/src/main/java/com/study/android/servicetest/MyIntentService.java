package com.study.android.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2016/11/21.
 */

public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d("MyIntentService","Thread id is " + Thread.currentThread().getId());

    }

    @Override
    public void onDestroy() {
        Log.d("MyIntentService","OnDestroy executed");
        super.onDestroy();
    }
}
