package ua.goit.test;

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
	Group ge = new GroupImpl("Group 1");
	boolean expectedValue = true;
	boolean actualValue = ge instanceof Group;
	assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getGroupNameTest() {
	Group ge = new GroupImpl("Group 1");
	String expectedValue = "Group 1";
	String actualValue = ge.getName();
	assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getGroupTypeTest() {
	Group ge = new GroupImpl("Group 1");
	String expectedValue = "Group";
	String actualValue = ge.getType();
	assertEquals(expectedValue, actualValue);
    }

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

    @Test
    public void pointCreatinTest() {
	Point point = new PointImpl(5, 6);
	boolean expectedValue = true;
	boolean actualValue = point instanceof Point;
	assertEquals(expectedValue, actualValue);
    }

    @Test
    public void gettingPointCoordinateTest() {
	Point point = new PointImpl(5, 6);
	String expectedValue = "(5, 6)";
	String actualValue = point.getCoordinate();
	assertEquals(expectedValue, actualValue);
    }

    
}