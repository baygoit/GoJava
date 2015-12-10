package com.gojava6.airbnb.Exception.typeException;

/**
 * @Autor Andrey Chaykin
 * @Since 05.12.2015
 */
public class UserTypeException extends Throwable {
    public UserTypeException(String msg) {
        super(msg);
    }

    public UserTypeException(String msg, Throwable e) {
        super(msg, e);
    }
}
