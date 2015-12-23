package com.gojava6.decorator.conviniences;

import com.gojava6.decorator.BasicRent;
import com.gojava6.decorator.Conveniences;

public class WiFi extends Conveniences {

    public WiFi (BasicRent basicRentPrice) {
        super(basicRentPrice);
    }

    @Override
    public int price() {
        return super.price() + 5;
    }
}