package com.shevart.androidcorelearn.multi_threading.simple_threads;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.common.DemoStartable;
import com.shevart.androidcorelearn.utils.LogUtil;

/***
 * <h3>Developer note</h3>
 * This class is sample of Java thread stopping.
 *
 * The {@link WorkerThread} run while {@link WorkerStopperThread} doesn't stop it. We can't stop
 * threads directly - so there is one way for stop thread: call interrupt() method of this thread.
 */
@SuppressWarnings("FieldCanBeLocal")
class StopThreadSimpleDemo implements DemoStartable {
    private WorkerThread workerThread;
    private WorkerStopperThread workerStopperThread;

    @Override
    public void startDemo() {
        workerThread = new WorkerThread();
        workerStopperThread = new WorkerStopperThread(workerThread);
        workerThread.start();
        workerStopperThread.start();
    }

    private static class WorkerThread extends Thread {
        @Override
        public void run() {
            LogUtil.INSTANCE.e("WorkerThread - go to work!");
            while (true) {
                if (isInterrupted())
                    break;

                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            LogUtil.INSTANCE.e("WorkerThread - go from work!");
        }
    }

    private static class WorkerStopperThread extends Thread {
        private Thread threadWhichIMustStop;

        WorkerStopperThread(@NonNull Thread thread) {
            threadWhichIMustStop = thread;
        }

        @Override
        public void run() {
            try {
                sleep(2000);
                LogUtil.INSTANCE.e("-- stop WorkerThread");
                threadWhichIMustStop.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
                LogUtil.INSTANCE.e("-- unexpected stop WorkerThread");
                threadWhichIMustStop.interrupt();
            }
        }
    }
}