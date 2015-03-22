package ua.goit.shapeserializer.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.main.Factory;
import ua.goit.shapeserializer.serializers.SerializerFor;


public class SimpleTriangleTestXML {

  @Test
  public void test() {
    Shape triangle1 = Factory.createObject("Triangle", null, 0, new Point(30,
        30), new Point(30, 40), new Point(40, 30));
    String expected = "<triangle><point><x>30</x><y>30</y></point><point><x>30</x><y>40</y></point><point><x>40</x><y>30</y></point></triangle>";
    SerializerFor xml = Factory.getSerializerFor("XML");
    String actual = xml.serialize(triangle1);
    assertEquals(expected, actual);

  }

}
