package ua.com.goit.gojava7.salivon.handlers;

import org.junit.Test;
import static org.junit.Assert.*;

public class ErrorHandlerStateContributionAmountTest {

    ErrorHandlerStateContributionAmount instance = new ErrorHandlerStateContributionAmount();

    @Test
    public void testValidate() {
        System.out.println("validate");
        assertEquals(true, instance.validate("1"));
        assertEquals(false, instance.validate("1df"));
    }

}
