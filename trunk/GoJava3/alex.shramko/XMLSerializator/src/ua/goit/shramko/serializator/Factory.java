package ua.goit.shramko.serializator;

import java.util.List;

public class Factory {
  public static Groupable createObject(String type, List<Groupable> list, int... param) {
    if ("Triangle".equals(type)) {
      return new Triangle(param[0], param[1], param[2]);
    } else if ("Rectangle".equals(type)) {
      return new Rectangle(param[0], param[1]);
    } else if ("Circle".equals(type)) {
      return new Circle(param[0]);
    } else if ("Group".equals(type)) {
      return new Group(list);
    } else {
      throw new RuntimeException("Invalid class type");
    }
  }

}
