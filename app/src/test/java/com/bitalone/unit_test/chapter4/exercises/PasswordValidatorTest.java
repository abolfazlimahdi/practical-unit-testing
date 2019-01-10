package com.bitalone.unit_test.chapter4.exercises;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertTrue;

/**
 * Created by mahdi on 11/15/18.
 */

@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {


    private static Object[] providePasswordsWithLessThan8Characters() {
        return $(
                "1234567",
                "d23_ioj",
                "2");
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "providePasswordsWithLessThan8Characters")
    public void passwordMustBe8CharactersLong(String password) {
        PasswordValidator.validatePassword(password);
    }


    private static Object[] providePasswordsWithLessThan2Digits() {
        return $(
                "1abcdefgh",
                "abcdefgh1",
                "abcdefgh");
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "providePasswordsWithLessThan2Digits")
    public void passwordMustContainAtLeast2Digits(String password) {
        PasswordValidator.validatePassword(password);
    }


    private static Object[] providePasswordsWithNoUnderscore() {
        return $(
                "1abcdefghwoeifrjwjfiwof324",
                "abcdefgh1wiefjiwoj234",
                "abcdefghefkjewoifjiowe324324");
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "providePasswordsWithNoUnderscore")
    public void passwordMustContainUnderscore(String password) {
        PasswordValidator.validatePassword(password);
    }


    private static Object[] provideValidPasswords() {
        return $("12abcde_",
                "_abcde12",
                "1abcde_2",
                "0ab2cde_",
                "a1bc_d2e"
                );
    }

    @Test
    @Parameters(method = "provideValidPasswords")
    public void checkValidPasswords(String password) {
        assertTrue("valid passwords are not passed through validatePassword method",
                PasswordValidator.validatePassword(password));
    }
}
