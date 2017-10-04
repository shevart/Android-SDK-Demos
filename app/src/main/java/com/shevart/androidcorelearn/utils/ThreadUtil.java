package com.shevart.androidcorelearn.utils;

/***
 * <h3>Developer comment</h3>
 * This class make your code shorter, without unnecessary try-catch block for {@link InterruptedException}
 */
public class ThreadUtil {
    public static void sleep500ms() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep2000ms() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
