package com.bitalone.unit_test.chapter3.exercises;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Created by mahdi on 11/12/18.
 */

@RunWith(JUnitParamsRunner.class)
public class StringReverseTest {

    private static Object[] getStrings() {
        return new Object[] {
                new Object[] {"mahdi"},
                new Object[] {"123"},
                new Object[] {"123321"},
                new Object[] {"12"}
        };
    }

    private static Object[] getNullString() {
        return new Object[] {
                new Object[] {null}
        };
    }

    private static Object[] getEmptyString() {
        return new Object[] {
                new Object[] {""}
        };
    }


    @Test
    @Parameters(method = "getStrings")
    public void testReverseMethod(String string) {
        String reversedString = StringReverse.reverse(string);

        assertEquals(string.charAt(string.length() - 1), reversedString.charAt(0));

        char[] firstChar = string.toCharArray();
        char[] reversedChar = reversedString.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            assertEquals(firstChar[i], reversedChar[string.length() - i - 1]);
        }
    }


    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getNullString")
    public void methodShouldThrowIAEForNullValue(String string) {
        StringReverse.reverse(string);
    }


    @Test
    @Parameters(method = "getEmptyString")
    public void methodShouldHandleEmptyString(String string) {
        String s = StringReverse.reverse(string);
        assertEquals(0, s.length());
    }

}