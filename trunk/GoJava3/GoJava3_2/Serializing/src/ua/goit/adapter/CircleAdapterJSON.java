package ua.goit.adapter;

import ua.goit.model.Circle;
import ua.goit.model.ContainerShapes;
import ua.goit.serializers.Serializer;

public class CircleAdapterJSON implements Serializer {

  @Override
  public String serialize(ContainerShapes container) {
    Circle circle = (Circle) container;

    StringBuilder json = new StringBuilder();
    json.append("{\"circle\":{");

    json.append("\"center\":{");
    json.append("\"x\":" + circle.getCenter().x);
    json.append(",");
    json.append("\"y\":" + circle.getCenter().y);
    json.append("}");
    json.append(",");

    json.append("\"radius\":" + circle.getRadius());

    json.append("}}");

    return json.toString();
  }

}
