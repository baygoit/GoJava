package ua.com.goit.gojava7.salivon.handlers;

import org.junit.Test;
import static org.junit.Assert.*;

public class ErrorHandlerStateNameInvestTest {

    ErrorHandlerStateNameInvest instance = new ErrorHandlerStateNameInvest();

    /**
     * Test of validate method, of class ErrorHandlerStateNameInvest.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        assertEquals(true, instance.validate(""));
        
    }

}
