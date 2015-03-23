/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers;

import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Triangle;

public class XMLTriangleSerializer extends XMLShapeSerializer {
  @Override
  public String serialize(Shape shape) {
    StringBuilder triangleXML = new StringBuilder();
    Triangle triangle = (Triangle) shape;
    triangleXML.append("<triangle><point><x>");
    triangleXML.append(triangle.getA().getX() + "</x><y>");
    triangleXML.append(triangle.getA().getY() + "</y></point><point><x>");
    triangleXML.append(triangle.getB().getX() + "</x><y>");
    triangleXML.append(triangle.getB().getY() + "</y></point><point><x>");
    triangleXML.append(triangle.getC().getX() + "</x><y>");
    triangleXML.append(triangle.getC().getY() + "</y></point><triangle>");
    return triangleXML.toString();
  }
}