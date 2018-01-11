package com.shevart.androidcorelearn.utils

fun checkNonNullOrEmpty(s: String) {
    if (isNullOrEmpty(s))
        throw IllegalArgumentException("The string must be non-null!")
}

fun isNullOrEmpty(s: String?): Boolean {
    return s == null || s.isEmpty()
}

