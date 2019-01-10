package com.bitalone.unit_test.chapter5.examples.car;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CarTest {

    private Car myFerrari;

    @Before
    public void setup() {
        myFerrari = mock(Car.class);
    }

    //FirstMockitoTest
    @Test
    public void testIfCarIsACar() {
        assertTrue(myFerrari instanceof Car);
    }

    //MockitoDefaultValuesTest
    @Test
    public void testDefaultBehaviourOfTestDouble() {
        assertFalse("new test double should return false as boolean",
                myFerrari.needsFuels());
        assertEquals("new test double should return 0.0 as double",
                0.0, myFerrari.getEngineTemperature(), 0.000001);
    }

    //MockitoReturningDesiredValuesTest
    @Test
    public void testStubbing() {
        assertFalse("new test double should return false as boolean",
                myFerrari.needsFuels());

        when(myFerrari.needsFuels()).thenReturn(true);

        assertTrue("after instructed test double should return what we want",
                myFerrari.needsFuels());
    }

    //MockitoThrowingExceptionsTest
    @Test(expected = RuntimeException.class)
    public void throwException() {
        when(myFerrari.needsFuels()).thenThrow(new RuntimeException());
        myFerrari.needsFuels();
    }

    //MockitoVerificationTest
    @Test
    public void testVerification() {
        myFerrari.driveTo("sweet home alabama");
        myFerrari.needsFuels();

        verify(myFerrari).driveTo("sweet home alabama");
        verify(myFerrari).needsFuels();
    }

    @Test
    public void testVerificationFailure() {
        myFerrari.needsFuels();
        verify(myFerrari).getEngineTemperature();
    }
    
    //MockitoFailedVerificationArgumentsTest
    @Test
    public void testVerificationFailureArguments() {
        myFerrari.driveTo("sweet home Alabama");
        //TODO: uncomment below line
        //verify(myFerrari).driveTo("sweet home Honolulu");
    }
}