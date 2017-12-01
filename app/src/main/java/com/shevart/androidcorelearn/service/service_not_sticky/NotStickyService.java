package com.shevart.androidcorelearn.service.service_not_sticky;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.shevart.androidcorelearn.utils.LongRunningOperationsMockUtils;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

public class NotStickyService extends Service {
    public NotStickyService() {
    }

    @Override
    public void onCreate() {
        UiNotificationsUtils.INSTANCE.showDevMessage(this, "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        UiNotificationsUtils.INSTANCE.showDevMessage(this, "onStartCommand()");
        tellAboutFlags(flags);
        UiNotificationsUtils.INSTANCE.showDevMessage(this, "startId: " + startId);
        longRunningTask();
        return START_NOT_STICKY;
    }

    private void tellAboutFlags(int flags) {
        switch (flags) {
            case 0:
                UiNotificationsUtils.INSTANCE.showDevMessage(this, "flags is default value, 0");
                break;
            case START_FLAG_REDELIVERY:
                UiNotificationsUtils.INSTANCE.showDevMessage(this, "flags is START_FLAG_REDELIVERY");
                break;
            case START_FLAG_RETRY:
                UiNotificationsUtils.INSTANCE.showDevMessage(this, "flags is START_FLAG_RETRY");
                break;
            default:
                throw new IllegalArgumentException("Handle it! Flags is " + flags);
        }
    }

    private void longRunningTask() {
        LongRunningOperationsMockUtils.mock_5_seconds_task(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        UiNotificationsUtils.INSTANCE.showDevMessage(this, "onDestroy()");
    }
}
