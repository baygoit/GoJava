package ua.com.goit.gojava7.salivon.handlers;

import org.junit.Test;
import static org.junit.Assert.*;

public class ErrorHandlerStatePreloadingTest {

    @Test
    public void testValidate() {
        ErrorHandlerStatePreloading instance = new ErrorHandlerStatePreloading();
        assertEquals(false, instance.validate(""));
        assertEquals(true, instance.validate("3"));
        assertEquals(true, instance.validate("1"));
        assertEquals(true, instance.validate("2"));
        assertEquals(false, instance.validate("4"));

    }

}
