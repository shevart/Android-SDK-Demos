package com.shevart.androidcorelearn.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.shevart.androidcorelearn.utils.UtilKt.checkNonNullOrEmpty;


public class AssetsUtil {
    public static String stringFromAssetsFile(@NonNull Context context, @NonNull String fileName) throws IOException {
        checkNonNullOrEmpty(fileName);
        StringBuilder resultBuilder = new StringBuilder();
        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName), "UTF-8"));

            String line;
            while ((line = bReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            return resultBuilder.toString();
        } finally {
            if (bReader != null)
                bReader.close();
        }
    }
}