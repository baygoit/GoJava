package ua.com.goit.gojava7.salivon.handlers;

import org.junit.Test;
import static org.junit.Assert.*;

public class ErrorHandlerStateProjectTest {

    ErrorHandlerStateProject instance = new ErrorHandlerStateProject();

    @Test
    public void testValidate() {
        assertEquals(false, instance.validate("q"));
        assertEquals(true, instance.validate("1"));
        assertEquals(true, instance.validate("2"));
        assertEquals(true, instance.validate("0"));
        assertEquals(false, instance.validate("3"));
    }

}
