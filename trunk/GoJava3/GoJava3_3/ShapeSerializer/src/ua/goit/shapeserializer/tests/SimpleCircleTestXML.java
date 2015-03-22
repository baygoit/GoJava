package ua.goit.shapeserializer.tests;

import org.junit.Test;
import ua.goit.shapeserializer.basicobjects.Circle;
import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.main.Factory;
import ua.goit.shapeserializer.serializers.SerializerFor;
import ua.goit.shapeserializer.serializers.XMLCircleSerializer;
import ua.goit.shapeserializer.serializers.XMLShapeSerializer;

import static org.junit.Assert.assertEquals;


public class SimpleCircleTestXML {

  @Test
  public void test() {
    Shape circle = Factory.createObject("Circle", null, 5, new Point(50,
        50));
    String expected = "<circle><center><x>50</x><y>50</y></center><radius>5</radius></circle>";
    SerializerFor xml = Factory.getSerializerFor("XML");
    String actual = xml.serialize(circle);
    assertEquals(expected, actual);
    
  }

  @Test
  public void test2() {
    String expected = "<circle><center><x>50</x><y>50</y></center><radius>5</radius></circle>";
    XMLShapeSerializer circle = new XMLCircleSerializer();
    String actual = circle.serialize(new Circle(5, new Point(50,50)));
    assertEquals(expected, actual);

  }

}
