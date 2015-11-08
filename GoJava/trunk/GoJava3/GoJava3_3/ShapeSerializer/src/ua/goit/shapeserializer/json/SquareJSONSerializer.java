package ua.goit.shapeserializer.json;

import ua.goit.shapeserializer.Formats;
import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;

public class SquareJSONSerializer extends ShapeJSONSerializer {
  @Override
  public String serialize(Shape shape) {
    StringBuilder squareXML = new StringBuilder();
    Square square = (Square) shape;

    SerializeClassHolder classHolder = SerializerFactory.getSerializerFor(Formats.JSON);

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