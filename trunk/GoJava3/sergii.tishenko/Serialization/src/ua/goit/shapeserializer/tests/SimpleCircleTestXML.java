package ua.goit.shapeserializer.tests;

import org.junit.Test;

import ua.goit.shapeserializer.basicobjects.Circle;
import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.main.SerializerFactory;


import ua.goit.shapeserializer.serializers.XMLserializers.CircleXMLSerializer;
import ua.goit.shapeserializer.serializers.XMLserializers.ShapeXMLSerializer;
import ua.goit.shapeserializers.ShapeSerializer;
import static org.junit.Assert.assertEquals;


public class SimpleCircleTestXML {

  @Test
  public void test() {
    Shape circle = SerializerFactory.createObject("Circle", null, 5, new Point(50,
        50));
    String expected = "<Circle><radius>5</radius><center><x>50</x><y>50</y></center></Circle>";
    ShapeSerializer xml = SerializerFactory.getSerializerFor("XML");
    String actual = xml.serialize(circle);
    assertEquals(expected, actual);
    
  }

  @Test
  public void test2() {
    String expected = "<Circle><radius>5</radius><center><x>50</x><y>50</y></center></Circle>";
    ShapeXMLSerializer circle = new CircleXMLSerializer();
    String actual = circle.serialize(new Circle(5, new Point(50,50)));
    assertEquals(expected, actual);

  }

}
