package com.shevart.androidcorelearn.service.service_not_sticky;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.NonNull;

public class BinderService extends Service {
    private MyBinder myBinder = new MyBinder(this);

    public BinderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public static class MyBinder extends Binder {
        private BinderService binderService;

        MyBinder(@NonNull BinderService binderService) {
            this.binderService = binderService;
        }

        public BinderService getBinderService() {
            return binderService;
        }
    }
}
