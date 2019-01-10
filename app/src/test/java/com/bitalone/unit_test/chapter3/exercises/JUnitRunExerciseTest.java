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
public class JUnitRunExerciseTest {

    private static Object[] getObjects() {
        return new Object[] {
                new Object[]{new Long(1), "mahdi", "9155185514"},
                new Object[]{new Long(2), "farah", "9150076978"}

        };
    }


    @Test
    @Parameters(method = "getObjects")
    public void constructorShouldSetFields(Long id, String name, String number) {
        JUnitRunExercise object = new JUnitRunExercise(id, name, number);

        assertEquals(id, object.getId());
        assertEquals(name, object.getName());
        assertEquals(number, object.getNumber());
    }


}