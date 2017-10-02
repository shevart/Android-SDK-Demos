package com.shevart.androidcorelearn.common;

import android.text.TextWatcher;

/***
 *  This class hide two methods which I use seldom. Make code shorter
 */
public abstract class ShortTextWatcher implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
}