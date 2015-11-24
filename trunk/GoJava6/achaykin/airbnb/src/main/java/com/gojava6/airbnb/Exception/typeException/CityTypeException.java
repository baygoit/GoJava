package com.gojava6.airbnb.Exception.typeException;

/**
 * @Autor Andrey Chaykin
 * @Since 18.11.15
 */
public class CityTypeException extends Exception {

    public CityTypeException(String msg) {
        super(msg);
    }

    public CityTypeException(String msg, Throwable e) {
        super(msg, e);
    }
}
