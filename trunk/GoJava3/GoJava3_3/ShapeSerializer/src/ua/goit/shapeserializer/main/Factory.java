package ua.goit.shapeserializer.main;

import ua.goit.shapeserializer.basicobjects.*;
import ua.goit.shapeserializer.serializers.JSONShapeSerializer;
import ua.goit.shapeserializer.serializers.SerializerFor;
import ua.goit.shapeserializer.serializers.XMLShapeSerializer;

import java.util.List;


public class Factory {

  public static Shape createObject(String type, List<Shape> list, int radius,
      Point... points) {
    if ("Triangle".equals(type)) {
      return new Triangle(points[0], points[1], points[2]);
    } else if ("Square".equals(type)) {
      return new Square(points[0], points[1]);
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
      return new XMLShapeSerializer();
    } else if ("JSON".equals(type)) {
      return new JSONShapeSerializer();
    } else {
      throw new RuntimeException("Invalid class type");
    }
  }

}
