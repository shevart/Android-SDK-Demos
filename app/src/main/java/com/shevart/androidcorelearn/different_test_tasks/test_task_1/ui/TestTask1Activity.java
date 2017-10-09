package com.shevart.androidcorelearn.different_test_tasks.test_task_1.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.util.IntervalsXMLParser;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.util.XMLFileReader;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

public class TestTask1Activity extends AbsActivity implements XMLFileReader.XMLStringCallback {
    private PrimeNumbersRVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_task1);
        enableToolbarBackButton();

        RecyclerView rvPrimeNumbers = (RecyclerView) findViewById(R.id.rvPrimeNumbers);
        rvPrimeNumbers.setLayoutManager(new LinearLayoutManager(this));
        rvPrimeNumbers.setAdapter(adapter);

        startLoad();
    }

    private void startLoad() {
        XMLFileReader reader = new XMLFileReader(getApplicationContext(),
                "input.xml", this);
        reader.start();
    }

    @Override
    public void onXMLStringResult(@NonNull final String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // TODO: 09.10.17 refactor it - use handler!
                UiNotificationsUtils.showDevMessage(TestTask1Activity.this, result);
                IntervalsXMLParser.parseIntervals(result);
            }
        });
    }

    @Override
    public void onXMLStringReadFailure(@NonNull Exception e) {
        // TODO: 09.10.17 handle error
        UiNotificationsUtils.showEmptyToast(this, e.getMessage());
    }
}