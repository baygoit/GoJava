/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.xml;

import ua.goit.shapeserializer.Formats;
import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Triangle;

public class TriangleXMLSerializer extends ShapeXMLSerializer {
  @Override
  public String serialize(Shape shape) {
    StringBuilder result = new StringBuilder();
    Triangle triangle = (Triangle) shape;
    SerializeClassHolder classHolder = SerializerFactory.getSerializerFor(Formats.XML);

    result.append("<triangle>\n ");
    result.append(classHolder.serialize(triangle.getA()));
    result.append(classHolder.serialize(triangle.getB()));
    result.append(classHolder.serialize(triangle.getC()));
    result.append("</triangle>\n");
    return result.toString();
  }
}