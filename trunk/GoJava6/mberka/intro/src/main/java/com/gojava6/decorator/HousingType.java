package com.gojava6.decorator;

public class HousingType extends BasicRent {
    private BasicRent basicRentPrice;

    public HousingType(BasicRent basicRentPrice) {
        this.basicRentPrice = basicRentPrice;
    }

    @Override
    public int price() {
        return basicRentPrice.price();
    }
}
