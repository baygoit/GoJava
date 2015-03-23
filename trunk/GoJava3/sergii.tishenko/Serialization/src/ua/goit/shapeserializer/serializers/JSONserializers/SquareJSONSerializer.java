/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers.JSONserializers;

import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;
import ua.goit.shapeserializer.serializers.XMLserializers.ShapeXMLSerializer;
import ua.goit.shapeserializers.SerializeJSONClassHolder;

public class SquareJSONSerializer  extends ShapeXMLSerializer{
    @Override
    public String serialize(Shape shape) {
      StringBuilder squareXML = new StringBuilder();
      Square square = (Square) shape;
      squareXML.append("\"square\" : [{");
      squareXML.append(new SerializeJSONClassHolder().getSerializator(square.getA()).serialize(square.getA()));
      squareXML.append("}");
      squareXML.append(",");
      squareXML.append("{");
      squareXML.append(new SerializeJSONClassHolder().getSerializator(square.getB()).serialize(square.getB()));
      squareXML.append("}]\n");
      return squareXML.toString();
}
}