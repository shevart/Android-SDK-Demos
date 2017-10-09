package com.shevart.androidcorelearn.different_test_tasks.test_task_1.util;

import java.math.BigInteger;

public class PrimeNumberUtil {
    public static boolean isPrimeNumber(int number) {
        final BigInteger bigInteger = BigInteger.valueOf(number);
        return  bigInteger.isProbablePrime((int) Math.log(number));
    }
}
