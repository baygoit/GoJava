/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers.XMLserializers;

import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;
import ua.goit.shapeserializers.SerializeClassHolder;
import ua.goit.shapeserializers.SerializeXMLClassHolder;
import ua.goit.shapeserializers.SerializerFactory;

public class SquareXMLSerializer extends ShapeXMLSerializer {
  @Override
  public String serialize(Shape shape) {
    StringBuilder squareXML = new StringBuilder();
    Square square = (Square) shape;
    
    SerializeClassHolder classHolder = SerializerFactory.getSerializerFor("xml");
    
    squareXML.append("<square>\n");
    squareXML.append(classHolder.serialize(square.getA()));
    squareXML.append(classHolder.serialize(square.getB()));
    squareXML.append("</square>\n");
    return squareXML.toString();
  }
}