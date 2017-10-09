package com.shevart.androidcorelearn.different_test_tasks.test_task_1.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core.PrimeNumberSearcher;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.util.IntervalsXMLParser;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.util.XMLFileReader;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

import java.lang.ref.WeakReference;

public class TestTask1Activity extends AbsActivity implements XMLFileReader.XMLStringCallback {
    private PrimeNumbersRVAdapter adapter;
    private PrimeNumberSearcher primeNumberSearcher = new PrimeNumberSearcher();
    private UiHandler uiHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_task1);
        enableToolbarBackButton();

        RecyclerView rvPrimeNumbers = (RecyclerView) findViewById(R.id.rvPrimeNumbers);
        rvPrimeNumbers.setLayoutManager(new LinearLayoutManager(this));
        rvPrimeNumbers.setAdapter(adapter);

        uiHandler = new UiHandler(this);
        startLoad();
    }

    private void startLoad() {
        XMLFileReader reader = new XMLFileReader(getApplicationContext(), "input.xml", this);
        reader.start();
    }

    @Override
    public void onXMLStringResult(@NonNull final String result) {
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                // TODO: 09.10.17 refactor it
                UiNotificationsUtils.showDevMessage(TestTask1Activity.this, result);
                IntervalsXMLParser.parseIntervals(result);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        uiHandler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onXMLStringReadFailure(@NonNull final Exception e) {
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                // TODO: 09.10.17 refactor it
                UiNotificationsUtils.showEmptyToast(TestTask1Activity.this, e.getMessage());
            }
        });
    }

    @SuppressWarnings("WeakerAccess")
    static class UiHandler extends Handler {
        private WeakReference<TestTask1Activity> weakReference;

        private UiHandler(@NonNull TestTask1Activity activity) {
            weakReference = new WeakReference<>(activity);
        }
    }
}