package ua.goit.shramko.serializator;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    Shape circle1 = Factory.createObject("Circle", null, 5, new Point(5, 5));
    Shape triangle1 = Factory.createObject("Triangle", null, 0, 
        new Point(30,30), new Point(30, 40), new Point(40, 30));
    List<Shape> list1 = new ArrayList<Shape>();
    list1.add(circle1);
    list1.add(triangle1);
    Shape group1 = Factory.createObject("Group", list1,0);

    Shape circle2 = Factory.createObject("Circle", null, 6, new Point(5, 5));
    Shape circle3 = Factory.createObject("Circle", null, 8, new Point(5, 5));
    Shape rectangle1 = Factory.createObject("Rectangle", null, 0, new Point(20, 20), new Point(40, 40));

    List<Shape> list2 = new ArrayList<Shape>();
    list1.add(circle2);
    list1.add(circle3);
    list1.add(rectangle1);
    list1.add(group1);
    Shape group2 = Factory.createObject("Group", list2, 0);

  }

}
