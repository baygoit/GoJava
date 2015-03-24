package ua.goit.adapter;

import ua.goit.model.Circle;
import ua.goit.model.ContainerShapes;
import ua.goit.serializers.Serializer;

public class CircleAdapterJSON implements Serializer {

  @Override
  public String serialize(ContainerShapes container) {
    Circle circle = (Circle) container;

    StringBuilder json = new StringBuilder();
    json.append("{\"radius\":" + circle.getRadius());
    json.append(",");
    json.append("\"center\":{");
    json.append("\"x\":" + circle.getCenter().getX());
    json.append(",");
    json.append("\"y\":" + circle.getCenter().getY());
    json.append("},\"type\":\"CIRCLE\"");
    json.append("}");

    return json.toString();
  }

}
