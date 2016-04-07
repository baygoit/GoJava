package com.sandarovich.kickstarter.dao;


public class DaoException extends RuntimeException {

    private static final long serialVersionUID = 7364451446089457089L;

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
