package ua.goit.shapeserializer.json;

import ua.goit.shapeserializer.Formats;
import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.Group;
import ua.goit.shapeserializer.basicobjects.Shape;

import java.util.List;

public class GroupJSONSerializer extends ShapeJSONSerializer {

  @Override
  public String serialize(Shape arg) {
    Group groupShapes = (Group) arg;
    StringBuilder result = new StringBuilder();
    List<Shape> shapes = groupShapes.getValues();

    SerializeClassHolder classHolder = SerializerFactory.getSerializerFor(Formats.JSON);
    result.append("\"Group\": \n");
    result.append("[\n");
    for (Shape shape : shapes) {
      result.append("{\n");
      result.append(classHolder.serialize(shape));
      result.append("}\n");
      result.append(",");

    }

    result.delete(result.length() - 1, result.length());

    result.append("]\n");


    return result.toString();
  }
}