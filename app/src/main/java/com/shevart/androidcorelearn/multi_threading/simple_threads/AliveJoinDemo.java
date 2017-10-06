package com.shevart.androidcorelearn.multi_threading.simple_threads;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.common.DemoStartable;
import com.shevart.androidcorelearn.utils.LogUtil;
import com.shevart.androidcorelearn.utils.ThreadDemoUtil;

/***
 * <h3>Developer comment</h3>
 * This class demonstrate work with {@link Thread}<b>.isAlive()</b> and {@link Thread}<b>.join()</b> .
 *
 * The {@link ThreadA} is long-running thread and the {@link ThreadB} waiting for finish {@link ThreadA} and the finish work too.
 */
class AliveJoinDemo implements DemoStartable {
    @Override
    public void startDemo() {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB(threadA);

        threadA.start();
        threadB.start();
    }

    private static class ThreadA extends Thread {
        @Override
        public void run() {
            ThreadDemoUtil.sleep2000ms();
        }
    }

    private static class ThreadB extends Thread {
        private Thread thread;

        ThreadB(@NonNull Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            ThreadDemoUtil.sleep500ms();
            LogUtil.e("ThreadB - check isAlive()");
            if (thread.isAlive()) {
                LogUtil.e("ThreadB - isAlive() = true");
                try {
                    LogUtil.e("ThreadB - waiting for another Thread finish work");
                    thread.join();
                    LogUtil.e("ThreadB - another thread is finished");
                    LogUtil.e("ThreadB - another thread.state() - " + thread.getState().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}