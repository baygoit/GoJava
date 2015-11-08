package ua.goit.shapeserializer.main;


import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.Circle;
import ua.goit.shapeserializer.basicobjects.Group;
import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;
import ua.goit.shapeserializer.basicobjects.Triangle;

public class Main {

  public static void main(String[] args) {


      Group gr = new Group();
      Group gr2 = new Group();
      gr.add(new Circle(20, new Point(0,12)));
      gr.add(new Triangle(new Point(3,32), new Point(20,30), new Point(43,54) ));
      gr.add(new Square(new Point(20,30), new Point(43,54) ));
      gr2.add(new Point(43,54));
      gr2.add(new Triangle(new Point(0,12), new Point(20,30), new Point(43,54) ));
      gr2.add(new Triangle(new Point(3,32), new Point(20,30), new Point(43,54) ));
      gr.add(new Square(new Point(20,30), new Point(43,54) ));
      gr2.add(gr);
 

      SerializeClassHolder clHolder = SerializerFactory.getSerializerFor("xml");
      Shape shape = gr2;
      String res = clHolder.serialize(shape);
      
      System.out.println(res);
 
      
      
  }

}
