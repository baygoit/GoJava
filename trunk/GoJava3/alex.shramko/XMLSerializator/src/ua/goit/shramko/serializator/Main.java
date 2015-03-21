package ua.goit.shramko.serializator;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    Groupable circle1 = Factory.createObject("Circle", null, 5);
    Groupable triangle1 = Factory.createObject("Triangle", null, 3, 3, 4);
    List<Groupable> list1 = new ArrayList<Groupable>();
    list1.add(circle1);
    list1.add(triangle1);
    Groupable group1 = Factory.createObject("Group", list1);

    Groupable circle2 = Factory.createObject("Circle", null, 6);
    Groupable circle3 = Factory.createObject("Circle", null, 8);
    Groupable rectangle1 = Factory.createObject("Rectangle", null, 4, 5);

    List<Groupable> list2 = new ArrayList<Groupable>();
    list1.add(circle2);
    list1.add(circle3);
    list1.add(rectangle1);
    list1.add(group1);
    Groupable group2 = Factory.createObject("Group", list2);

  }

}
