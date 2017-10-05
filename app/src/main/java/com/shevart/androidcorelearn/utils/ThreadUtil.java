package com.shevart.androidcorelearn.utils;

/***
 * <h3>Developer comment</h3>
 * This class make your code shorter, without unnecessary try-catch block for {@link InterruptedException}
 */
public class ThreadUtil {
    public static void sleep500ms() {
        sleep(500);
    }

    public static void sleep1000ms() {
        sleep(1000);
    }

    public static void sleep2000ms() {
        sleep(2000);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
