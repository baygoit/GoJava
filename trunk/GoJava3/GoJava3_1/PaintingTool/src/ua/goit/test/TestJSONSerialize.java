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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by kossovec on 22.03.2015.
 */
public class TestJSONSerialize {
  private static Point point1 = new PointImpl(1, 2);
  private static Point point2 = new PointImpl(2, 1);
  private static Triangle triangle1 = new Triangle("triangel1");
  private static Triangle triangle2 = new Triangle("triangel2");
  private static Triangle triangle3 = new Triangle("triangel3");
  private static Group group1 = new GroupImpl("group1");
  private static Group group2 = new GroupImpl("group2");
  private static Group group3 = new GroupImpl("group3");
  private static ConcreteFactory factory = new ConcreteFactory();
  private File fileTestSerializeWithoutGroup = new File("src\\ua\\goit\\test\\fixtures\\testSerializeWithoutGroup.txt");
  private File fileTestSerializeWithOneGroup = new File("src\\ua\\goit\\test\\fixtures\\testSerializeWithOneGroup.txt");
  private File fileTestSerializeWithGroupInGroup = new File("src\\ua\\goit\\test\\fixtures\\testSerializeWithGroupInGroup.txt");

    @Test
  public void testSerializeWithoutGroup() {
    triangle1.addPoint(point1);
    triangle1.addPoint(point2);
    assertEquals(fromFileToString(fileTestSerializeWithoutGroup), factory.getSerializationFor(SerializationType.JSON).serialize(triangle1).toString());
  }

  @Test
  public void testSerializeWithOneGroup() {
    triangle1.addPoint(point1);
    triangle2.addPoint(point2);
    group1.setElement(triangle1);
    group1.setElement(triangle2);
    assertEquals(fromFileToString(fileTestSerializeWithOneGroup), factory.getSerializationFor(SerializationType.JSON).serialize(group1).toString());
  }

  @Test
  public void testSerializeWithGroupInGroup() {
    triangle2.addPoint(point1);
    triangle2.addPoint(point2);
    group1.setElement(triangle1);
    group1.setElement(triangle2);
    group2.setElement(triangle3);
    group2.setGroup(group1);
    assertEquals(fromFileToString(fileTestSerializeWithGroupInGroup), factory.getSerializationFor(SerializationType.JSON).serialize(group2).toString());
  }

  private String fromFileToString(File file){
    StringBuffer result = new StringBuffer();
    try {
      Scanner in = new Scanner(file);
      while (in.hasNext()) {
        result.append(in.nextLine() + "\n");
      }
      result.delete(result.length()-1,result.length());
    }catch (FileNotFoundException e) {
      throw new RuntimeException("File error tra la la");
    }

    return result.toString();
  }
}
