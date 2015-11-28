package com.gojava6.airbnb.Exception.daoexception;

/**
 * @Autor Andrey Chaykin
 * @Since 16.11.2015
 */
public class MySqlUserDaoException extends RuntimeException {

    public MySqlUserDaoException(String message) {
        super(message);
    }

    public MySqlUserDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
