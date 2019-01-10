package com.bitalone.unit_test.chapter3.exercises;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Created by mahdi on 11/13/18.
 */

@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelciusConverterTest {

    private static Object[] createCelciusToFahrenheitDegreeForTest() {
        return new Object[] {
                new Object[] {0, 32},
                new Object[] {37, 98},
                new Object[] {100, 212}
        };
    }


    private static Object[] createFahrenheitToCelciusDegreeForTest() {
        return new Object[] {
                new Object[] {32, 0},
                new Object[] {100, 37},
                new Object[] {212, 100}
        };
    }


    @Test
    @Parameters(method = "createCelciusToFahrenheitDegreeForTest")
    public void shouldConvertCelciusToFahrenheit(int celcius, int fahrenheit) {
        assertEquals(fahrenheit, FahrenheitCelciusConverter.toFahrenheit(celcius));
    }


    @Test
    @Parameters(method = "createFahrenheitToCelciusDegreeForTest")
    public void shouldConvertFahrenheitToCelcius(int fahrenheit, int celcius) {
        assertEquals(celcius, FahrenheitCelciusConverter.toCelcius(fahrenheit));
    }

}