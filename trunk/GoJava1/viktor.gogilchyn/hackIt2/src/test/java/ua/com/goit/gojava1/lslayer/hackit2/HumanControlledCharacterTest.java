package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;

public class HumanControlledCharacterTest {
    @Test
    public void testName() {
        HumanControlledCharacter newChar = new HumanControlledCharacter("TestName");
        assertEquals("TestName", newChar.getName());
    }
}
