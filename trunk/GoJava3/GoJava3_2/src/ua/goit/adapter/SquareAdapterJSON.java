package ua.goit.adapter;

import ua.goit.model.ContainerShapes;
import ua.goit.model.Square;
import ua.goit.serializers.Serializer;

public class SquareAdapterJSON implements Serializer {

  @Override
  public String serialize(ContainerShapes container) {
    StringBuilder json = new StringBuilder();
    Square square = (Square) container;
    json.append("{\"square\":{");

    json.append("\"point1\":{");
    json.append("\"x\":" + square.getPoint1().x);
    json.append(",");
    json.append("\"y\":" + square.getPoint1().y);
    json.append("}");
    json.append(",");

    json.append("\"length\":" + square.getLength());

    json.append("}}");
    return json.toString();  }
}
