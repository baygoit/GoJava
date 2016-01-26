package com.sandarovich.module1.annagrama;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Unit test for Module #1 Task #3
 */

public class AppTest {
    
    @Test
    public void testAnnagrama() {
        String inputMessage = "мама мыла раму";
        Annagrama annagrama = new Annagrama();
        assertEquals("амам алым умар", annagrama.reversed(inputMessage));
    }
}

