package com.gojava6.decorator;

public class Location extends BasicRent {

    private BasicRent basicRentPrice;

    public Location(BasicRent basicRentPrice) {
        this.basicRentPrice = basicRentPrice;
    }

    @Override
    public int price() {
        return basicRentPrice.price();
    }
}
