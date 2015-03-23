package serializers;

import groups.Group;
import shapes.*;

/**
 * Created by Alex on 22.03.2015.
 */
public class JsonSerializers {

  public String getSerializedValue(StringSerializable object) {
    if (object instanceof Group) {
      return serialize((Group) object);
    } else if (object instanceof Circle) {
      return serialize((Circle) object);
    } else if (object instanceof Rectangle) {
      return serialize((Rectangle) object);
    } else if (object instanceof Triangle) {
      return serialize((Triangle) object);
    }
    throw new IllegalArgumentException("The class " + object.getClass().getSimpleName() + " is not StringSerializable");
  }

  public String serialize(Circle circle) {
    StringBuilder xml = new StringBuilder();
    xml.append("{circle:");
    xml.append("\n");

    xml.append("{center:");
    xml.append("{x:" + circle.getCenter().getX() +"}");
    xml.append("{y:" + circle.getCenter().getY() + "}");
    xml.append("}");

    xml.append("\n");
    xml.append("{radius:");
    xml.append(circle.getRadius());
    xml.append("}");

    xml.append("}");
    return xml.toString();
  }

  public String serialize(Rectangle rectangle) {
    StringBuilder xml = new StringBuilder();
    xml.append("{rectangle:");
    xml.append("\n");

    xml.append("{topLeft:");
    xml.append("{x:" + rectangle.getTopLeft().getX() +"}");
    xml.append("{y:" + rectangle.getTopLeft().getY() + "}");
    xml.append("}");

    xml.append("\n");
    xml.append("{width:");
    xml.append(rectangle.getWidth());
    xml.append("}");

    xml.append("\n");
    xml.append("{height:");
    xml.append(rectangle.getHeight());
    xml.append("}");

    xml.append("}");
    return xml.toString();
  }

  public String serialize(Triangle triangle) {
    StringBuilder xml = new StringBuilder();
    xml.append("{triangle:");
    xml.append("\n");

    xml.append("{point1:");
    xml.append("{x:" + triangle.getPoint1().getX() + "}");
    xml.append("{y:" + triangle.getPoint1().getY() + "}");
    xml.append("}");

    xml.append("\n");
    xml.append("{point2:");
    xml.append("{x:" + triangle.getPoint2().getX() + "}");
    xml.append("{y:" + triangle.getPoint2().getY() + "}");
    xml.append("}");

    xml.append("\n");
    xml.append("{point3:");
    xml.append("{x:" + triangle.getPoint3().getX() + "}");
    xml.append("{y:" + triangle.getPoint3().getY() + "}");
    xml.append("}");

    xml.append("}");
    return xml.toString();
  }

  public String serialize(Group group) {
    StringBuilder xml = new StringBuilder();
    xml.append("{group:");
    xml.append("\n");

    for (StringSerializable element:group) {
      xml.append(element.serialize(SerializerType.JSON));
    }

    xml.append("}");
    return xml.toString();
  }
}
