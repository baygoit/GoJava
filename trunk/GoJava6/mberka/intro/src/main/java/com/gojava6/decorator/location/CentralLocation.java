package com.gojava6.decorator.location;

import com.gojava6.decorator.BasicRent;
import com.gojava6.decorator.Location;

public class CentralLocation extends Location {

    public CentralLocation(BasicRent basicRentPrice) {
        super(basicRentPrice);
    }

    @Override
    public int price() {
        return super.price() + 40;
    }
}
