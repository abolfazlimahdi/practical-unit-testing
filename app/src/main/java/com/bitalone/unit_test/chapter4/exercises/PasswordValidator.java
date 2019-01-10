package com.bitalone.unit_test.chapter4.exercises;

/**
 * Created by mahdi on 11/15/18.
 */

public class PasswordValidator {


    public static boolean validatePassword(String password) {
        if (password.length() < 8)
            throw new IllegalArgumentException("password must be at least 8 characters long");

        int numOfDigits = 0;
        for (char ch: password.toCharArray()) {
            if (Character.isDigit(ch))
                numOfDigits++;
        }
        if (numOfDigits < 2)
            throw new IllegalArgumentException("password must contain at least 2 digits");

        boolean containsUndreScore = false;
        for (char ch: password.toCharArray()) {
            if (ch == '_')
                containsUndreScore = true;
        }
        if (!containsUndreScore)
            throw new IllegalArgumentException("password must contain underscore!");

        return true;
    }
}
