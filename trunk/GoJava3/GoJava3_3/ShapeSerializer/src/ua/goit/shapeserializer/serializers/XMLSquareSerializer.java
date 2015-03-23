/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers;

import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;

public class XMLSquareSerializer extends XMLShapeSerializer {
  @Override
  public String serialize(Shape shape) {
    StringBuilder squareXML = new StringBuilder();
    Square square = (Square) shape;
    squareXML.append("<square><point><x>");
    squareXML.append(square.getA().getX() + "</x><y>");
    squareXML.append(square.getA().getY() + "</y></point><point><x>");
    squareXML.append(square.getB().getX() + "</x><y>");
    squareXML.append(square.getB().getY() + "</y></point><square>");
    return squareXML.toString();
  }
}