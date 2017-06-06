package com.shevart.androidcorelearn.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.service.service_not_sticky.BinderService;
import com.shevart.androidcorelearn.utils.LogUtil;

public class BinderServiceActivity extends AppCompatActivity {
    private BinderService.MyBinder myBinder;

    private ServiceConnection myConnection;

    private RadioButton rbBounded;
    private RadioButton rbUnbounded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder_service);
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
    }

    private void bindToService() {
        LogUtil.e("bindService()");
        myConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myBinder = (BinderService.MyBinder) service;
                onConnected();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                LogUtil.e("onServiceDisconnected() ");
                LogUtil.e(name.getClassName());
                myBinder = null;
                onDisconnected();
            }
        };

        bindService(new Intent(this, BinderService.class), myConnection, Context.BIND_AUTO_CREATE);
    }

    private void unbindFromService() {
        LogUtil.e("unbindFromService()");
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
        LogUtil.e("onConnected()");
        rbBounded.setChecked(true);
    }

    private void onDisconnected() {
        LogUtil.e("onDisconnected()");
        rbUnbounded.setChecked(true);
        myConnection = null;
    }
}
