package ua.dborisenko.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

public class ErrorTest {

    private static Error error = new Error(418, "I'm a teapot", "Test error description.");

    @Test
    public void getCode() {
        assertTrue(418 == error.getCode());
    }
    
    @Test
    public void getName() {
        assertEquals("I'm a teapot", error.getName());
    }

    @Test
    public void getDescription() {
        assertEquals("Test error description.", error.getDescription());
    }
}
