package ua.goit.shapeserializer.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.main.SerializerFactory;
import ua.goit.shapeserializers.ShapeSerializer;


public class SimpleTriangleTestXML {

  @Test
  public void test() {
    Shape triangle1 = SerializerFactory.createObject("Triangle", null, 0, new Point(30,
        30), new Point(30, 40), new Point(40, 30));
    String expected = "<Triangle><a><x>30</x><y>30</y></a><b><x>30</x><y>40</y></b><c><x>40</x><y>30</y></c></Triangle>";
    ShapeSerializer xml = SerializerFactory.getSerializerFor("XML");
    String actual = xml.serialize(triangle1);
    assertEquals(expected, actual);

  }

}
