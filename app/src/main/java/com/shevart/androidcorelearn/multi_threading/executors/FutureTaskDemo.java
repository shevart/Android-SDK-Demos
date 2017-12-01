package com.shevart.androidcorelearn.multi_threading.executors;

import com.shevart.androidcorelearn.common.DemoStartable;
import com.shevart.androidcorelearn.utils.LogUtil;
import com.shevart.androidcorelearn.utils.ThreadDemoUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class FutureTaskDemo implements DemoStartable {
    @Override
    public void startDemo() {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final FutureTask<String> futureTask = createDemoFutureTask();
        executorService.submit(futureTask);

        String firstAttemptGetResult = "";
        String secondAttempGetResult = "";
        try {
            firstAttemptGetResult = futureTask.get(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            LogUtil.INSTANCE.e("Computation still in progress...");
        }

        LogUtil.INSTANCE.e("firstAttemptGetResult: " + firstAttemptGetResult);

        try {
            secondAttempGetResult = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        LogUtil.INSTANCE.e("secondAttempGetResult: " + secondAttempGetResult);
        executorService.shutdown();
    }

    private FutureTask<String> createDemoFutureTask() {
        return new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                ThreadDemoUtil.INSTANCE.sleep1000ms();
                return "result";
            }
        });
    }
}
