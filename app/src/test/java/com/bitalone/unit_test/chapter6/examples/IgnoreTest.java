package com.bitalone.unit_test.chapter6.examples;

import org.junit.Ignore;
import org.junit.Test;

import junitparams.Parameters;

public class IgnoreTest {
    
    @Test
    public void shouldRun() {
        System.out.println("shouldRun() is running!");
    }

    @Ignore
    @Test
    public void shouldBeIgnored() {
        System.out.println("huh, not ignored?!");
    }
}