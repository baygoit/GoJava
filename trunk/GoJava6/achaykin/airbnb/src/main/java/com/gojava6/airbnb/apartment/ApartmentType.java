package com.gojava6.airbnb.apartment;

import com.gojava6.airbnb.Exception.typeException.ApartmentTypeException;

public enum ApartmentType {

    ENTIRE_HOME("ENTIRE_HOME"), ENTIRE_APARTMENT("ENTIRE_APARTMENT"), SHARED_ROOM("SHARED_ROOM"), PRIVATE_ROOM("PRIVATE_ROOM");

    private final String value;

    ApartmentType(String value) {
        this.value = value;
    }

    public static ApartmentType fromValue(String value) throws ApartmentTypeException {
        if(value != null) {
            for (ApartmentType apartmentType : values()) {
                if(apartmentType.value.equals(value)) {
                    return apartmentType;
                }
            }
        }
        throw new ApartmentTypeException ("Invalid apartment type: " + value);
    }
}
