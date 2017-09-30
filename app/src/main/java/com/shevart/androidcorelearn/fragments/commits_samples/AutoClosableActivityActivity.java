package com.shevart.androidcorelearn.fragments.commits_samples;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

// todo temp decision, review it
public class AutoClosableActivityActivity extends AppCompatActivity {
    private static final long DELAY = 1000 * 3; // 3 secs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_closable_activity);

        final Handler handler = new Handler(getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, DELAY);
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        UiNotificationsUtils.showDevMessage(this,
                getString(R.string.wait_few_seconds_this_screen_will_be_automatically_closed));
    }
}