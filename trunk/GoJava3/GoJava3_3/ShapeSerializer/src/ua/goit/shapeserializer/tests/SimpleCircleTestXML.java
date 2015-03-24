package ua.goit.shapeserializer.tests;

import org.junit.Test;
import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.Circle;
import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.xml.CircleXMLSerializer;
import ua.goit.shapeserializer.xml.ShapeXMLSerializer;

import static org.junit.Assert.assertEquals;


public class SimpleCircleTestXML {

  @Test
  public void test() {
    Shape circle = new Circle(12, new Point(10, 10));

    String expected = "<circle><center><point><x>10</x><y>10</y></point></center><radius>12</radius></circle>";
    SerializeClassHolder clHolder = SerializerFactory.getSerializerFor("xml");
    String actual = clHolder.serialize(circle);
    actual = actual.replace(" ", "");
    actual = actual.replace("\n", "");
    assertEquals(expected, actual);

  }

  @Test
  public void test2() {
    String expected = "<circle><center><point><x>50</x><y>50</y></point></center><radius>5</radius></circle>";
    ShapeXMLSerializer circle = new CircleXMLSerializer();
    String actual = circle.serialize(new Circle(5, new Point(50, 50)));
    actual = actual.replace(" ", "");
    actual = actual.replace("\n", "");
    assertEquals(expected, actual);

  }

}
