package com.shevart.androidcorelearn.different_test_tasks.test_task_1.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.PrimeNumber;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core.PrimeNumberSearcher;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.prime_number_search_core.PrimeNumbersCallback;
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

        adapter = new PrimeNumbersRVAdapter(this);
        RecyclerView rvPrimeNumbers = (RecyclerView) findViewById(R.id.rvPrimeNumbers);
        rvPrimeNumbers.setLayoutManager(new LinearLayoutManager(this));
        rvPrimeNumbers.setAdapter(adapter);

        uiHandler = new UiHandler(this);
        startLoad();
    }

    private void startLoad() {
        XMLFileReader reader = new XMLFileReader(getApplicationContext(), "input.xml", uiHandler);
        reader.start();
    }

    @MainThread
    @Override
    public void onXMLStringResult(@NonNull final String result) {
        UiNotificationsUtils.showDevMessage(TestTask1Activity.this, result);
        primeNumberSearcher.searchPrimeNumbers(IntervalsXMLParser.parseIntervals(result));
        primeNumberSearcher.setPrimeNumbersCallback(uiHandler);
    }

    @MainThread
    @Override
    public void onXMLStringReadFailure(@NonNull final Exception e) {
        showError(e.getMessage());
    }

    @MainThread
    private void showError(@NonNull String error) {
        UiNotificationsUtils.showEmptyToast(this, error);
    }

    @MainThread
    private void addNewPrimeNumber(@NonNull PrimeNumber primeNumber) {
        adapter.addItem(primeNumber);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        uiHandler.removeCallbacksAndMessages(null);
    }

    @SuppressWarnings("WeakerAccess")
    static class UiHandler extends Handler implements XMLFileReader.XMLStringCallback, PrimeNumbersCallback {
        private WeakReference<TestTask1Activity> weakReference;

        private UiHandler(@NonNull TestTask1Activity activity) {
            weakReference = new WeakReference<>(activity);
        }

        @Override
        public void onXMLStringResult(@NonNull final String result) {
            post(new Runnable() {
                @Override
                public void run() {
                    if (weakReference.get() != null)
                        weakReference.get().onXMLStringResult(result);
                }
            });
        }

        @Override
        public void onXMLStringReadFailure(@NonNull final Exception e) {
            post(new Runnable() {
                @Override
                public void run() {
                    if (weakReference.get() != null)
                        weakReference.get().onXMLStringReadFailure(e);
                }
            });
        }

        @Override
        public void onNewPrimeNumberFound(@NonNull final PrimeNumber primeNumber) {
            post(new Runnable() {
                @Override
                public void run() {
                    if (weakReference.get() != null)
                        weakReference.get().addNewPrimeNumber(primeNumber);
                }
            });
        }
    }
}