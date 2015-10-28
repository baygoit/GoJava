package ua.goit.shapeserializer.json;

import ua.goit.shapeserializer.Formats;
import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.Circle;
import ua.goit.shapeserializer.basicobjects.Shape;

public class CircleJSONSerializer extends ShapeJSONSerializer {
  @Override
  public String serialize(Shape shape) {
    StringBuilder result = new StringBuilder();
    Circle circle = (Circle) shape;
    SerializeClassHolder clHolder = SerializerFactory.getSerializerFor(Formats.JSON);

    result.append("\"Circle\": {");
    result.append("\"center\": {");
    result.append(clHolder.serialize(circle.getCenter()));
    result.append("}\n");
    result.append(",");
    result.append("\"radius\": ");
    result.append(circle.getRadius());
    result.append("}\n");
    return result.toString();
  }
}