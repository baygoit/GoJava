/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers.XMLserializers;

import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Triangle;
import ua.goit.shapeserializers.SerializeXMLClassHolder;

public class TriangleXMLSerializer extends ShapeXMLSerializer {
  @Override
  public String serialize(Shape shape) {
    StringBuilder result = new StringBuilder();
    Triangle triangle = (Triangle) shape;
    result.append("<triangle>\n ");
    result.append(new SerializeXMLClassHolder().getSerializator(triangle.getA()).serialize(triangle.getA()));
    result.append(new SerializeXMLClassHolder().getSerializator(triangle.getB()).serialize(triangle.getB()));
    result.append(new SerializeXMLClassHolder().getSerializator(triangle.getC()).serialize(triangle.getC()));
    result.append("</triangle>\n");
    return result.toString();
  }
}