package ua.goit.adapter;

import ua.goit.model.ContainerShapes;
import ua.goit.model.Square;
import ua.goit.serializers.Serializer;

public class SquareAdapterJSON implements Serializer {

  @Override
  public String serialize(ContainerShapes container) {
    StringBuilder json = new StringBuilder();
    Square square = (Square) container;
    json.append("{\"type\":\"SQUARE\"");
    json.append(",");
    json.append("\"point1\":{");
    json.append("\"x\":" + square.getTopLeft().getX());
    json.append(",");
    json.append("\"y\":" + square.getTopLeft().getY());
    json.append("}");
    json.append(",");
    json.append("\"length\":" + square.getLength());
    json.append("}");
    return json.toString();  }
}
