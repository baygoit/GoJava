package ua.com.goit.gojava7.kickstarter.util;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
public class ValidatorTest{
    Validator validator = new Validator();
    @Ignore
    public void testValidateAmountOfPledge() {
        fail("Not yet implemented");
    }

    @Ignore
    public void testValidatePayer() {
        fail("Not yet implemented");
    }

    @Test
    public void testValidateName() {
        assertThat(validator.validateName("Name Surname"),is(true));
    }

    @Test
    public void testValidateCard() {
        assertThat(validator.validateCard("1234567812345678"),is(true));
    }

   @Ignore
    void testValidateQuestion() {
        fail("Not yet implemented");
    }

}
