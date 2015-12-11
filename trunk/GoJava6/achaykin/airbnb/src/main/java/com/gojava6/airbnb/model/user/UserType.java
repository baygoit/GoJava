package com.gojava6.airbnb.model.user;

import com.gojava6.airbnb.Exception.typeException.UserTypeException;
import org.omg.CORBA.UserException;

/**
 * @Autor Andrey Chaykin
 * @Since 05.12.2015
 */
public enum UserType {

    RENTER("RENTER"), HOST("HOST");

    private String type;

    UserType(String type) {
        this.type = type;
    }

    public static UserType fromValue(String type) throws UserTypeException {
        if(type != null) {
            for(UserType userType : values()) {
                if(userType.type.equals(type)) {
                    return userType;
                }
            }
        }
        throw new UserTypeException("Invalid user type");
    }
}
