package com.shevart.androidcorelearn.arch_components.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;

import com.shevart.androidcorelearn.common.SimpleItem;
import com.shevart.androidcorelearn.utils.LogUtil;
import com.shevart.androidcorelearn.utils.MockUtils;

import java.util.List;

public class MyViewModel extends ViewModel {
    private MutableLiveData<List<SimpleItem>> listLiveData;

    synchronized LiveData<List<SimpleItem>> getListLiveData() {
        if (listLiveData == null) {
            listLiveData = new MutableLiveData<>();
            loadSimpleItemsList();
        }

        return listLiveData;
    }

    private void loadSimpleItemsList() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listLiveData.setValue(MockUtils.SimpleItems.generateSimpleItemsList());
            }
        }, 3000);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        LogUtil.d("onCleared()");
    }
}