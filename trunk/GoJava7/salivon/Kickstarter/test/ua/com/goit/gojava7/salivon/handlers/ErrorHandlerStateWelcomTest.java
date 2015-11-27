package ua.com.goit.gojava7.salivon.handlers;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import ua.com.goit.gojava7.salivon.dao.DataType;
import ua.com.goit.gojava7.salivon.state.State;

public class ErrorHandlerStateWelcomTest {

    ErrorHandlerStateWelcom instance;

    @Before
    public void setUp() {
        State.setIdProject(1);
        State.setIdCategory(1);

    }

    @Test
    public void testValidate() {
        State.setCurrentDataType(DataType.FILE);
        instance = new ErrorHandlerStateWelcom();
        assertEquals(false, instance.validate(""));
        assertEquals(true, instance.validate("1"));
        assertEquals(false, instance.validate("200"));
        assertEquals(true, instance.validate("2"));
        assertEquals(false, instance.validate("0"));
    }

}
