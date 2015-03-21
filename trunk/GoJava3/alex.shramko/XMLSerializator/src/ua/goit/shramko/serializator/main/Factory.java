package ua.goit.shramko.serializator.main;

import java.util.List;

import ua.goit.shramko.serializator.basicObjects.*;

public class Factory {
  
  public static Shape createObject(String type, List<Shape> list, int radius, Point... points) {
    /*try {
      return (Shape) type.newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;*/
    
    if ("Triangle".equals(type)) {
      return new Triangle(points[0], points[1], points[2]);
    } else if ("Rectangle".equals(type)) {
      return new Rectangle(points[0], points[1]);
    } else if ("Circle".equals(type)) {
      return new Circle(radius,points[0]);
    } else if ("Group".equals(type)) {
      return new Group(list);
    } else {
      throw new RuntimeException("Invalid class type");
    }
  }

}
