package com.shevart.androidcorelearn.different_test_tasks.test_task_1.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class XMLParserUtilTest {
    private static final String TAG = "tag";
    private static final String VALID_INT_VALUE_XML = "<tag>100</tag>";
    private static final String INVALID_INT_VALUE_XML = "<tag>s</tag>";
    private static final String VALID_NO_CONTAIN_ELEMENT_XML = "<foo>content</foo>";
    private static final String INVALID_XML = "<foo/foo>";

    @Test
    public void parseInt_ValidInput() throws Exception {
        int i = XMLParserUtil.parseInt(VALID_INT_VALUE_XML, TAG);
        assertThat(i, is(100));
    }

    @Test(expected = NumberFormatException.class)
    public void parseInt_InvalidInput() throws Exception {
        XMLParserUtil.parseInt(INVALID_INT_VALUE_XML, TAG);
    }

    @Test
    public void isContainsElementByTagName_ValidInput() {
        boolean contain = XMLParserUtil.isContainsElementByTagName(VALID_INT_VALUE_XML, TAG);
        assertThat(contain, is(true));
    }

    @Test
    public void isContainsElementByTagName_ValidInput_NoElement() {
        boolean contain = XMLParserUtil.isContainsElementByTagName(VALID_NO_CONTAIN_ELEMENT_XML, TAG);
        assertThat(contain, is(false));
    }

    @Test
    public void retrieveFirstElementContent_ValidInput() {
        String content = XMLParserUtil.retrieveFirstElementContent(INVALID_INT_VALUE_XML, TAG);
        assertThat(content, is("s"));
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void retrieveFirstElementContent_InvalidInput() {
        XMLParserUtil.retrieveFirstElementContent(INVALID_XML, TAG);
    }

    @Test(expected = IllegalArgumentException.class)
    public void retrieveFirstElementContent_EmptyXMLInput() {
        XMLParserUtil.retrieveFirstElementContent("", TAG);
    }

    @Test(expected = IllegalArgumentException.class)
    public void retrieveFirstElementContent_EmptyTagInput() {
        XMLParserUtil.retrieveFirstElementContent(VALID_INT_VALUE_XML, "");
    }

    @Test
    public void removeFirstIntervalElement_Valid() {
        String result = XMLParserUtil.removeFirstIntervalElement(VALID_INT_VALUE_XML, TAG);
        assertThat(result, is(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFirstIntervalElement_Invalid() {
        XMLParserUtil.removeFirstIntervalElement(INVALID_XML, TAG);
    }

}