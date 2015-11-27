package ua.com.goit.gojava7.salivon.handlers;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import ua.com.goit.gojava7.salivon.dao.DataType;
import ua.com.goit.gojava7.salivon.state.State;

public class ErrorHandlerStateCategoryTest {

    @Before
    public void setUp() {
        State.setIdProject(1);
        State.setIdCategory(1);
    }

    @Test
    public void testValidateForFile() {
        State.setCurrentDataType(DataType.FILE);
        ErrorHandlerStateCategory instance = new ErrorHandlerStateCategory();
        assertEquals(false, instance.validate(""));
        assertEquals(false, instance.validate("0"));
        assertEquals(true, instance.validate("1"));
        assertEquals(false, instance.validate("200"));
    }

    @Test
    public void testValidateForMemory() {
        State.setCurrentDataType(DataType.MEMORY);
        ErrorHandlerStateCategory instance = new ErrorHandlerStateCategory();
        assertEquals(false, instance.validate(""));
        assertEquals(false, instance.validate("0"));
        assertEquals(true, instance.validate("1"));
        assertEquals(false, instance.validate("200"));

    }

    @Test
    @Ignore
    public void testValidateForDb() {
        State.setCurrentDataType(DataType.DB);
        ErrorHandlerStateCategory instance = new ErrorHandlerStateCategory();
        assertEquals(false, instance.validate(""));
        assertEquals(false, instance.validate("0"));
        assertEquals(true, instance.validate("1"));

    }

}
