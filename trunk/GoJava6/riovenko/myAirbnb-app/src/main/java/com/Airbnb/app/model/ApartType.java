package com.Airbnb.app.model;

/**
 * Created by romanroma on 26.09.15.
 */
public enum ApartType {
    ROOM ("ROOM"),
    PLACE ("PLACE"),
    APARTMENT ("APARTMENT");

    public final String text;

    private ApartType (final String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static ApartType getApartType (String type){
        if (type == ROOM.toString())
        {
            return ROOM;
        }
        if (type == APARTMENT.toString()){
            return APARTMENT;
        }
        return PLACE;
    }

}
