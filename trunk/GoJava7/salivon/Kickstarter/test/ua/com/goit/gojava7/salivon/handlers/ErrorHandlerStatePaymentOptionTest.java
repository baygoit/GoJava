package ua.com.goit.gojava7.salivon.handlers;

import org.junit.Test;
import static org.junit.Assert.*;

public class ErrorHandlerStatePaymentOptionTest {

    ErrorHandlerStatePaymentOption instance = new ErrorHandlerStatePaymentOption();

    /**
     * Test of validate method, of class ErrorHandlerStatePaymentOption.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        assertEquals(true, instance.validate("1"));
        assertEquals(true, instance.validate("2"));
        assertEquals(true, instance.validate("3"));
        assertEquals(true, instance.validate("4"));
        assertEquals(false, instance.validate(""));
        assertEquals(false, instance.validate("0"));
        assertEquals(false, instance.validate("5"));
    }

}
