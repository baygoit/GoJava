package ua.goit.adapter;

import ua.goit.model.ContainerShapes;
import ua.goit.model.Triangle;
import ua.goit.serializers.Serializer;

public class TriangleAdapterJSON implements Serializer{

  @Override
  public String serialize(ContainerShapes object) {
    Triangle triangle = (Triangle) object;
    
    StringBuilder json = new StringBuilder();
    json.append("{\"type\":\"TRIANGLE\",");

    json.append("\"point1\":{");
    json.append("\"x\":" + triangle.getPoint1().getX());
    json.append(",");
    json.append("\"y\":" + triangle.getPoint1().getY());
    json.append("}");
    json.append(",");

    json.append("\"point2\":{");
    json.append("\"x\":" + triangle.getPoint2().getX());
    json.append(",");
    json.append("\"y\":" + triangle.getPoint2().getY());
    json.append("}");
    json.append(",");

    json.append("\"point3\":{");
    json.append("\"x\":" + triangle.getPoint3().getX());
    json.append(",");
    json.append("\"y\":" + triangle.getPoint3().getY());
    json.append("}");

    json.append("}");
    return json.toString();
  }

}
