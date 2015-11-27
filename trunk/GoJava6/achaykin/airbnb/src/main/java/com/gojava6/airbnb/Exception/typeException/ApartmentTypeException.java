package com.gojava6.airbnb.Exception.typeException;

/**
 * @Autor Andrey Chaykin
 * @Since 18.11.15
 */
public class ApartmentTypeException extends Exception {

    public ApartmentTypeException(String msg) {
        super(msg);
    }

    public ApartmentTypeException(String msg, Throwable e) {
        super(msg, e);
    }
}
