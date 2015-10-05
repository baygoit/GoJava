package com.gojava6.airbnb.reservation;

import com.gojava6.airbnb.apartment.ApartType;
import com.gojava6.airbnb.apartment.Apartment;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by shata on 04.10.2015.
 */
public class ReservationDatesTest {
    ReservationDates reservationDates;
    Apartment apartment;

    @Before
    public void setUp() throws Exception {
        apartment = new Apartment(ApartType.APARTMENT, "Kiev");
        reservationDates = new ReservationDates(new Date(2015, 11, 7), new Date(2015,11,20), apartment);
    }

    @Test
    public void testReservationDatesStart() {
        assertEquals(new Date(2015, 11, 7), reservationDates.start);
    }

    @Test
    public void testReservationDatesEnd() {
        assertEquals(new Date(2015,11,20), reservationDates.end);
    }

    @Test
    public void Apartment() {
        assertEquals(apartment, reservationDates.apartment);
    }
}