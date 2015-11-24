package ua.com.goit.gojava7.salivon.handlers;

import org.junit.Test;
import static org.junit.Assert.*;

public class ErrorHandlerStateCreditCardTest {

    ErrorHandlerStateCreditCard instance = new ErrorHandlerStateCreditCard();

    @Test
    public void testValidate() {
        assertEquals(true, instance.validate("1"));
        assertEquals(false, instance.validate("qw"));
    }

}
