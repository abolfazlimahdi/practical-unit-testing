package com.bitalone.unit_test.chapter3.exercises;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Created by mahdi on 11/13/18.
 */

@RunWith(JUnitParamsRunner.class)
public class HashMapPropertiesTest {

    private static Object[] someObjectsToPutInHashMap() {
        return new Object[]{
                new Object[] {0, "mahdi"},
                new Object[] {1, "farahnaz"},
                new Object[] {2, "saman"}
        } ;
    }


    private static Object[] getObjectsWithSameKey() {
        return new Object[] {
                new Object[] {0, "mahdi"},
                new Object[] {0, "farahnaz"}
        };
    }

    @Test
    @Parameters(method = "someObjectsToPutInHashMap")
    public void testObjectStoredWithPutRetrievedWithGet(Integer key, String value) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(key, value);

        String getObject = hashMap.get(key);

        assertEquals(value, getObject);
    }


    @Test
    @Parameters(method = "getObjectsWithSameKey")
    public void addObjectsWithSameKeyOverridesPrevious(Integer key, String value) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(key, value);

        String getObject = hashMap.get(key);
        assertEquals(value, getObject);
    }


    @Test
    public void clearMethodShouldRemoveAllContents() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(0, "mahdi");
        hashMap.put(1, "farahnaz");

        assertEquals(2, hashMap.size());

        hashMap.clear();
        assertEquals(0, hashMap.size());
    }


    @Test
    public void nullValueCanBeUsedAsKey(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(null, "mahdi");
        assertEquals("mahdi", hashMap.get(null));
    }

}
