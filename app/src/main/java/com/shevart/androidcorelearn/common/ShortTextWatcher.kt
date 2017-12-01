package com.shevart.androidcorelearn.common

import android.text.TextWatcher

/***
 * This class hide two methods which I use seldom. Make code shorter
 */
abstract class ShortTextWatcher : TextWatcher {
    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

    }
}