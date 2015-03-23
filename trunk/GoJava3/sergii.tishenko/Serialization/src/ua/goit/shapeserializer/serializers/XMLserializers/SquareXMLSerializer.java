/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers.XMLserializers;

import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;
import ua.goit.shapeserializers.SerializeXMLClassHolder;

public class SquareXMLSerializer extends ShapeXMLSerializer {
  @Override
  public String serialize(Shape shape) {
    StringBuilder squareXML = new StringBuilder();
    Square square = (Square) shape;
    squareXML.append("<square>\n");
    squareXML.append(new SerializeXMLClassHolder().getSerializator(square.getA()).serialize(square.getA()));
    squareXML.append(new SerializeXMLClassHolder().getSerializator(square.getB()).serialize(square.getB()));
    squareXML.append("</square>\n");
    return squareXML.toString();
  }
}