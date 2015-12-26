package com.gojava6.decorator.accomodation;

import com.gojava6.decorator.BasicRent;
import com.gojava6.decorator.HousingType;

public class Room extends HousingType {

    public Room(BasicRent basicRent) {
        super(basicRent);
    }

    @Override
    public int price() {
        return super.price() + 100;
    }

}
