package com.shevart.androidcorelearn.different_test_tasks.test_task_1.util;

import android.support.annotation.NonNull;

import java.util.Locale;

@SuppressWarnings("WeakerAccess")
public class XMLParserUtil {
    private static final String START_TAG_PATTERN = "<%s>";
    private static final String END_TAG_PATTERN = "</%s>";

    public static boolean isContainsElementByTagNameInXML(@NonNull String xml, @NonNull String elementName) {
        return xml.contains(prepareStartTag(elementName))
                && xml.contains(prepareEndTag(elementName));
    }

    public static String removeFirstIntervalElementFromXML(@NonNull String s, @NonNull String element) {
        String endTag = prepareEndTag(element);
        return s.substring(s.indexOf(endTag) + element.length());
    }

    public static String retrieveFirstElementContentFromXML(@NonNull String xml,
                                                            @NonNull String elementName) {
        String startTag = prepareStartTag(elementName);
        return xml.substring(xml.indexOf(startTag) + startTag.length(),
                xml.indexOf(prepareEndTag(elementName)));
    }

    public static int parseInt(@NonNull String xml, @NonNull String elementName) {
        String elementContent = retrieveFirstElementContentFromXML(xml, elementName);
        return Integer.valueOf(elementContent);
    }

    private static String prepareStartTag(@NonNull String tag) {
        return String.format(Locale.ENGLISH, START_TAG_PATTERN, tag);
    }

    private static String prepareEndTag(@NonNull String tag) {
        return String.format(Locale.ENGLISH, END_TAG_PATTERN, tag);
    }
}
