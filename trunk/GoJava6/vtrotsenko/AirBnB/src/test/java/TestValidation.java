import static com.airbnb.system.Validation.*;
import static org.junit.Assert.*;

import com.airbnb.apartment.Apartment;
import com.airbnb.apartment.ApartmentType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by root on 04.10.15.
 */
public class TestValidation {

    String trueName;
    String falseName1;
    String falseName2;

    String trueEmail;
    String falseEmail;

    ApartmentType apartmentType;

    LocalDate trueStart;
    LocalDate trueEnd;
    LocalDate falseStart;
    LocalDate falseEnd;

    Apartment apartment;

    @Before
    public void setUp(){
        trueName = "Daniel";
        falseName1 = null;
        falseName2 = "234A";

        trueEmail = "vtrotsenko@gmail.com";
        falseEmail = "vgtei@ru";

        apartmentType = ApartmentType.ROOM;

        trueStart = LocalDate.of(2015, 10, 10);
        trueEnd = LocalDate.of(2015, 10, 11);
        falseStart = LocalDate.of(2015, 3, 10);
        falseEnd = LocalDate.of(2015, 2, 10);

        apartment = new Apartment(ApartmentType.APARTMENT, LocalDate.of(2015, 10, 10), LocalDate.of(2015, 10, 12));

    }

    @Test
    public void doit(){

        assertTrue(isValidName(trueName));
        assertFalse(isValidName(falseName1));
        assertFalse(isValidName(falseName2));

        assertTrue(isValidEmail(trueEmail));
        assertFalse(isValidEmail(falseEmail));

        assertTrue(isValidApartmentType(apartmentType));

        assertTrue(isValidDate(trueStart, trueEnd));
        assertFalse(isValidDate(falseStart, falseEnd));

        assertTrue(isValidReservationDate(apartment, trueStart, trueEnd));
        assertFalse(isValidReservationDate(apartment, falseStart, trueEnd));
    }
}