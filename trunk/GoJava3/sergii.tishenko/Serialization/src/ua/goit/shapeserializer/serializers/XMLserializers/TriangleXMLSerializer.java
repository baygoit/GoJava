/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers.XMLserializers;

import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Triangle;
import ua.goit.shapeserializers.SerializeClassHolder;
import ua.goit.shapeserializers.SerializeXMLClassHolder;
import ua.goit.shapeserializers.SerializerFactory;

public class TriangleXMLSerializer extends ShapeXMLSerializer {
  @Override
  public String serialize(Shape shape) {
    StringBuilder result = new StringBuilder();
    Triangle triangle = (Triangle) shape;
    SerializeClassHolder classHolder = SerializerFactory.getSerializerFor("xml");
    
    result.append("<triangle>\n ");
    result.append(classHolder.serialize(triangle.getA()));
    result.append(classHolder.serialize(triangle.getB()));
    result.append(classHolder.serialize(triangle.getC()));
    result.append("</triangle>\n");
    return result.toString();
  }
}