package ua.goit.test;

import org.junit.Test;

import static org.junit.Assert.*;


import ua.goit.graphElements.Group;
import ua.goit.graphElements.GroupImpl;
import ua.goit.graphElements.Point;
import ua.goit.graphElements.PointImpl;
import ua.goit.serialization.ConcreteFactory;
import ua.goit.serialization.SerializationType;
import ua.goit.shapes.Triangle;

/**
 * Created by kossovec on 22.03.2015.
 */
public class TestJSONSerialize {
  private Point point1 = new PointImpl(1,2);
  private Point point2 = new PointImpl(2,1);
  private Triangle triangle1 = new Triangle("triangel1");
  private Triangle triangle2 = new Triangle("triangel2");
  private Triangle triangle3 = new Triangle("triangel3");
  private Group group1 = new GroupImpl("group1");
  private Group group2 = new GroupImpl("group2");
  private Group group3 = new GroupImpl("group3");
  private ConcreteFactory factory = new ConcreteFactory();
  private String withoutGroup = "{\n" +
          "\"Name\" : \"triangel1\"\n" +
          "\"Type\" : \"Triangle\"\n" +
          "\"Points\" : [\n" +
          "    \"Point\" : \"(1, 2)\"\n" +
          "    \"Point\" : \"(2, 1)\"\n" +
          "]\n" +
          "}\n";

  private String oneGroup = "group1 {\n" +
          "    {\n" +
          "    \"Name\" : \"triangel1\"\n" +
          "    \"Type\" : \"Triangle\"\n" +
          "    \"Points\" : [\n" +
          "        \"Point\" : \"(1, 2)\"\n" +
          "    ]\n" +
          "    }\n" +
          "    {\n" +
          "    \"Name\" : \"triangel2\"\n" +
          "    \"Type\" : \"Triangle\"\n" +
          "    \"Points\" : [\n" +
          "        \"Point\" : \"(2, 1)\"\n" +
          "    ]\n" +
          "    }\n" +
          "}\n";
  private String gropeInGroup = "group2 {\n" +
          "    group1 {\n" +
          "        {\n" +
          "        \"Name\" : \"triangel1\"\n" +
          "        \"Type\" : \"Triangle\"\n" +
          "        \"Points\" : [\n" +
          "        ]\n" +
          "        }\n" +
          "        {\n" +
          "        \"Name\" : \"triangel2\"\n" +
          "        \"Type\" : \"Triangle\"\n" +
          "        \"Points\" : [\n" +
          "            \"Point\" : \"(1, 2)\"\n" +
          "            \"Point\" : \"(2, 1)\"\n" +
          "        ]\n" +
          "        }\n" +
          "    }\n" +
          "    {\n" +
          "    \"Name\" : \"triangel3\"\n" +
          "    \"Type\" : \"Triangle\"\n" +
          "    \"Points\" : [\n" +
          "    ]\n" +
          "    }\n" +
          "}\n";

  @Test
  public void testSerializeWithoutGroup() {
    triangle1.addPoint(point1);
    triangle1.addPoint(point2);
    assertEquals(withoutGroup, factory.getSerializationFor(SerializationType.JSON).serialize(triangle1).toString());
  }

  @Test
  public void testSerializeWithOneGroup() {
    triangle1.addPoint(point1);
    triangle2.addPoint(point2);
    group1.setElement(triangle1);
    group1.setElement(triangle2);
    assertEquals(oneGroup, factory.getSerializationFor(SerializationType.JSON).serialize(group1).toString());
  }

  @Test
  public void testSerializeWithGroupInGroup() {
    triangle2.addPoint(point1);
    triangle2.addPoint(point2);
    group1.setElement(triangle1);
    group1.setElement(triangle2);
    group2.setElement(triangle3);
    group2.setGroup(group1);
    assertEquals(gropeInGroup, factory.getSerializationFor(SerializationType.JSON).serialize(group2).toString());
  }
}
