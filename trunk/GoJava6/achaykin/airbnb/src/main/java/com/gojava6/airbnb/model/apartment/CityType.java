package com.gojava6.airbnb.model.apartment;

import com.gojava6.airbnb.Exception.typeException.CityTypeException;

public enum CityType {

    KIEV("KIEV"), LONDON("LONDON"), NEWYORK("NEWYORK"), STOCKHOLM("STOCKHOLM");

    private final String value;

    CityType(String value) {
        this.value = value;
    }

    public static CityType fromValue(String value) throws CityTypeException {
        if(value != null) {
            for (CityType cityType : values()) {
                if(cityType.value.equals(value)) {
                    return cityType;
                }
            }
        }
        throw new CityTypeException("Invalid city type: " + value);
    }
}
