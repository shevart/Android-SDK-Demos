package com.shevart.androidcorelearn.multi_threading.handler_looper.handler_background_worker_sample;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.utils.ThreadDemoUtil;

/***
 * <h3>Developer comment</h3>
 * This thread is simple background worker for running long-running operations outside main thread.
 * There are two {@link Handler}'s - one for handling jobs in background thread and one for passing
 * results to main thread.
 */
class WorkerThread extends Thread {
    private static final int SOME_JOB_WHAT = 1;
    private Handler workerHandler;
    private Handler responseHandler;

    WorkerThread(@NonNull Handler responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public void run() {
        // add looper and MessageQueue for this thread
        Looper.prepare();
        //prepare handler for work
        workerHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case SOME_JOB_WHAT:
                        runJob(msg.arg1);
                        break;
                    default:
                        super.handleMessage(msg);
                }
            }
        };
        // start loop
        Looper.loop();
    }

    void runSomeJob(int jobId) {
        final Message message = workerHandler.obtainMessage(SOME_JOB_WHAT, jobId, 0);
        workerHandler.sendMessage(message);
    }

    void stopWork() {
        workerHandler.getLooper().quit();
    }

    // fake long-running operation
    private void runJob(int jobId) {
        ThreadDemoUtil.sleep1000ms();
        onJobComplete(jobId);
    }

    // deliver result back to UI
    private void onJobComplete(int jobId) {
        final Message message = responseHandler.obtainMessage(
                HandlerBackgroundWorkerSampleActivity.ON_JOB_COMPLETE_WHAT, jobId, 0);
        responseHandler.sendMessage(message);
    }
}