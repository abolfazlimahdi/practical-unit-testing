package com.bitalone.unit_test.chapter3.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahdi on 11/12/18.
 */

public class StringReverse {

    public static String reverse(String s) {
        if (s == null)
            throw new IllegalArgumentException("string argument should not be null");
        if (s.length() == 0)
            return s;

        List<String> tempArray = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            tempArray.add(s.substring(i, i+1));
        }
        StringBuilder reversedString = new StringBuilder(s.length());
        for (int i = tempArray.size() -1; i >= 0; i--) {
            reversedString.append(tempArray.get(i));
        }
        return reversedString.toString();
    }


}
