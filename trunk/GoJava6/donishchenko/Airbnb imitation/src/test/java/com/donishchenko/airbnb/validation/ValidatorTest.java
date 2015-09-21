<<<<<<< HEAD
package com.donishchenko.airbnb.validation;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {
    @Test
    public void testValidateName() {
        assertFalse("Null name", Validator.validateName(null));
        assertFalse("Empty name", Validator.validateName(""));
        assertFalse("Only letters (numbers)", Validator.validateName("Dmi9try"));
        assertFalse("Only letters (other symbols)", Validator.validateName("Dmit_ry"));
        assertFalse("First letter lower case", Validator.validateName("dmitry"));
        assertFalse("Only first letter need to be in uppercase", Validator.validateName("DmiTry"));
        assertFalse("Second name starts with lowercase", Validator.validateName("Dmitry-vladislav"));
        assertFalse("Too short name (<2)", Validator.validateName("D"));
        assertFalse("Too long name (>40)", Validator.validateName("Mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmq"));
        assertTrue("Double name", Validator.validateName("Dmitry-Vladislav"));
        assertTrue("Triple name (etc)", Validator.validateName("Dmitry-Vladislav-Victoria"));
    }

    @Test
    public void testValidateSurname() {
        assertFalse("Null name", Validator.validateSurname(null));
        assertFalse("Empty name", Validator.validateSurname(""));
        assertFalse("Only letters (numbers)", Validator.validateSurname("Oni9shchenko"));
        assertFalse("Only letters (other symbols)", Validator.validateSurname("Onish_chenko"));
        assertFalse("First letter lower case", Validator.validateSurname("onishchenko"));
        assertFalse("Only first letter need to be in uppercase", Validator.validateSurname("OniShchenKo"));
        assertFalse("Second surname starts with lowercase", Validator.validateSurname("Onishchenko-tipunov"));
        assertFalse("Too short surname (<2)", Validator.validateSurname("D"));
        assertFalse("Too long surname (>40)", Validator.validateSurname("Mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmq"));
        assertTrue("Double surname", Validator.validateSurname("Onishchenko-Tipunov"));
        assertTrue("Triple surname (etc)", Validator.validateSurname("Onishchenko-Tipunov-Grachovski"));
    }

    @Test
    public void testValidateEmail() {
        assertFalse("Null email", Validator.validateEmail(null));
        assertFalse("Empty email", Validator.validateEmail(""));
        assertFalse("Uppercase letters", Validator.validateEmail("sAcR8TuM@gmail.com"));
        assertFalse("Two hyphens (--)", Validator.validateEmail("sacr--tum@gmail.com"));
        assertFalse("Hyphen and dot", Validator.validateEmail("sacr.-tum@gmail.com"));
        assertFalse("Email don't start with letter", Validator.validateEmail("-sacr8tum@gmail.com"));
        assertFalse("Too short username (<6)", Validator.validateEmail("sss@gmail.com"));
        assertTrue("True email", Validator.validateEmail("sacr8tum@gmail.com"));
    }

    @Test
    public void testValidateCity() {

    }
=======
package com.donishchenko.airbnb.validation;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {
    @Test
    public void testValidateName() {
        assertFalse("Null name", Validator.validateName(null));
        assertFalse("Empty name", Validator.validateName(""));
        assertFalse("Only letters (numbers)", Validator.validateName("Dmi9try"));
        assertFalse("Only letters (other symbols)", Validator.validateName("Dmit_ry"));
        assertFalse("First letter lower case", Validator.validateName("dmitry"));
        assertFalse("Only first letter need to be in uppercase", Validator.validateName("DmiTry"));
        assertFalse("Second name starts with lowercase", Validator.validateName("Dmitry-vladislav"));
        assertFalse("Too short name (<2)", Validator.validateName("D"));
        assertFalse("Too long name (>40)", Validator.validateName("Mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmq"));
        assertTrue("Double name", Validator.validateName("Dmitry-Vladislav"));
        assertTrue("Triple name (etc)", Validator.validateName("Dmitry-Vladislav-Victoria"));
    }

    @Test
    public void testValidateSurname() {
        assertFalse("Null name", Validator.validateSurname(null));
        assertFalse("Empty name", Validator.validateSurname(""));
        assertFalse("Only letters (numbers)", Validator.validateSurname("Oni9shchenko"));
        assertFalse("Only letters (other symbols)", Validator.validateSurname("Onish_chenko"));
        assertFalse("First letter lower case", Validator.validateSurname("onishchenko"));
        assertFalse("Only first letter need to be in uppercase", Validator.validateSurname("OniShchenKo"));
        assertFalse("Second surname starts with lowercase", Validator.validateSurname("Onishchenko-tipunov"));
        assertFalse("Too short surname (<2)", Validator.validateSurname("D"));
        assertFalse("Too long surname (>40)", Validator.validateSurname("Mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmq"));
        assertTrue("Double surname", Validator.validateSurname("Onishchenko-Tipunov"));
        assertTrue("Triple surname (etc)", Validator.validateSurname("Onishchenko-Tipunov-Grachovski"));
    }

    @Test
    public void testValidateEmail() {
        assertFalse("Null email", Validator.validateEmail(null));
        assertFalse("Empty email", Validator.validateEmail(""));
        assertFalse("Uppercase letters", Validator.validateEmail("sAcR8TuM@gmail.com"));
        assertFalse("Two hyphens (--)", Validator.validateEmail("sacr--tum@gmail.com"));
        assertFalse("Hyphen and dot", Validator.validateEmail("sacr.-tum@gmail.com"));
        assertFalse("Email don't start with letter", Validator.validateEmail("-sacr8tum@gmail.com"));
        assertFalse("Too short username (<6)", Validator.validateEmail("sss@gmail.com"));
        assertTrue("True email", Validator.validateEmail("sacr8tum@gmail.com"));
    }

    @Test
    public void testValidateCity() {

    }
>>>>>>> b406adcc396a7505479ad772bb83478ed6740c5d
}