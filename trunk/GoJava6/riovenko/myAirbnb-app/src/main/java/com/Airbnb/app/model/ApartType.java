package com.Airbnb.app.model;

/**
 * Created by romanroma on 26.09.15.
 */
public enum  ApartType {
    PLACE, ROOM, APARTMENT;

    public int getId (ApartType apartType){
        if (apartType == PLACE){
            return 1;
        }
        else if (apartType == ROOM){
            return 2;
        }
        else {
            return 3;
        }
    }
}
