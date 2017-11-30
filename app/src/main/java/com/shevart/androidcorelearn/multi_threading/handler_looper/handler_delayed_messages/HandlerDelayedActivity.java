package com.shevart.androidcorelearn.multi_threading.handler_looper.handler_delayed_messages;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

import java.util.Locale;

public class HandlerDelayedActivity extends AbsActivity {
    private static final int PRINT_DELAYED_MESSAGE_WHAT = 1;
    private static final String DELAY_TIME_PATTERN = "%d sec";

    private Handler uiHandler;

    private EditText etDelayedMsg;
    private SeekBar sbDelayTime;
    private TextView tvCurrentDelayInSecs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_delayed);
        enableToolbarBackButton();
        initViews();

        uiHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == PRINT_DELAYED_MESSAGE_WHAT) {
                    printDelayedMessage((String) msg.obj);
                } else {
                    super.handleMessage(msg);
                }
            }
        };
    }

    private void initViews() {
        findViewById(R.id.btSendMessageWithDelay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDelayedMessage();
            }
        });
        tvCurrentDelayInSecs = (TextView) findViewById(R.id.tvCurrentDelayInSecs);
        etDelayedMsg = (EditText) findViewById(R.id.etDelayedMsg);
        sbDelayTime = (SeekBar) findViewById(R.id.sbDelayInSeconds);
        sbDelayTime.setMax(5); // 5 sec is max value
        sbDelayTime.setProgress(2);
        sbDelayTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvCurrentDelayInSecs.setText(String.format(Locale.ENGLISH, DELAY_TIME_PATTERN, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void sendDelayedMessage() {
        final Message message = uiHandler.obtainMessage(PRINT_DELAYED_MESSAGE_WHAT, etDelayedMsg.getText().toString());
        uiHandler.sendMessageDelayed(message, sbDelayTime.getProgress() * 1000);
    }

    private void printDelayedMessage(@NonNull String msg) {
        UiNotificationsUtils.showToast(this, msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        uiHandler.removeCallbacksAndMessages(null); // remove all messages in queue
    }
}