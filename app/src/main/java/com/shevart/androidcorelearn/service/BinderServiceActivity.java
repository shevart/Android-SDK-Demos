package com.shevart.androidcorelearn.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.RadioButton;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.utils.LogUtil;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

public class BinderServiceActivity extends AbsActivity {
    private BinderService.MyBinder myBinder;

    private ServiceConnection myConnection;

    private RadioButton rbBounded;
    private RadioButton rbUnbounded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder_service);
        enableToolbarBackButton();
        rbBounded = (RadioButton) findViewById(R.id.rbBounded);
        rbUnbounded = (RadioButton) findViewById(R.id.rbUnounded);
        rbUnbounded.setChecked(true);

        findViewById(R.id.btBinderServiceBoundUnboud).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myConnection != null) {
                    unbindFromService();
                } else {
                    bindToService();
                }
            }
        });

        findViewById(R.id.btForceDestroyBoundService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myBinder != null)
                    myBinder.getBinderService().forceManualStopService();
            }
        });
    }

    private void bindToService() {
        UiNotificationsUtils.showDevMessage(this, "bindService()");
        myConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myBinder = (BinderService.MyBinder) service;
                onConnected();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                UiNotificationsUtils.showDevMessage(BinderServiceActivity.this, "onServiceDisconnected() ");
                LogUtil.INSTANCE.e(name.getClassName());
                myBinder = null;
                onDisconnected();
            }
        };

        bindService(new Intent(this, BinderService.class), myConnection, Context.BIND_AUTO_CREATE);
    }

    private void unbindFromService() {
        UiNotificationsUtils.showDevMessage(this, "unbindFromService()");
        unbindService(myConnection);
        myBinder = null;
        myConnection = null;
        rbUnbounded.setChecked(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (myConnection != null)
            unbindFromService();
    }

    private void onConnected() {
        UiNotificationsUtils.showDevMessage(this, "onConnected()");
        rbBounded.setChecked(true);
    }

    private void onDisconnected() {
        UiNotificationsUtils.showDevMessage(this, "onDisconnected()");
        rbUnbounded.setChecked(true);
        myConnection = null;
    }
}
