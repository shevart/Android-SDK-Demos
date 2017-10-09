package com.shevart.androidcorelearn.different_test_tasks.test_task_1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.util.IntervalsXMLParser;
import com.shevart.androidcorelearn.utils.AssetsUtil;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class TestTask1Activity extends AppCompatActivity {
    private PrimeNumbersRVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_task1);

        RecyclerView rvPrimeNumbers = (RecyclerView) findViewById(R.id.rvPrimeNumbers);
        rvPrimeNumbers.setLayoutManager(new LinearLayoutManager(this));
        rvPrimeNumbers.setAdapter(adapter);

        findViewById(R.id.btStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLoad();
            }
        });
    }

    private void startLoad() {
        XMLFileReader reader = new XMLFileReader(this, "input.xml");
        reader.start();
    }

    private void onXMLStringRead(@NonNull final String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // TODO: 09.10.17 refactor it - use handler!
                UiNotificationsUtils.showDevMessage(TestTask1Activity.this, result);
                IntervalsXMLParser.parseIntervals(result);
            }
        });

    }

    private static class XMLFileReader extends Thread {
        private WeakReference<TestTask1Activity> weakReference;
        private String fileName;

        XMLFileReader(@NonNull TestTask1Activity activity, @NonNull String fileName) {
            weakReference = new WeakReference<>(activity);
            this.fileName = fileName;
        }

        @Override
        public void run() {
            if (weakReference.get() == null) {
                throw new IllegalArgumentException("We need context for read string from assets!");
            }

            // avoid memory leak - use only app context
            Context appContext = weakReference.get().getApplicationContext();
            try {
                onResult(AssetsUtil.stringFromAssetsFile(appContext, fileName));
            } catch (IOException e) {
                throw new RuntimeException(e); // todo check it
            }
        }

        private void onResult(@NonNull String s) {
            if (weakReference.get() != null) {
                weakReference.get().onXMLStringRead(s);
            }
        }
    }
}