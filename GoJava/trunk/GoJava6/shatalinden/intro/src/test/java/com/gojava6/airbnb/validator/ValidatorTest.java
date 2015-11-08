package com.gojava6.airbnb.validator;

import com.gojava6.airbnb.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {
    User user, user1, user2, user3;

    @Before
    public void setUp() {
        user = new User("Denis", "Shatalin", "shatalinden@gmail.com", 0, 0, "password");
        user1 = new User("Kolya15,42", "Shatalin", "shatalinden@gmail.com",  0, 0, "password1");
        user2 = new User("Denis", "Shatalin152", "shatalinden@gmail.com",  0, 0, "password2");
        user3 = new User("Denis", "Shatalin", "shatalindengmail.com",  0, 0, "password3");

    }

    @Test
    public void testValidation() { assertTrue(Validator.validation(user)); }

    @Test
    public void testValidationTwo() { assertFalse(Validator.validation(user1)); }

    @Test
    public void testValidationThree() { assertFalse(Validator.validation(user2)); }

    @Test
    public void testValidationFour() { assertFalse(Validator.validation(user3)); }

}