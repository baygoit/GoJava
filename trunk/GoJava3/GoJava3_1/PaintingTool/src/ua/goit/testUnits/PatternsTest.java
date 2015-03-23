package ua.goit.testUnits;

import static org.junit.Assert.*;

import java.util.Iterator;


import org.junit.Test;

import ua.goit.graphElements.*;
import ua.goit.serialization.*;

public class PatternsTest {

    @Test
    public void factoryCreatingTest() {
	SerializationFactory factory = null;
	factory = new ConcreteFactory();
	boolean expectedValue = true;
	boolean actualValue = factory instanceof ConcreteFactory;
	assertEquals(expectedValue, actualValue);
    }

    @Test
    public void xmlSerializatorCreatingTest() {
	SerializationFactory factory = new ConcreteFactory();
	Serializator xmlSerialization = factory.getSerializationFor(SerializationType.XML);
	boolean expectedValue = true;
	boolean actualValue = xmlSerialization instanceof XMLSerializator;
	assertEquals(expectedValue, actualValue);
    }

    @Test
    public void jsonSerializatorCreatingTest() {
	SerializationFactory factory = new ConcreteFactory();
	Serializator jsonSerialization = factory.getSerializationFor(SerializationType.JSON);
	boolean expectedValue = true;
	boolean actualValue = jsonSerialization instanceof JSONSerializator;
	assertEquals(expectedValue, actualValue);
    }

    @Test
    public void groupCreatingTest() {
	GraphElement ge = new Group("Group 1");
	boolean expectedValue = true;
	boolean actualValue = ge instanceof Group;
	assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getGroupNameTest() {
	GraphElement ge = new Group("Group 1");
	String expectedValue = "Group 1";
	String actualValue = ge.getName();
	assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getGroupTypeTest() {
	GraphElement ge = new Group("Group 1");
	String expectedValue = "Group";
	String actualValue = ge.getType();
	assertEquals(expectedValue, actualValue);
    }

    @Test
    public void isElementTest() {
	GraphElement ge = new Group("Group 1");
	boolean expectedValue = false;
	boolean actualValue = ge.isElement();
	assertEquals(expectedValue, actualValue);
    }

    @Test
    public void elementAddingTest() {
	GraphElement ge1 = new Group("Group 1");
	GraphElement ge2 = new Group("Group 2");
	ge1.add(ge2);
	Iterator group1Iter = ge1.iterator();
	GraphElement innerGroup = (GraphElement) group1Iter.next();
	String expectedValue = "Group 2";
	String actualValue = innerGroup.getName();
	assertEquals(expectedValue, actualValue);
    }


}