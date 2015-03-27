package ua.goit.shapeserializer.main;

import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.*;

public class Main {
  public static void main(String[] args) {
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

    SerializeClassHolder clHolder = SerializerFactory.getSerializerFor("xml");
    String res = clHolder.serialize(gr2);
    System.out.println(res);
    clHolder = SerializerFactory.getSerializerFor("json");
    res = clHolder.serialize(gr2);
    System.out.println(res);
  }
}
