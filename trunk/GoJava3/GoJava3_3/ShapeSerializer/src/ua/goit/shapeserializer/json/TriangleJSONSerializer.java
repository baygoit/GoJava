/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.json;

import ua.goit.shapeserializer.Formats;
import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Triangle;

public class TriangleJSONSerializer extends ShapeJSONSerializer {

  @Override
  public String serialize(Shape shape) {
    StringBuilder result = new StringBuilder();
    Triangle triangle = (Triangle) shape;

    SerializeClassHolder classHolder = SerializerFactory.getSerializerFor(Formats.JSON);

    result.append("\"Triangle\" : [{ ");
    result.append(classHolder.serialize(triangle.getA()));
    result.append("},{");
    result.append(classHolder.serialize(triangle.getB()));
    result.append("},{");
    result.append(classHolder.serialize(triangle.getC()));
    result.append("}]\n");
    return result.toString();
  }
}