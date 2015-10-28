package ua.goit.shapeserializer.tests;

import junit.framework.TestCase;
import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.*;

public class XmlJsonTest extends TestCase {

  public void test() {

    Shape group1 = new Group();
    group1.add(new Triangle(new Point(5, 10), new Point(6, 20), new Point(7, 30)));
    Shape square = new Square(new Point(5, 5), new Point(30, 30));
    group1.add(square);
    Shape group2 = new Group();
    group2.add(new Circle(50, new Point(25, 45)));
    group2.add(group1);

    String expected = "<Group><circle><center><point><x>25</x><y>45</y></point></center><radius>50</radius></circle><Group><triangle><point><x>5</x><y>10</y></point><point><x>6</x><y>20</y></point><point><x>7</x><y>30</y></point></triangle><square><point><x>5</x><y>5</y></point><point><x>30</x><y>30</y></point></square></Group></Group>";
    SerializeClassHolder classHolder1 = SerializerFactory.getSerializerFor("xml");
    String actual1 = classHolder1.serialize(group2);
    actual1 = actual1.replace(" ", "");
    actual1 = actual1.replace("\n", "");
    assertEquals(expected, actual1);

    String expected2 = "\"Group\":[{\"Circle\":{\"center\":{\"Point\":{\"x\":25,\"y\":45}},\"radius\":50}},{\"Group\":[{\"Triangle\":[{\"Point\":{\"x\":5,\"y\":10}},{\"Point\":{\"x\":6,\"y\":20}},{\"Point\":{\"x\":7,\"y\":30}}]},{\"square\":[{\"Point\":{\"x\":5,\"y\":5}},{\"Point\":{\"x\":30,\"y\":30}}]}]}]";
    SerializeClassHolder classHolder2 = SerializerFactory.getSerializerFor("json");
    String actual2 = classHolder2.serialize(group2);
    actual2 = actual2.replace(" ", "");
    actual2 = actual2.replace("\n", "");
    assertEquals(expected2, actual2);
  }
}
