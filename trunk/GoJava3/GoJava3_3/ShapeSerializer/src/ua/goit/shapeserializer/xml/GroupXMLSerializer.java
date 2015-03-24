/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.xml;

import ua.goit.shapeserializer.Formats;
import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.Group;
import ua.goit.shapeserializer.basicobjects.Shape;

import java.util.List;

public class GroupXMLSerializer extends ShapeXMLSerializer {

  @Override
  public String serialize(Shape arg) {
    Group groupShapes = (Group) arg;
    StringBuilder result = new StringBuilder();
    List<Shape> shapes = groupShapes.getValues();

    SerializeClassHolder classHolder = SerializerFactory.getSerializerFor(Formats.XML);
    result.append("<Group>\n");
    for (Shape shape : shapes) {
      result.append(classHolder.serialize(shape));
    }
    result.append("</Group>\n");

    return result.toString();
  }
}