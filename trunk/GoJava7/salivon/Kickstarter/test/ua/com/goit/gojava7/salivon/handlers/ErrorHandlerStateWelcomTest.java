package ua.com.goit.gojava7.salivon.handlers;

import org.junit.Test;
import static org.junit.Assert.*;
import ua.com.goit.gojava7.salivon.ManagerFileData;

public class ErrorHandlerStateWelcomTest {

    ErrorHandlerStateWelcom instance = new ErrorHandlerStateWelcom(new ManagerFileData());

    @Test
    public void testValidate() {

        assertEquals(false, instance.validate(""));
        assertEquals(true, instance.validate("1"));
        assertEquals(false, instance.validate("qw"));
        assertEquals(true, instance.validate("2"));
        assertEquals(false, instance.validate("5"));
    }

}
