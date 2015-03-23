package serializers;

import groups.*;
import serializers.SerializerType;
import serializers.StringSerializable;
import shapes.*;

/**
 * Created by Alex on 22.03.2015.
 */
public class XMLSerializers {

  public String getSerializedValue(StringSerializable object) {
    if (object instanceof Group) {
      return serialize((Group)object);
    } else if (object instanceof Circle) {
      return serialize((Circle)object);
    } else if (object instanceof Rectangle) {
      return serialize((Rectangle) object);
    } else if (object instanceof Triangle) {
      return serialize((Triangle) object);
    }
    throw new IllegalArgumentException("The class " + object.getClass().getSimpleName() + " is not StringSerializable");
  }

  public String serialize(Circle circle) {
    StringBuilder xml = new StringBuilder();
    xml.append("<circle>");
    xml.append("\n");

    xml.append("<center>");
    xml.append("<x>" + circle.getCenter().getX() +"</x>");
    xml.append("<y>" + circle.getCenter().getY() + "</y>");
    xml.append("</center>");

    xml.append("\n");
    xml.append("<radius>");
    xml.append(circle.getRadius());
    xml.append("</radius>");

    xml.append("\n");
    xml.append("</circle>");
    return xml.toString();
  }

  public String serialize(Rectangle rectangle) {
    StringBuilder xml = new StringBuilder();
    xml.append("<rectangle>");
    xml.append("\n");

    xml.append("<topLeft>");
    xml.append("<x>" + rectangle.getTopLeft().getX() +"</x>");
    xml.append("<y>" + rectangle.getTopLeft().getY() + "</y>");
    xml.append("</topLeft>");

    xml.append("\n");
    xml.append("<width>");
    xml.append(rectangle.getWidth());
    xml.append("</width>");

    xml.append("\n");
    xml.append("<height>");
    xml.append(rectangle.getHeight());
    xml.append("</height>");

    xml.append("\n");
    xml.append("</rectangle>");
    return xml.toString();
  }

  public String serialize(Triangle triangle) {
    StringBuilder xml = new StringBuilder();
    xml.append("<triangle>");
    xml.append("\n");

    xml.append("<point1>");
    xml.append("<x>" + triangle.getPoint1().getX() + "</x>");
    xml.append("<y>" + triangle.getPoint1().getY() + "</y>");
    xml.append("</point1>");

    xml.append("\n");
    xml.append("<point2>");
    xml.append("<x>" + triangle.getPoint2().getX() + "</x>");
    xml.append("<y>" + triangle.getPoint2().getY() + "</y>");
    xml.append("</point2>");

    xml.append("\n");
    xml.append("<point3>");
    xml.append("<x>" + triangle.getPoint3().getX() + "</x>");
    xml.append("<y>" + triangle.getPoint3().getY() + "</y>");
    xml.append("</point3>");

    xml.append("\n");
    xml.append("</triangle>");
    return xml.toString();
  }

  public String serialize(Group group) {
    StringBuilder xml = new StringBuilder();
    xml.append("<group>");
    xml.append("\n");

    for (StringSerializable element:group) {
      xml.append(element.serialize(SerializerType.XML));
    }

    xml.append("\n");
    xml.append("</group>");
    return xml.toString();
  }
}
