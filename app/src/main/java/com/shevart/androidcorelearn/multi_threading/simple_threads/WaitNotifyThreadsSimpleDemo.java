package com.shevart.androidcorelearn.multi_threading.simple_threads;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.common.DemoStartable;
import com.shevart.androidcorelearn.utils.LogUtil;

/***
 * <h3>Developer comment</h3>
 * This class show how Java object monitor works and how threads can change their states.
 *
 * After calling startDemo() methods we create 2 threads {@link FirstThread} and {@link SecondThread}
 * which demonstrate wait() and notify() methods behaviour.
 *
 * {@link FirstThread} must to come in synchronized block before then {@link SecondThread} and call wait() in monitor.
 * Then {@link SecondThread} go to monitor and call notify().
 *
 * We can see in logs states of our threads and order of threads work.
 */
class WaitNotifyThreadsSimpleDemo implements DemoStartable {
    private FirstThread firstThread;
    private SecondThread secondThread;

    @Override
    public void startDemo() {
        firstThread = new FirstThread(this);
        secondThread = new SecondThread(this);

        // print threads state
        LogUtil.INSTANCE.e("-- before threads start()");
        printThreadsStates();

        // start threads
        firstThread.start();
        secondThread.start();

        // print threads state
        LogUtil.INSTANCE.e("-- after threads start()");
        printThreadsStates();
        LogUtil.INSTANCE.empty();
    }

    private void printThreadsStates() {
        LogUtil.INSTANCE.e("-- THREAD STATUS -- firstThread.status() - " + firstThread.getState().toString());
        LogUtil.INSTANCE.e("-- THREAD STATUS -- secondThread.status() - " + secondThread.getState().toString());
    }

    private synchronized void demoSyncMethod() throws InterruptedException {
        if (isFirstThread()) {
            LogUtil.INSTANCE.e("First thread - before wait()");
            printThreadsStates();
            wait();
            LogUtil.INSTANCE.e("First thread - after wait()");
            Thread.sleep(500);
            printThreadsStates();
        } else {
            LogUtil.INSTANCE.e("Second thread - before notify()");
            printThreadsStates();
            notify();
            LogUtil.INSTANCE.e("Second thread - after notify()");
            Thread.sleep(500);
            LogUtil.INSTANCE.e("Second thread - after sleep()");
        }
    }

    private boolean isFirstThread() {
        return Thread.currentThread().getName().equals(FirstThread.class.getSimpleName());
    }

    private static class FirstThread extends Thread {
        private WaitNotifyThreadsSimpleDemo simpleDemo;

        FirstThread(@NonNull WaitNotifyThreadsSimpleDemo simpleDemo) {
            this.simpleDemo = simpleDemo;
            setName(FirstThread.class.getSimpleName());
        }

        @Override
        public void run() {
            try {
                simpleDemo.demoSyncMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class SecondThread extends Thread {
        private WaitNotifyThreadsSimpleDemo simpleDemo;

        SecondThread(@NonNull WaitNotifyThreadsSimpleDemo simpleDemo) {
            this.simpleDemo = simpleDemo;
            setName(SecondThread.class.getSimpleName());
        }

        @Override
        public void run() {
            try {
                sleep(500);
                simpleDemo.demoSyncMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
