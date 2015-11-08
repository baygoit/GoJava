package ua.goit.shapeserializer.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Triangle;


public class SimpleTriangleTestXML {

  @Test
  public void test() {
     
     Shape triangle = new Triangle(new Point(10,10),new Point(20,20),new Point(30,30));    
      
    String expected = "<triangle><point><x>10</x><y>10</y></point><point><x>20</x><y>20</y></point><point><x>30</x><y>30</y></point></triangle>";
    
    SerializeClassHolder clHolder = SerializerFactory.getSerializerFor("xml");
    String actual = clHolder.serialize(triangle);
    actual = actual.replace(" ", "");
    actual = actual.replace("\n", "");
    actual = actual.toLowerCase();
    assertEquals(expected, actual);
}
}