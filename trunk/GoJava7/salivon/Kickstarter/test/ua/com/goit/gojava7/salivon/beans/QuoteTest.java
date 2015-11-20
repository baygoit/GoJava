package ua.com.goit.gojava7.salivon.beans;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class QuoteTest {

    Quote instance;

    @Before
    public void setUp() {
        instance = new Quote("Hello!", "Petro");
    }

    @Test
    public void testGetText() {
        String expResult = "Hello!";
        String result = instance.getText();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetText() {
        String text = "World!";
        instance.setText(text);
        assertEquals(text, instance.getText());
    }

    @Test
    public void testGetAutor() {
        String expResult = "Petro";
        String result = instance.getAutor();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetAutor() {
        String autor = "Ivan";
        instance.setAutor(autor);
        assertEquals(autor, instance.getAutor());

    }

}
