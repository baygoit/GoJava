package com.gojava6.airbnb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Autor Andrey Chaykin
 * @Since 16.11.2015
 */
public class ParseDateUtil {

    private ParseDateUtil() {
    }

    public static Date parseDate(String date) throws IllegalArgumentException {
        try {
            return new SimpleDateFormat("yyyy/mm/dd").parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Cannot parse date", e);
        }
    }
}
