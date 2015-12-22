package com.gojava6.decorator.accomodation;

import com.gojava6.decorator.BasicRent;
import com.gojava6.decorator.HousingType;

public class SharedRoom extends HousingType {

    public SharedRoom(BasicRent basicRentPrice) {
        super(basicRentPrice);
    }

    @Override
    public int price() {
        return super.price() + 70;
    }
}
