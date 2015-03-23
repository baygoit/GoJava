/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers.JSONserializers;

import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;
import ua.goit.shapeserializer.serializers.XMLserializers.ShapeXMLSerializer;
import ua.goit.shapeserializers.SerializeClassHolder;
import ua.goit.shapeserializers.SerializeJSONClassHolder;
import ua.goit.shapeserializers.SerializerFactory;

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