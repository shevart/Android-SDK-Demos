package com.shevart.androidcorelearn.different_test_tasks.test_task_1.util;

import android.support.annotation.NonNull;

import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.Interval;
import com.shevart.androidcorelearn.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import static com.shevart.androidcorelearn.utils.Util.checkNonNullOrEmpty;

@SuppressWarnings("WeakerAccess")
public class IntervalsXMLParser {
    private static final String LIST_TAG = "intervals";
    private static final String INTERVAL_TAG = "interval";
    private static final String ID_TAG = "id";
    private static final String LOW_TAG = "low";
    private static final String HIGH_TAG = "high";

    public static List<Interval> parseIntervals(@NonNull String s) {
        checkNonNullOrEmpty(s);
        final List<Interval> intervals = new ArrayList<>();

        // no intervals list in XML
        if (!XMLParserUtil.isContainsElementByTagNameInXML(s, LIST_TAG))
            return intervals;

        // retrieve Intervals list XML
        String intervalsListXMLPart = XMLParserUtil.retrieveFirstElementContentFromXML(s, LIST_TAG);
        LogUtil.e(intervalsListXMLPart);

        // while XML list contains Intervals parse it
        while (intervalsListXMLPart.contains(INTERVAL_TAG)) {
            intervals.add(parseIntervalFromXML(retrieveFirstIntervalElementFromXML(intervalsListXMLPart)));
            // remove parsed Interval from list in XML
            intervalsListXMLPart = XMLParserUtil.removeFirstIntervalElementFromXML(intervalsListXMLPart, INTERVAL_TAG);
        }

        return intervals;
    }

    private static String retrieveFirstIntervalElementFromXML(@NonNull String s) {
        return XMLParserUtil.retrieveFirstElementContentFromXML(s, INTERVAL_TAG);
    }

    private static Interval parseIntervalFromXML(@NonNull String xml) {
        Interval interval = new Interval();
        interval.setId(XMLParserUtil.parseInt(xml, ID_TAG));
        interval.setLow(XMLParserUtil.parseInt(xml, LOW_TAG));
        interval.setHigh(XMLParserUtil.parseInt(xml, HIGH_TAG));
        return interval;
    }
}