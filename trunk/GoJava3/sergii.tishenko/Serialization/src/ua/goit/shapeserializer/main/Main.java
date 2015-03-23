package ua.goit.shapeserializer.main;


import ua.goit.shapeserializer.basicobjects.Circle;
import ua.goit.shapeserializer.basicobjects.Group;
import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;
import ua.goit.shapeserializer.basicobjects.Triangle;
import ua.goit.shapeserializers.SerializeClassHolder;
import ua.goit.shapeserializers.SerializerFactory;

public class Main {

  public static void main(String[] args) {

//    Shape circle1 = Factory.createObject("Circle", null, 5, new Point(5, 5));
//    Shape triangle1 = Factory.createObject("Triangle", null, 0, 
//        new Point(30,30), new Point(30, 40), new Point(40, 30));
//    List<Shape> list1 = new ArrayList<Shape>();
//    list1.add(circle1);
//    list1.add(triangle1);
//    Shape group1 = Factory.createObject("Group", list1,0);
//
//    Shape circle2 = Factory.createObject("Circle", null, 6, new Point(5, 5));
//    Shape circle3 = Factory.createObject("Circle", null, 8, new Point(5, 5));
//    Shape rectangle1 = Factory.createObject("Rectangle", null, 0, new Point(20, 20), new Point(40, 40));
//
//    List<Shape> list2 = new ArrayList<Shape>();
//    list1.add(circle2);
//    list1.add(circle3);
//    list1.add(rectangle1);
//    list1.add(group1);
//    Shape group2 = Factory.createObject("Group", list2, 0);

//      SerializeXMLClassHolder s = new SerializeXMLClassHolder();
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
