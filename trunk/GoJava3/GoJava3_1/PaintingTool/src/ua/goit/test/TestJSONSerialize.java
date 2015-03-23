package ua.goit.test;

import org.junit.Test;

import static org.junit.Assert.*;

import ua.goit.graphElements.Group;
import ua.goit.graphElements.Point;
import ua.goit.graphElements.Triangel;
import ua.goit.serialization.ConcreteFactory;
import ua.goit.serialization.SerializationType;

/**
 * Created by kossovec on 22.03.2015.
 */
public class TestJSONSerialize {
  private Point point1 = new Point();
  private Point point2 = new Point();
  private Triangel triangel1 = new Triangel("triangel1");
  private Triangel triangel2 = new Triangel("triangel2");
  private Triangel triangel3 = new Triangel("triangel3");
  private Group group1 = new Group("group1");
  private Group group2 = new Group("group2");
  private Group group3 = new Group("group3");
  private ConcreteFactory factory = new ConcreteFactory();
  private String withoutGroup = "    {\n" +
          "    \"Name\" : triangel1\n" +
          "    \"Type\" : tiangle\n" +
          "    \"Points\" : [\n" +
          "        \"Point\" : (1, 2)\n" +
          "        \"Point\" : (2, 1)\n" +
          "    ]\n" +
          "    }" + "\n";

  private String oneGroup = "group1 {\n" +
          "        {\n" +
          "        \"Name\" : triangel1\n" +
          "        \"Type\" : tiangle\n" +
          "        \"Points\" : [\n" +
          "        ]\n" +
          "        }\n" +
          "        {\n" +
          "        \"Name\" : triangel2\n" +
          "        \"Type\" : tiangle\n" +
          "        \"Points\" : [\n" +
          "            \"Point\" : (1, 2)\n" +
          "            \"Point\" : (2, 1)\n" +
          "        ]\n" +
          "        }\n" +
          "}\n";
  private String gropeInGroup = "group2 {\n" +
          "        {\n" +
          "        \"Name\" : triangel3\n" +
          "        \"Type\" : tiangle\n" +
          "        \"Points\" : [\n" +
          "        ]\n" +
          "        }\n" +
          "    group1 {\n" +
          "            {\n" +
          "            \"Name\" : triangel1\n" +
          "            \"Type\" : tiangle\n" +
          "            \"Points\" : [\n" +
          "            ]\n" +
          "            }\n" +
          "            {\n" +
          "            \"Name\" : triangel2\n" +
          "            \"Type\" : tiangle\n" +
          "            \"Points\" : [\n" +
          "                \"Point\" : (1, 2)\n" +
          "                \"Point\" : (2, 1)\n" +
          "            ]\n" +
          "            }\n" +
          "    }\n" +
          "}\n";

  @Test
  public void testSerializeWithoutGroup() {
    point1.set(1, 2);
    point2.set(2, 1);
    triangel1.addPoint(point1);
    triangel1.addPoint(point2);
    assertEquals(withoutGroup, factory.getSerializationFor(SerializationType.JSON).serialize(triangel1).toString());
  }

  @Test
  public void testSerializeWithOneGroup() {
    point1.set(1, 2);
    point2.set(2, 1);
    triangel2.addPoint(point1);
    triangel2.addPoint(point2);
    group1.add(triangel1);
    group1.add(triangel2);
    assertEquals(oneGroup, factory.getSerializationFor(SerializationType.JSON).serialize(group1).toString());
  }

  @Test
  public void testSerializeWithGroupInGroup() {
    point1.set(1, 2);
    point2.set(2, 1);
    triangel2.addPoint(point1);
    triangel2.addPoint(point2);
    group1.add(triangel1);
    group1.add(triangel2);
    group2.add(triangel3);
    group2.add(group1);
    assertEquals(gropeInGroup, factory.getSerializationFor(SerializationType.JSON).serialize(group2).toString());
  }
}
