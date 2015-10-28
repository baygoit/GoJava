/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.json;

import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializeJSONClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;
import ua.goit.shapeserializer.xml.ShapeXMLSerializer;

public class SquareJSONSerializer  extends ShapeXMLSerializer{
    @Override
    public String serialize(Shape shape) {
      StringBuilder squareXML = new StringBuilder();
      Square square = (Square) shape;
      
      SerializeClassHolder classHolder = SerializerFactory.getSerializerFor("json");
      
      
      squareXML.append("\"square\" : [{");
      squareXML.append(classHolder.serialize(square.getA()));
      squareXML.append("}");
      squareXML.append(",");
      squareXML.append("{");
      squareXML.append(classHolder.serialize(square.getB()));
      squareXML.append("}]\n");
      return squareXML.toString();
}
}