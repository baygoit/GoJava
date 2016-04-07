package com.sandarovich.kickstarter.dao;


public class NoResultException extends DaoException {

    private static final long serialVersionUID = 1590849161969951152L;

    public NoResultException(String message) {
        super(message);
    }

}
