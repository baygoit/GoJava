package ua.com.goit.gojava7.salivon.handlers;

import org.junit.Test;
import static org.junit.Assert.*;

public class ErrorHandlerStateQuestionTest {

    ErrorHandlerStateQuestion instance = new ErrorHandlerStateQuestion();

    @Test
    public void testValidate() {
        System.out.println("validate");
        assertEquals(true, instance.validate(""));
    }

}
