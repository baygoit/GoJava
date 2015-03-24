/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.xml;

import ua.goit.shapeserializer.Formats;
import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;

public class SquareXMLSerializer extends ShapeXMLSerializer {
  @Override
  public String serialize(Shape shape) {
    StringBuilder squareXML = new StringBuilder();
    Square square = (Square) shape;

    SerializeClassHolder classHolder = SerializerFactory.getSerializerFor(Formats.XML);

    squareXML.append("<square>\n");
    squareXML.append(classHolder.serialize(square.getA()));
    squareXML.append(classHolder.serialize(square.getB()));
    squareXML.append("</square>\n");
    return squareXML.toString();
  }
}