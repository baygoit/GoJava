/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.junit.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 11/6/15
 */
public class MyMapDecoder implements MapDecoder {

    public static final String EQUALITY = "=";
    public static final String SEPARATOR = "&";
    public static final String EMPTY_STRING = "";

    @Override
    public Map<String, String> decode(String s) {
        if (s == null) {
            return null;
        }

        Map<String, String> result = new HashMap<>();

        if (!s.isEmpty()) {
            String[] pairs = s.split(SEPARATOR);
            for (String pair : pairs) {
                String[] keyvalue = pair.split(EQUALITY);

                if (pair.startsWith("=")) {
                    result.put("", keyvalue[0]);
                } else if (pair.endsWith("=")) {
                    result.put(keyvalue[0], EMPTY_STRING);
                } else {
                    result.put(keyvalue[0], keyvalue[1]);
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        MapDecoder decoder = new MyMapDecoder();
        Map<String, String> result = decoder.decode("one=1&two=2");

        Map expected = new HashMap<>();
        expected.put("one", "1");
        expected.put("two", "2");
        copmareAndPrintResult(expected, result);

        result = decoder.decode("=1&two=");

        expected = new HashMap<>();
        expected.put("", "1");
        expected.put("two", "");
        copmareAndPrintResult(expected, result);


    }

    private static void copmareAndPrintResult(Map expected, Map actual) {
        System.out.println((expected.equals(actual)) + " " + expected + " " + actual);
    }
}