package ua.goit.test;

import static org.junit.Assert.*;

import java.util.Iterator;


import org.junit.Test;

import ua.goit.graphElements.*;
import ua.goit.serialization.*;

/**
 * Test Unit for testing Factory pattern, group and point class
 * @author Anton Yarosh
 *
 */
public class PatternsTest {
   @Test
    public void elementAddingTest() {
	Group ge1 = new GroupImpl("Group 1");
	Group ge2 = new GroupImpl("Group 2");
	ge1.setGroup(ge2);
	Group innerGroup = ge1.getGroups().get(0);
	String expectedValue = "Group 2";
	String actualValue = innerGroup.getName();
	assertEquals(expectedValue, actualValue);
    }  
}