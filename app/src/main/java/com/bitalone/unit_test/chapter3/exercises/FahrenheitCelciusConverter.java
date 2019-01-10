package com.bitalone.unit_test.chapter3.exercises;

/**
 * Created by mahdi on 11/13/18.
 */

public class FahrenheitCelciusConverter {

    static int toFahrenheit(int celcius) {

        return (celcius * 9 / 5) + 32;
    }

    static int toCelcius(int fahrenheit) {

        return (fahrenheit -32) * 5 / 9;
    }
}
