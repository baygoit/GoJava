package ua.goit.shapeserializer.main;

import java.util.List;

import ua.goit.shapeserializer.basicobjects.Circle;
import ua.goit.shapeserializer.basicobjects.Group;
import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;
import ua.goit.shapeserializer.basicobjects.Triangle;
import ua.goit.shapeserializer.serializers.JSONShapeSerializer;
import ua.goit.shapeserializer.serializers.SerializerFor;
import ua.goit.shapeserializer.serializers.XMLShapeSerializer;


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
      return new JSONShapeSerializer();
    } else if ("JSON".equals(type)) {
      return new XMLShapeSerializer();
    } else {
      throw new RuntimeException("Invalid class type");
    }
  }

}
