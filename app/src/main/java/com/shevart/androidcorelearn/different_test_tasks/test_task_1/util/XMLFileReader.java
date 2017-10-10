package com.shevart.androidcorelearn.different_test_tasks.test_task_1.util;

import android.content.Context;
import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.utils.AssetsUtil;
import com.shevart.androidcorelearn.utils.LogUtil;

import java.lang.ref.WeakReference;

public class XMLFileReader extends Thread {
    private WeakReference<XMLStringCallback> weakReference;
    private String fileName;
    private Context context;

    public XMLFileReader(@NonNull Context context,
                         @NonNull String fileName,
                         @NonNull XMLStringCallback callback) {
        this.fileName = fileName;
        this.context = context.getApplicationContext(); // avoid memory leak - use only app context
        weakReference = new WeakReference<>(callback); // avoid memory leak - use weakReference
    }

    @Override
    public void run() {
        try {
            onResult(AssetsUtil.stringFromAssetsFile(context, fileName));
        } catch (Exception e) {
            onFailure(e);
        }
    }

    private void onResult(@NonNull String s) {
        if (weakReference.get() != null) {
            weakReference.get().onXMLStringResult(s);
        }
    }

    private void onFailure(@NonNull Exception e) {
        LogUtil.e(e);
        if (weakReference.get() != null) {
            weakReference.get().onXMLStringReadFailure(e);
        }
    }

    @SuppressWarnings("WeakerAccess")
    public interface XMLStringCallback {
        void onXMLStringResult(@NonNull String result);

        void onXMLStringReadFailure(@NonNull Exception e);
    }
}
