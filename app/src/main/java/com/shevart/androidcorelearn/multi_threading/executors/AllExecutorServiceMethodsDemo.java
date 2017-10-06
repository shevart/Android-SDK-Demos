package com.shevart.androidcorelearn.multi_threading.executors;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.common.DemoStartable;
import com.shevart.androidcorelearn.utils.LogUtil;
import com.shevart.androidcorelearn.utils.ThreadDemoUtil;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/***
 * <h3>Developer comment</h3>
 * In this demo we explore methods from ExecutorService (almost all methods)
 */
class AllExecutorServiceMethodsDemo implements DemoStartable {
    @Override
    public void startDemo() {
        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        executeDemo(executorService);
        submitDemo(executorService);
        submitWithResultDemo(executorService);
        invokeAnyDemo(executorService);
        invokeAllDemo(executorService);
        executorService.shutdown();
    }

    private void executeDemo(@NonNull ExecutorService executorService) {
        Thread.currentThread().setName("executeDemo");
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                LogUtil.e("ExecutorService.execute()");
            }
        });
    }

    private void submitDemo(@NonNull ExecutorService executorService) {
        Thread.currentThread().setName("submitDemo");
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                LogUtil.e("ExecutorService.submit(Runnable)");
            }
        });
        try {
            future.get(); // return null if the execution complete without exceptions
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void submitWithResultDemo(@NonNull ExecutorService executorService) {
        Thread.currentThread().setName("submitWithResultDemo");
        Future<String> futureResult = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                LogUtil.e("ExecutorService.submit(Callable)");
                return "result";
            }
        });
        try {
            LogUtil.e("Result from submit(callable) is " + futureResult.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void invokeAnyDemo(@NonNull ExecutorService executorService) {
        Thread.currentThread().setName("invokeAnyDemo");
        try {
            String result = executorService.invokeAny(ThreadDemoUtil.createTestTasksList(10));
            LogUtil.e("ExecutorService.invokeAny() - result of execution is: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void invokeAllDemo(@NonNull ExecutorService executorService) {
        Thread.currentThread().setName("invokeAllDemo");
        try {
            final List<Future<String>> futureList = executorService.invokeAll(ThreadDemoUtil.createTestTasksList(10));
            for (Future<String> f : futureList) {
                LogUtil.e("Future result is: " + f.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}