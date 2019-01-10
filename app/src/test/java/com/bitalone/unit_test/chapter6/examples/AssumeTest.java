package com.bitalone.unit_test.chapter6.examples;


import org.junit.Test;

import static org.junit.Assume.assumeTrue;

public class AssumeTest {


    @Test
    public void shouldRunOnlyOnWindows() {
        assumeTrue(thisIsAWindowsMachine());
        System.out.println("running on Windows!");
    }

    private boolean thisIsAWindowsMachine() {
        return System.getProperty("os.name").startsWith("windows");
    }

    @Test
    public void shouldRunOnlyOnLinux() {
        assumeTrue(thisIsALinuxMachine());
        System.out.println("running on Linux!");
    }

    private boolean thisIsALinuxMachine() {
        return System.getProperty("os.name").startsWith("Linux");
    }
}
