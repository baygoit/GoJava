package com.morkva.model.dao;

/**
 * Created by koros on 09.06.2015.
 */
public class PersistException extends Exception {
    public PersistException(Exception e) {
        super(e);
    }

    public PersistException(String s) {
        super(s);
    }

    public PersistException(String s, Exception e) {
        super(s, e);
    }
}
