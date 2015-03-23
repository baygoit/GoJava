package ua.goit.shapeserializer.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.main.SerializerFactory;
import ua.goit.shapeserializers.ShapeSerializer;


public class SimpleSquareTestXML {

  @Test
  public void test() {
    Shape square = SerializerFactory.createObject("Square", null, 0, new Point(30,
        30), new Point(40, 40));
    String expected = "<Square><a><x>30</x><y>30</y></a><b><x>40</x><y>40</y></b></Square>";
    ShapeSerializer xml = SerializerFactory.getSerializerFor("XML");
    String actual = xml.serialize(square);
    assertEquals(expected, actual);
    
  }

}
