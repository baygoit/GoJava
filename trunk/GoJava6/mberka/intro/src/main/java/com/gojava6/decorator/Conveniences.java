package com.gojava6.decorator;

public class Conveniences extends BasicRent {
    private BasicRent basicRentPrice;

    public Conveniences(BasicRent basicRentPrice) {
        this.basicRentPrice = basicRentPrice;
    }

    @Override
    public int price() {
        return basicRentPrice.price();
    }
}
