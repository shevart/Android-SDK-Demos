package com.shevart.androidcorelearn.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.utils.LogUtil;

public class BinderService extends Service {
    private MyBinder myBinder = new MyBinder(this);

    public BinderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.e("BinderService: onBind()");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtil.e("BinderService: onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        LogUtil.e("BinderService: onDestroy()");
        super.onDestroy();
    }

    public void forceManualStopService() {
        LogUtil.e("forceManualStopService()");
        stopSelf();
    }

    static class MyBinder extends Binder {
        private BinderService binderService;

        MyBinder(@NonNull BinderService binderService) {
            this.binderService = binderService;
        }

        BinderService getBinderService() {
            return binderService;
        }
    }
}
