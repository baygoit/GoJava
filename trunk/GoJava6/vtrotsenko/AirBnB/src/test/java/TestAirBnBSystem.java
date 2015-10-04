import static com.airbnb.system.Validation.*;
import static org.junit.Assert.*;

import com.airbnb.apartment.Apartment;
import com.airbnb.apartment.ApartmentType;
import com.airbnb.system.AirBnBSystem;
import com.airbnb.user.User;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by root on 04.10.15.
 */
public class TestAirBnBSystem{

    User trueUser;
    AirBnBSystem airBnBSystem;

    @Before
    public void setUp(){
        airBnBSystem = new AirBnBSystem();
        trueUser = new User("Vadim", "Sem", "vadm@gmail.com");
        airBnBSystem.registerUser(trueUser);
    }

    @Test
    public void doit() {
        assertListOfObservers();
    }

    public boolean assertListOfObservers() {
        if (airBnBSystem.getListOfObservers().size() == 1) {
            return true;
        }
        return false;
    }
}