package ua.goit.shapeserializer.tests;

import org.junit.Test;
import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.*;

import static org.junit.Assert.assertEquals;

public class ComplexTest {

  @Test
  public void test() {
    Shape gr = new Group();
    Shape gr2 = new Group();
    gr.add(new Circle(20, new Point(0, 12)));
    gr.add(new Triangle(new Point(3, 32), new Point(20, 30), new Point(43, 54)));
    gr.add(new Square(new Point(20, 30), new Point(43, 54)));
    gr2.add(new Point(43, 54));
    gr2.add(new Triangle(new Point(0, 12), new Point(20, 30), new Point(43, 54)));
    gr2.add(new Triangle(new Point(3, 32), new Point(20, 30), new Point(43, 54)));
    gr.add(new Square(new Point(20, 30), new Point(43, 54)));
    gr2.add(gr);
   
    String expectedXML = "<Group><point><x>43</x><y>54</y></point><triangle>"
        + "<point><x>0</x><y>12</y></point><point><x>20</x><y>30</y></point>"
        + "<point><x>43</x><y>54</y></point></triangle><triangle><point>"
        + "<x>3</x><y>32</y></point><point><x>20</x><y>30</y></point><point>"
        + "<x>43</x><y>54</y></point></triangle><Group><circle><center><point>"
        + "<x>0</x><y>12</y></point></center><radius>20</radius></circle>"
        + "<triangle><point><x>3</x><y>32</y></point><point><x>20</x><y>30</y>"
        + "</point><point><x>43</x><y>54</y></point></triangle><square><point>"
        + "<x>20</x><y>30</y></point><point><x>43</x><y>54</y></point></square>"
        + "<square><point><x>20</x><y>30</y></point><point><x>43</x><y>54</y>"
        + "</point></square></Group></Group>";
    SerializeClassHolder clHolderXML = SerializerFactory.getSerializerFor("xml");
    String actualXML = clHolderXML.serialize(gr2);
    actualXML = actualXML.replace(" ", "");
    actualXML = actualXML.replace("\n", "");
    assertEquals(expectedXML, actualXML);
    
    String expectedJSON = "\"Group\":[{\"Point\":{\"x\":43,\"y\":54}}"
        + ",{\"Triangle\":[{\"Point\":{\"x\":0,\"y\":12}},{\"Point\""
        + ":{\"x\":20,\"y\":30}},{\"Point\":{\"x\":43,\"y\":54}}]},"
        + "{\"Triangle\":[{\"Point\":{\"x\":3,\"y\":32}},{\"Point\""
        + ":{\"x\":20,\"y\":30}},{\"Point\":{\"x\":43,\"y\":54}}]},{"
        + "\"Group\":[{\"Circle\":{\"center\":{\"Point\":{\"x\":0,\"y\":12"
        + "}},\"radius\":20}},{\"Triangle\":[{\"Point\":{\"x\":3,\"y\":32"
        + "}},{\"Point\":{\"x\":20,\"y\":30}},{\"Point\":{\"x\":43,\"y\":54"
        + "}}]},{\"square\":[{\"Point\":{\"x\":20,\"y\":30}},{\"Point\":"
        + "{\"x\":43,\"y\":54}}]},{\"square\":[{\"Point\":{\"x\":20,\"y\":"
        + "30}},{\"Point\":{\"x\":43,\"y\":54}}]}]}]";
    SerializeClassHolder clHolderJSON = SerializerFactory.getSerializerFor("json");
    String actualJSON = clHolderJSON.serialize(gr2);
    actualJSON = actualJSON.replace(" ", "");
    actualJSON = actualJSON.replace("\n", "");
    assertEquals(expectedJSON, actualJSON);
  }
}
