package com.sandarovich.module1.helloworld;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    String message = "Hello World!";
    Messenger messenger = new Messenger(); 
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    
    @Test
    public void testSimpleConsoleOutputMessage(){
	messenger.setOutputFormatter(new SimpleConsoleOutput());
	messenger.getOutputFormatter().processMessage(message);
	assertEquals("Hello World!", outContent.toString() );
    }
    
    @Test
    public void testLog4jConsoleOutputMessage(){
	messenger.setOutputFormatter(new Log4jConsoleOutput());
	messenger.getOutputFormatter().processMessage(message);
	assertEquals("Hello World!", outContent.toString() );
    }
   

}
