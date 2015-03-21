package ua.goit.shramko.serializator.main;

import java.util.List;

import ua.goit.shramko.serializator.basicobjects.*;
import ua.goit.shramko.serializator.serializers.SerializerFor;
import ua.goit.shramko.serializator.serializers.SerializerJSON;
import ua.goit.shramko.serializator.serializers.SerializerXML;

public class Factory {

  public static Shape createObject(String type, List<Shape> list, int radius,
      Point... points) {
    if ("Triangle".equals(type)) {
      return new Triangle(points[0], points[1], points[2]);
    } else if ("Rectangle".equals(type)) {
      return new Rectangle(points[0], points[1]);
    } else if ("Circle".equals(type)) {
      return new Circle(radius, points[0]);
    } else if ("Group".equals(type)) {
      return new Group(list);
    } else {
      throw new RuntimeException("Invalid class type");
    }
  }

  public static SerializerFor getSerializerFor(String type) {
    if ("XML".equals(type)) {
      return new SerializerXML();
    } else if ("JSON".equals(type)) {
      return new SerializerJSON();
    } else {
      throw new RuntimeException("Invalid class type");
    }
  }

}
