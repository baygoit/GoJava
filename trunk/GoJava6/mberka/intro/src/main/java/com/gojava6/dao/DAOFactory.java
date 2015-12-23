package com.gojava6.dao;

public class DAOFactory {
    public static UserDAO getUserDAO() {
        return new UserDAO();
    }

}
