package ua.goit.shapeserializer.json;

import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;

public class PointJSONSerializer extends ShapeJSONSerializer {

  public String serialize(Shape shape) {
    StringBuilder result = new StringBuilder();
    Point point = (Point) shape;
    result.append("\"Point\" : {");
    result.append("\"x\":").append(point.getX()).append(",");
    result.append("\"y\":").append(point.getY());
    result.append("}");
    return result.toString();
  }

}
