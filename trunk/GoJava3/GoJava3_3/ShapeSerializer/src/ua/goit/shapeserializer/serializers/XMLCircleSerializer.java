/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers;

import ua.goit.shapeserializer.basicobjects.Circle;
import ua.goit.shapeserializer.basicobjects.Shape;

public class XMLCircleSerializer extends XMLShapeSerializer {
  @Override
  public String serialize(Shape shape) {
    StringBuilder circleXML = new StringBuilder();
    Circle circle = (Circle) shape;
    circleXML.append("<circle><center><point><x>");
    circleXML.append(circle.getCenter().getX() + "</x><y>");
    circleXML.append(circle.getCenter().getY());
    circleXML.append("</y></point></center><radius>");
    circleXML.append(circle.getRadius() + "</radius></circle>");
    return circleXML.toString();
  }
}