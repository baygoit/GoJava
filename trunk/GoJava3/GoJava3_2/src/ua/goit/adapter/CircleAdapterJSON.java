package ua.goit.adapter;

import ua.goit.managers.Serializer;
import ua.goit.model.Circle;

public class CircleAdapterJSON implements Serializer {
  private Circle circle;

  CircleAdapterJSON(Circle circle) {
    this.circle = circle;
  }

  @Override
  public String serialize() {
    StringBuilder json = new StringBuilder();
    json.append("{rectangle:");

    json.append("{center:");
    json.append("{x:" + circle.getCenter().x + "}");
    json.append("{y:" + circle.getCenter().y + "}");
    json.append("}");

    json.append("{radius:" + circle.getRadius() + "}");

    json.append("}");

    return json.toString();
  }

}
