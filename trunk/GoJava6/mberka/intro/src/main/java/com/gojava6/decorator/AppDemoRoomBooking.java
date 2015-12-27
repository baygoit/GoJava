package com.gojava6.decorator;

import com.gojava6.decorator.accomodation.SharedRoom;
import com.gojava6.decorator.conviniences.PetsAllowed;
import com.gojava6.decorator.conviniences.Pool;
import com.gojava6.decorator.conviniences.WiFi;
import com.gojava6.decorator.location.CentralLocation;
import com.gojava6.decorator.location.NearSubway;

public class AppDemoRoomBooking {

    public static void main(String[] args) {

        BasicRent basicRentPrice = new BasicRent();

        basicRentPrice = new Location(new CentralLocation(basicRentPrice));
        System.out.println(basicRentPrice.price());

        basicRentPrice = new Location(new NearSubway(basicRentPrice));
        System.out.println(basicRentPrice.price());

        basicRentPrice = new Pool(new WiFi(new PetsAllowed(basicRentPrice)));

        System.out.println(basicRentPrice.price());

        basicRentPrice = new SharedRoom(basicRentPrice);
        System.out.println(basicRentPrice.price());


    }

}
