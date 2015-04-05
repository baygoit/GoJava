package ua.goit.test;

import org.junit.Test;
import ua.goit.graphElements.*;
import ua.goit.serialization.ConcreteFactory;
import ua.goit.serialization.SerializationType;
import ua.goit.shapes.Triangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by kossovec on 22.03.2015.
 */
public class TestJSONSerialize {
  private Point point1 = new PointImpl(1, 2);
  private Point point2 = new PointImpl(2, 1);
  private Triangle triangle1 = new Triangle("triangel1");
  private Triangle triangle2 = new Triangle("triangel2");
  private Triangle triangle3 = new Triangle("triangel3");
  private Group group1 = new GroupImpl("group1");
  private Group group2 = new GroupImpl("group2");
  private ConcreteFactory factory = new ConcreteFactory();
  private File fileTestSerializeWithoutGroup = new File("src\\ua\\goit\\test\\fixtures\\testSerializeWithoutGroup.txt");
  private File fileTestSerializeWithOneGroup = new File("src\\ua\\goit\\test\\fixtures\\testSerializeWithOneGroup.txt");
  private File fileTestSerializeWithGroupInGroup = new File("src\\ua\\goit\\test\\fixtures\\testSerializeWithGroupInGroup.txt");

  @Test
  public void testSerializeWithoutGroup() {
    triangle1.addPoint(point1);
    triangle1.addPoint(point2);
    assertEquals(fromFileToString(fileTestSerializeWithoutGroup), serializeByJSON(triangle1));
  }

  @Test
  public void testSerializeWithOneGroup() {
    triangle1.addPoint(point1);
    triangle2.addPoint(point2);
    group1.setElement(triangle1);
    group1.setElement(triangle2);
    assertEquals(fromFileToString(fileTestSerializeWithOneGroup), serializeByJSON(group1));
  }

  @Test
  public void testSerializeWithGroupInGroup() {
    triangle2.addPoint(point1);
    triangle2.addPoint(point2);
    group1.setElement(triangle1);
    group1.setElement(triangle2);
    group2.setElement(triangle3);
    group2.setGroup(group1);
    assertEquals(fromFileToString(fileTestSerializeWithGroupInGroup), serializeByJSON(group2));
  }

  private String fromFileToString(File file) {
    StringBuilder result = new StringBuilder();
    try {
      Scanner in = new Scanner(file);
      while (in.hasNext()) {
        result.append(in.nextLine() + "\n");
      }
      result.delete(result.length() - 1, result.length());
    } catch (FileNotFoundException e) {
      throw new RuntimeException("File error tra la la", e);
    }

    return result.toString();
  }

  private String serializeByJSON(Element element) {
    return factory.getSerializationFor(SerializationType.JSON).serialize(element).toString();
  }

  private String serializeByJSON(Group group) {
    return factory.getSerializationFor(SerializationType.JSON).serialize(group).toString();
  }
}
