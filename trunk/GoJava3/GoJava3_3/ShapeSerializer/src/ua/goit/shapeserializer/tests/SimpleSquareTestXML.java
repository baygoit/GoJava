package ua.goit.shapeserializer.tests;

import org.junit.Test;
import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;

import static org.junit.Assert.assertEquals;


public class SimpleSquareTestXML {

  @Test
  public void test() {

    Shape square = new Square(new Point(10, 10), new Point(20, 20));

    String expected = "<square><point><x>10</x><y>10</y></point><point><x>20</x><y>20</y></point></square>";
    SerializeClassHolder clHolder = SerializerFactory.getSerializerFor("xml");
    String actual = clHolder.serialize(square);
    actual = actual.replace(" ", "");
    actual = actual.replace("\n", "");
    assertEquals(expected, actual);
  }

}
