package com.shevart.androidcorelearn.utils;

@SuppressWarnings("WeakerAccess")
public class Util {
    public static void checkNonNullOrEmpty(String s) {
        if (isNullOrEmpty(s))
            throw new IllegalArgumentException("The string must be non-null!");
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
