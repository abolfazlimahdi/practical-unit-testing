package com.bitalone.unit_test.chapter4.exercises;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

/**
 * Created by mahdi on 11/17/18.
 */

@RunWith(JUnitParamsRunner.class)
public class RegexTest {

    private static Object[] provideStringsToCheckNullReturn() {
        return $("kkjsf23324", " ", "lksjf34", "wke23g4", "djirkdk");
    }

    @Test
    @Parameters(method = "provideStringsToCheckNullReturn")
    public void methodMustNotReturnNull(String password) {

        List<Integer> numbersInString = Regex.extractNumbersFromString(password);

        assertNotNull("numbersInString method must not return null ", numbersInString);
    }

    private static Object[] provideStringsWithNot3Digits() {
        return $("kkjsf24", "d", "lksjf34", "wke23g4", "djirkdk", "mdf23k1", "12 3kdj34 1");
    }

    @Test
    @Parameters(method = "provideStringsWithNot3Digits")
    public void stringWithNo3DigitsMustReturnEmptyList(String password) {

        List<Integer> numbersInString = Regex.extractNumbersFromString(password);

        assertEquals("strings with no 3 digits must return empty list ", numbersInString.size(), 0);
    }

}
